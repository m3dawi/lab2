package com.es.challenge.repository;

import com.es.challenge.domain.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<BookEntity, Long>{
	

//	@Query("SELECT Book FROM BookEntity Book WHERE Book.calories BETWEEN :min AND :max")
//	List<BookEntity> searchBookByRange(@Param("min") int min, @Param("max") int max);max

	List<BookEntity> findByFood_NameIn(@Param("food") List<String> food);

}
