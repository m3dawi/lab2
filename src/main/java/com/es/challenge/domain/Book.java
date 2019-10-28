package com.es.challenge.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book implements Serializable{
	private static final long serialVersionUID = -4087970586697604468L;

	private Long id;
	private String name;
	private String year;
	private Long price;
	List<String> food;
}
