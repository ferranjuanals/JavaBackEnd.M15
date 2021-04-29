package com.exercici.jocdedaus.model.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Table(name = "Players")
@Document(collection = "players")
public class Player {
	
	@Id
	@Column(name = "Id", unique = true, updatable = false, nullable = false)
	private String id;
	
	@Column(name = "Name", unique = true, updatable = true, nullable = false)
	private String name;
	
	@Column(name = "Anonymous", updatable = true, nullable = false)
	private Boolean anonymous;
	
	@Column(name = "Success_Pct", nullable = false)
	private Double successPct;
	
	@Column(name = "Registration_Date", nullable = false)
	private LocalDate registrationDate;
	
	@OneToMany(mappedBy = "player")
	private List<Game> games;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Double getSuccessPct() {
		return successPct;
	}

	public void setSuccessPct(Double successPct) {
		this.successPct = successPct;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}
	
}
