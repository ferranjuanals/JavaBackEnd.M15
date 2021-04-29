package com.exercici.jocdedaus.services;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.exercici.jocdedaus.dtos.GameDto;
import com.exercici.jocdedaus.model.entities.Game;
import com.exercici.jocdedaus.model.entities.Player;
import com.exercici.jocdedaus.model.valueobjects.CustomId;
import com.exercici.jocdedaus.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	// Create and save a new Game to the repository and return the value of the dice and result
	public GameDto addGame(Player player) {
		Game game = game(player);
		gameRepository.save(game);
		return this.mapEntityToDto(game);
	}
	
	@Transactional
	public List<GameDto> getGamesByPlayer(Player player) {
		return gameRepository.findAllByPlayerId(player.getId()).map(game -> this.mapEntityToDto(game)).collect(Collectors.toList());
	}
	
	@Transactional
	public void deleteGamesByPlayer(Player player) {
		gameRepository.deleteAllByPlayerId(player.getId());
	}
	
	public Integer countTotalGamesByPlayer(Player player) {
		return gameRepository.countByPlayerId(player.getId());
	}
	
	public Integer countVictoryGamesByPlayer(Player player) {
		return gameRepository.countByPlayerIdAndVictoryTrue(player.getId());
	}
	
	// Create a Game and set the dice values
	private Game game(Player player) {
		Game game = new Game();
		game.setId(CustomId.newId().toString());
		Integer dice1 = rollDice();
		Integer dice2 = rollDice();
		game.setPlayer(player);
		game.setDice1Value(dice1);
		game.setDice2Value(dice2);
		if(dice1 + dice2 == 7) {
			game.setVictory(true);
		}else {
			game.setVictory(false);
		}
		return game;
	}
	
	// Roll the dice
	private Integer rollDice() {
		Random random = new Random();
		return random.nextInt(6) + 1;
	}
	
	private GameDto mapEntityToDto(Game entity) {
		GameDto dto = new GameDto();
		dto.setDice1Value(entity.getDice1Value());
		dto.setDice2Value(entity.getDice2Value());
		if(entity.getVictory()) {
			dto.setResult("Victory");
		}else {
			dto.setResult("Defeat");
		}
		return dto;
	}
	
}
