package com.exercici.jocdedaus.dtos;

public class GameDto {

	private Integer dice1Value;
	private Integer dice2Value;
	private String result;
	
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
}
