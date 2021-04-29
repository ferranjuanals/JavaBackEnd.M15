package com.exercici.jocdedaus.dtos;

public class PlayerDto {

	private String id;
	private String name;
	private Boolean anonymous;
	private String successPct;
	private Integer victories;
	private Integer totals;

	public String getId() {
		return id;
	}
	
	public void setId(String customId) {
		this.id = customId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Boolean getAnonymous() {
		return anonymous;
	}

	public void setAnonymous(Boolean anonymous) {
		this.anonymous = anonymous;
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

}
