package com.es.challenge.domain;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class CalorieViewTrackingRequest {
	@NotEmpty(message="This is a required field")
	private Long userId;

	private String date;	// format as MMddyyyy

    public Long getUserId() {
    	return userId;
    }

	public String getDate() {
    	return date;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
