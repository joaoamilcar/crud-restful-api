package br.com.example.model;

import java.util.Calendar;

public class SampleEntity {
	
	private Long id;
	private String name;
	private Calendar creation;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Calendar getCreation() {
		return creation;
	}
	
	public void setCreation(Calendar creation) {
		this.creation = creation;
	}
	
}
