package com.exercici.jocdedaus.controllers;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.exercici.jocdedaus.dtos.GameDto;
import com.exercici.jocdedaus.dtos.PlayerDto;
import com.exercici.jocdedaus.services.PlayerService;

@RestController
@RequestMapping("/players")
public class PlayerController {

	@Autowired
	private PlayerService playerService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addPlayer(@RequestBody PlayerDto playerDto) {
		playerService.savePlayer(playerDto);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<PlayerDto> getPlayers() {
		return playerService.findAllPlayers();
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void editPlayer(@PathVariable("id") BigInteger playerId, @RequestBody PlayerDto newName) {
		playerService.editPlayerName(playerId, newName);
	}
	
	@PostMapping("/{id}/games")
	@ResponseStatus(HttpStatus.CREATED)
	public GameDto addGameToPlayer(@PathVariable("id") BigInteger playerId) {
		return playerService.addGameToPlayer(playerId);
	}
	
	@GetMapping("/{id}/games")
	@ResponseStatus(HttpStatus.OK)
	public List<GameDto> getGamesByPlayer(@PathVariable("id") BigInteger playerId) {
		return playerService.getGamesByPlayer(playerId);
	}
	
	@DeleteMapping("/{id}/games")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void deleteAllGamesByPlayer(@PathVariable("id") BigInteger playerId) {
		playerService.deleteAllGamesByPlayer(playerId);
	}
	
	@GetMapping("/ranking")
	@ResponseStatus(HttpStatus.OK)
	public List<PlayerDto> getPlayersBySuccessAvg() {
		return playerService.getPlayersBySuccessPct();
	}
	
	@GetMapping("/ranking/winner")
	@ResponseStatus(HttpStatus.OK)
	public PlayerDto getFirstPlayerBySuccessAvg() {
		return playerService.getFirstPlayerBySuccessPct();
	}

	@GetMapping("/ranking/loser")
	@ResponseStatus(HttpStatus.OK)
	public PlayerDto getLastPlayerBySuccessAvg() {
		return playerService.getLastPlayerBySuccessPct();
	}
	
}
