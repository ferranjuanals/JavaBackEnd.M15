package com.exercici.jocdedaus.entities;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Table(name = "Players")
@Document
public class Player {
	
	@Id
	@SequenceGenerator(name = "playerSequence", sequenceName = "playerSequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "playerSequence")
	@Column(name = "Id", updatable = false, nullable = false)
	private BigInteger id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Success_Pct", nullable = false)
	private Double successPct;
	
	@Column(name = "Registration_Date", nullable = false)
	private LocalDate registrationDate;
	
	@OneToMany(mappedBy = "player")
	private List<Game> games;

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
