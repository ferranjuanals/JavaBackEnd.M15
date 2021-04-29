package com.exercici.jocdedaus.repositories;

import java.util.stream.Stream;

import org.springframework.data.repository.NoRepositoryBean;

import com.exercici.jocdedaus.model.entities.Game;

@NoRepositoryBean
public interface GameRepository {

	void save(Game game);
	
	Stream<Game> findAllByPlayerId(String playerId);

	void deleteAllByPlayerId(String playerId);

	Integer countByPlayerId(String playerId);

	Integer countByPlayerIdAndVictoryTrue(String playerId);

}