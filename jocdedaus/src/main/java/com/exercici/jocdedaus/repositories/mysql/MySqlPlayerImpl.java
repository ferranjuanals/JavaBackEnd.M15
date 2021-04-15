package com.exercici.jocdedaus.repositories.mysql;

import java.math.BigInteger;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exercici.jocdedaus.entities.Player;
import com.exercici.jocdedaus.repositories.PlayerRepository;


@Repository
@Profile("mysql")
public interface MySqlPlayerImpl extends PlayerRepository, JpaRepository<Player, BigInteger> {
}
