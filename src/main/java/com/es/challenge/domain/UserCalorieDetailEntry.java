package com.es.challenge.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
@NoArgsConstructor
public class UserCalorieDetailEntry {
	private Long foodId;
    private String name;
    private Long calories;

    public UserCalorieDetailEntry(Long foodId, String foodName, Long calories) {
    }




}


