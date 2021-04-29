package com.exercici.jocdedaus.repositories.mysql;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercici.jocdedaus.model.entities.Game;
import com.exercici.jocdedaus.repositories.GameRepository;


@Repository
@Profile("mysql")
public interface MySqlGameImpl extends GameRepository, JpaRepository<Game, String> {
	
}
