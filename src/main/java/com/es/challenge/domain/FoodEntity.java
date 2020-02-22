package com.es.challenge.domain;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name="tbl_food")
public class FoodEntity{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private Integer calories;
	@Column(name="img", columnDefinition="CLOB NOT NULL")
	@Lob
	private String img;

	private 	double price;

	@Override
	public String toString() {
		if (this !=null && name !=null) {
			return name;
		}
		return "";
	}
}
