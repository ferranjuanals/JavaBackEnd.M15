package com.exercici.jocdedaus.services;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.exercici.jocdedaus.dtos.GameDto;
import com.exercici.jocdedaus.dtos.PlayerDto;
import com.exercici.jocdedaus.exceptions.IdNotFoundException;
import com.exercici.jocdedaus.exceptions.NameNotValidException;
import com.exercici.jocdedaus.model.entities.Player;
import com.exercici.jocdedaus.model.valueobjects.CustomId;
import com.exercici.jocdedaus.repositories.PlayerRepository;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	@Autowired
	private GameService gameService;
	
	public void savePlayer(PlayerDto playerDto) {
		checkPlayerName(playerDto.getName());
		playerRepository.save(this.mapDtoToEntity(playerDto));
	}
	
	// Find a player, set the new name and save it to repository
	public void editPlayerName(String id, PlayerDto newName) {
		Player player = playerRepository.findById(id).orElseThrow(() -> new IdNotFoundException(id));
		player.setName(newName.getName());
		playerRepository.save(player);
	}
	
	public List<PlayerDto> findAllPlayers() {
		return playerRepository.findAll().stream().map(player -> this.mapEntityToDto(player)).collect(Collectors.toList());
	}
	
	// Find a player, add a new Game, update the percentage of success and return the value of the dice and result
	public GameDto addGameToPlayer(String playerId) {
		Player player = playerRepository.findById(playerId).orElseThrow(() -> new IdNotFoundException(playerId));
		GameDto newGame = gameService.addGame(player);
		this.updateSuccessPctOfPlayer(playerId);
		return newGame;
	}

	public List<GameDto> getGamesByPlayer(String id) {
		Player player = playerRepository.findById(id).orElseThrow(() -> new IdNotFoundException(id));
		return gameService.getGamesByPlayer(player);
	}
	
	// Deletes all games of a player
	public void deleteAllGamesByPlayer(String id) {
		Player player = playerRepository.findById(id).orElseThrow(() -> new IdNotFoundException(id));
		gameService.deleteGamesByPlayer(player);
	}
	
	@Transactional 
	public List<PlayerDto> getPlayersBySuccessPct() {
		return playerRepository.findAllByOrderBySuccessPctDesc().map(player -> this.mapEntityToDto(player)).collect(Collectors.toList());		
	}

	public PlayerDto getFirstPlayerBySuccessPct() {
		return this.mapEntityToDto(playerRepository.findTop1ByOrderBySuccessPctDesc());
	}

	public PlayerDto getLastPlayerBySuccessPct() {
		return this.mapEntityToDto(playerRepository.findTop1ByOrderBySuccessPctAsc());
	}
	
	// Find a player, calculates the percentage of success, sets the recalculated value and saves it in the repository
	private void updateSuccessPctOfPlayer(String playerId) {
		Player player = playerRepository.findById(playerId).orElseThrow(() -> new IdNotFoundException(playerId));
		Integer victories = gameService.countVictoryGamesByPlayer(player);
		Integer totals = gameService.countTotalGamesByPlayer(player);
		Double successPct = (victories / (double) totals) * 100;
		player.setSuccessPct(successPct);
		playerRepository.save(player);
	}
	
	// Check if the player name is null or blank, and that is unique
	private void checkPlayerName(String playerName) {
		if(!StringUtils.hasText(playerName)) throw new NameNotValidException(playerName);
		if(playerRepository.findByName(playerName).isPresent()) throw new NameNotValidException(playerName);
	}
	
	private Player mapDtoToEntity(PlayerDto dto) {
		Player entity = new Player();
		entity.setId(CustomId.newId().toString());
		entity.setName(dto.getName());
		entity.setAnonymous(dto.getAnonymous());
		entity.setRegistrationDate(LocalDate.now());
		// Initial percentage of success is 0.0
		entity.setSuccessPct(0.0);
		return entity;
	}
	
	private PlayerDto mapEntityToDto(Player entity) {
		PlayerDto dto = new PlayerDto();
		dto.setId(entity.getId().toString());
		// If the player has choose to be anonymous, set name as "Anonymous"
		if(entity.getAnonymous()) {
			dto.setName("Anonymous");
		}else {
			dto.setName(entity.getName());
		}
		dto.setAnonymous(entity.getAnonymous());
		// Format the percentage of success with decimal point and two positions
		DecimalFormat df = (DecimalFormat) DecimalFormat.getInstance(Locale.US);
		df.applyPattern("#.##");
		dto.setSuccessPct(df.format(entity.getSuccessPct()));
		dto.setVictories(gameService.countVictoryGamesByPlayer(entity));
		dto.setTotals(gameService.countTotalGamesByPlayer(entity));
		return dto;
	}

}
