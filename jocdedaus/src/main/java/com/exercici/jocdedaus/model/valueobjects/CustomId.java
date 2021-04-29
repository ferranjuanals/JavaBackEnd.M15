package com.exercici.jocdedaus.model.valueobjects;

import java.util.Objects;
import java.util.UUID;

public class CustomId {

	private final String value;
	
	public CustomId(String value) {
		this.value = value;
	}
	
	public static CustomId newId() {
		return new CustomId(UUID.randomUUID().toString());
	}
	
	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return value;
	}
	
	@Override 
	public boolean equals(Object o) {
		if(this == o) return true;
		if(!(o instanceof CustomId)) return false;
		CustomId id = (CustomId) o;
		return value.equals(id.value);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
