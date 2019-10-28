package com.es.challenge.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class UserCalorieDailyEntry {
	@JsonProperty(value="entries")
	private List<UserCalorieDetailEntry> userDailyEntries = new ArrayList<UserCalorieDetailEntry>();
    private String date;
    private Long total;
    
    public void addUserCalorieDetailEntry(UserCalorieDetailEntry entry) {
    	this.userDailyEntries.add(entry);
    }

    public List<UserCalorieDetailEntry> getUserDailyEntries() {
        return userDailyEntries;
    }

    public void setUserDailyEntries(List<UserCalorieDetailEntry> userDailyEntries) {
        this.userDailyEntries = userDailyEntries;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
