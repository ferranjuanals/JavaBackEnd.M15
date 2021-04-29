package com.exercici.jocdedaus.repositories.mysql;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercici.jocdedaus.model.entities.Player;
import com.exercici.jocdedaus.repositories.PlayerRepository;


@Repository
@Profile("mysql")
public interface MySqlPlayerImpl extends PlayerRepository, JpaRepository<Player, String> {
}
