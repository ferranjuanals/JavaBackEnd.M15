package com.exercici.jocdedaus.repositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.data.repository.NoRepositoryBean;

import com.exercici.jocdedaus.model.entities.Player;

@NoRepositoryBean
public interface PlayerRepository {
	
	void save(Player player);
	
	List<Player> findAll();
	
	Optional<Player> findById(String id);
	
	Optional<Player> findByName(String name);
	
	Stream<Player> findAllByOrderBySuccessPctDesc();

	Player findTop1ByOrderBySuccessPctDesc();

	Player findTop1ByOrderBySuccessPctAsc();

}