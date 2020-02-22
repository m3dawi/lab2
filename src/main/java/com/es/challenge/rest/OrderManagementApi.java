package com.es.challenge.rest;

import com.es.challenge.domain.Book;
import com.es.challenge.domain.Order;
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
@CrossOrigin
public interface OrderManagementApi {
	@GetMapping(value = "/public/getOrdersHistory", produces= {MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(value="Return all Orders with details", notes="This is a public API", response=List.class)
	@ApiResponse(code = HttpServletResponse.SC_OK, message = "Success")
	ResponseEntity getOrdersHistory();


	@PostMapping(value = "/public/addOrder",
			produces = {MediaType.APPLICATION_JSON_VALUE})
	@ApiOperation(value="Add a new Order with details", notes="This is a public API with admin right", response=Response.class)
	@ApiResponses(value = {
			@ApiResponse(code = HttpServletResponse.SC_CREATED, message = "A new Order has been added successfully")
	})
	ResponseEntity addOrder(@RequestParam int numOfItems);
	}
