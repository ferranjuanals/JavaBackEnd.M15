package com.exercici.jocdedaus.repositories;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.repository.NoRepositoryBean;

import com.exercici.jocdedaus.entities.Player;

@NoRepositoryBean
public interface PlayerRepository {
	
	void save(Player player);
	
	List<Player> findAll();
	
	Optional<Player> findById(BigInteger id);
	
	Stream<Player> findAllByOrderBySuccessPctDesc();

	Player findTop1ByOrderBySuccessPctDesc();

	Player findTop1ByOrderBySuccessPctAsc();

}