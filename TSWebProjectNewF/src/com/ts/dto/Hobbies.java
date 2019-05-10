package com.ts.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Hobbies {

	@Column
	private String hobby;
	
	public Hobbies(){
	}

	public Hobbies(String hobby) {
		super();
		this.hobby = hobby;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
}
