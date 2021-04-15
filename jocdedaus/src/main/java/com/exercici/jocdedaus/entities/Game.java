package com.exercici.jocdedaus.entities;

import java.math.BigInteger;

import javax.persistence.*;

import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Table(name="Games")
@Document
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", unique = true, updatable = false, nullable = false)
	private BigInteger id;
	
	@Column(name = "Dice_1_Value", updatable = false, nullable = false)
	private Integer dice1Value;
	
	@Column(name = "Dice_2_Value", updatable = false, nullable = false)
	private Integer dice2Value;
	
	@Column(name = "Victory", updatable = false, nullable = false)
	private Boolean victory;
	
	@JoinColumn(name = "Player")
	@ManyToOne(optional = false, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Player player;

	public Integer getDice1Value() {
		return dice1Value;
	}

	public void setDice1Value(Integer dice1Value) {
		this.dice1Value = dice1Value;
	}

	public Integer getDice2Value() {
		return dice2Value;
	}

	public void setDice2Value(Integer dice2Value) {
		this.dice2Value = dice2Value;
	}

	public Boolean getVictory() {
		return victory;
	}

	public void setVictory(Boolean victory) {
		this.victory = victory;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
	
}
