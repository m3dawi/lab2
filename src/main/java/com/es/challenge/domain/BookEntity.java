package com.es.challenge.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="tbl_book")
public class BookEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String year;
	private Long price;
	@OneToMany
	List<FoodEntity> food;

}
