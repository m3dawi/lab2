package com.es.challenge.rest;

import com.es.challenge.domain.Book;
import com.es.challenge.domain.Response;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public interface BookManagementApi {
	@GetMapping(value = "/public/getBooks", produces= {MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(value="Return all Books with details", notes="This is a public API", response=List.class)
	@ApiResponse(code = HttpServletResponse.SC_OK, message = "Success")
	ResponseEntity getBooks();
	
	@PostMapping(value = "/public/getBooksByFood", produces= {MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(value="Return all Books by Foods", notes="This is a public API", response=List.class)
	@ApiResponses(value = { 
			@ApiResponse(code = HttpServletResponse.SC_OK, message = "Success"),
			@ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "Not found any Book by food")
	})
	ResponseEntity getBooksByFood(@RequestBody List<String> foods);
	
	@PostMapping(value = "/admin/addBook", 
			produces = {MediaType.APPLICATION_JSON_VALUE}, 
			consumes = {MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(value="Add a new Book with details", notes="This is a public API with admin right", response=Response.class)
	@ApiResponses(value = { 
			@ApiResponse(code = HttpServletResponse.SC_CREATED, message = "A new Book has been added successfully"),
			@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "Invalid Consumer Key")
	})
	ResponseEntity addBook(@RequestHeader(name = "Consumer-Key", required = false) String key, @RequestBody Book Book);
	
	@DeleteMapping(value = "/admin/removeBook/{id}")
	@ApiOperation(value="Remove an existing Book", notes="This is a public API with admin right", response=Response.class)
	@ApiResponses(value = { 
			@ApiResponse(code = HttpServletResponse.SC_NO_CONTENT, message = "The Book has been removed successfully"),
			@ApiResponse(code = HttpServletResponse.SC_UNAUTHORIZED, message = "Invalid Consumer Key"),
			@ApiResponse(code = HttpServletResponse.SC_NOT_FOUND, message = "The Book does not exist")
	})
	ResponseEntity removeBook(@RequestHeader(name = "Consumer-Key", required = false) String key, @PathVariable("id") Long BookId);
}
