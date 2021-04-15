package com.exercici.jocdedaus.repositories.mongodb;

import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.exercici.jocdedaus.entities.Game;
import com.exercici.jocdedaus.repositories.GameRepository;

@Repository
@Profile("mongodb")
public interface MongoDbGameImpl extends GameRepository, MongoRepository<Game, Long> {

}
