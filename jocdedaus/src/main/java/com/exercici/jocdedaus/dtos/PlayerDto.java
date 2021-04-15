package com.exercici.jocdedaus.dtos;

import java.math.BigInteger;

public class PlayerDto {

	private BigInteger id;
	private String name;
	private String successPct;
	private Integer victories;
	private Integer totals;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSuccessPct() {
		return successPct;
	}
	public void setSuccessPct(String successPct) {
		this.successPct = successPct;
	}
	public Integer getVictories() {
		return victories;
	}
	public Integer getTotals() {
		return totals;
	}
	public void setVictories(Integer victories) {
		this.victories = victories;
	}
	public void setTotals(Integer totals) {
		this.totals = totals;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}
	public BigInteger getId() {
		return id;
	}
}
