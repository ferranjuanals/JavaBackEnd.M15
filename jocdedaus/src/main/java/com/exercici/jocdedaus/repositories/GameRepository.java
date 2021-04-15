package com.exercici.jocdedaus.repositories;

import java.math.BigInteger;
import java.util.stream.Stream;

import org.springframework.data.repository.NoRepositoryBean;

import com.exercici.jocdedaus.entities.Game;

@NoRepositoryBean
public interface GameRepository {

	void save(Game game);
	
	Stream<Game> findAllByPlayerId(BigInteger playerId);

	void deleteAllByPlayerId(BigInteger playerId);

	Integer countByPlayerId(BigInteger playerId);

	Integer countByPlayerIdAndVictoryTrue(BigInteger playerId);

}