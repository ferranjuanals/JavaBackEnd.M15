package com.exercici.jocdedaus.repositories.mongodb;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.exercici.jocdedaus.entities.Player;
import com.exercici.jocdedaus.repositories.PlayerRepository;

@Repository
@Profile("mongodb")
public interface MongoDbPlayerImpl extends PlayerRepository, MongoRepository<Player, Long> {
}
