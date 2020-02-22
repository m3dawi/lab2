package com.es.challenge.repository;

import com.es.challenge.domain.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

}
