package com.es.challenge.rest.impl;
/*
import com.es.challenge.domain.Book;
import com.es.challenge.service.BookManagementService;
import com.es.challenge.service.ESAuthService;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.ws.rs.core.MediaType;
import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(MockitoJUnitRunner.class)
public class BookManagementApiImplTest {

    @Mock
    private BookManagementService bookManagementService;
    @Mock
    private ESAuthService esAuthService;


    private MockMvc mockMvc;
    private BookManagementApiImpl controller;


    private List<Book> books = asList(new Book(1L, "book1", "2019", 20L, asList("apple","banana","beans")) ,
            new Book(2L, "book2", "2018", 30L, asList("apple")));
    private Book book = new Book(3L, "book3", "2020", 50L, asList("meat"));
    private  String json;


    private  String key="admin";

    @Before
    public void init() {
        controller = new BookManagementApiImpl(bookManagementService,esAuthService);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        when(bookManagementService.getBooks()).thenReturn(books);
        when(bookManagementService.addBook(book)).thenReturn(true);
        when(bookManagementService.removeBook(1L)).thenReturn(true);
        when(esAuthService.isAdmin(key)).thenReturn(true);
        Gson gson = new Gson();
        json = gson.toJson(book);

    }

    @Test
    public void getBooks() throws Exception {
        this.mockMvc.perform(get("/public/getBooks"))
                .andExpect(status().isOk());
    }

    @Test
    public void addBook() throws Exception {
        this.mockMvc.perform(post("/admin/addBook")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Consumer-Key",key)
                .content(json))
                .andExpect(status().isOk());
    }

    @Test
    public void removeBook() throws Exception {
        this.mockMvc.perform(delete("/admin/removeBook/{id}",1)
                .contentType(MediaType.APPLICATION_JSON)
                .header("Consumer-Key","admin"))
                .andExpect(status().isOk());
    }
}
*/
