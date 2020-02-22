package com.es.challenge.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name="tbl_order")
public class OrderEntity {
    @Id
    private int orderID;
    private int numOfItems;
    private String dateCreated;


    public OrderEntity(int numOfItems) {
        Random randomGenerator = new Random();
        this.orderID= randomGenerator.nextInt(1000) + 1000;
        this.dateCreated= Calendar.getInstance().getTime().toString();
        this.numOfItems=numOfItems;
    }
    public OrderEntity() {
        Random randomGenerator = new Random();
        this.orderID= randomGenerator.nextInt(1000) + 1000;
        this.dateCreated= Calendar.getInstance().getTime().toString();
        this.numOfItems=0;
    }
}
