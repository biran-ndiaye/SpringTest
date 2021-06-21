package com.example.demo;

import com.example.demo.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetEmployees() throws Exception {
       // System.out.println(get("/employees"));
        mockMvc.perform(get("/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].firstName", is("Laurent")));
                System.out.println("Successful test");
    }

    @Test
    public void testGetAnEmployee() throws Exception{
        mockMvc.perform(get("/employee/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is("Sophie")));
        System.out.println("Successful test");
    }

    @Test
    public void testDeleteAnEmployee() throws Exception{
        mockMvc.perform(delete("/employee/11"))
                .andExpect(status().isOk());
        System.out.println("Successful test");
    }


    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void testAddEmployee() throws Exception{
        Employee e = new Employee();
        e.setFirstName("Biran");
        e.setLastName("Ndiaye");
        e.setEmail("ndaiye2014.bn@gmail.com");
        e.setPassword("mypassword");
        // System.out.println(get("/employees"));
        mockMvc.perform(MockMvcRequestBuilders
        .post("/employee").content(asJsonString(e)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is("Biran")));

    }

    @Test
    public void testUpdateEmployee() throws Exception{
        Employee e = new Employee();
        e.setId(10L);
        e.setFirstName("Moussa");
        e.setLastName("Diadhiou");
        e.setEmail("Moussa@gmail.com");
        e.setPassword("mypassword");
        // System.out.println(get("/employees"));
        mockMvc.perform(MockMvcRequestBuilders
                .put("/employee/"+e.getId()).content(asJsonString(e)).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is("Moussa")));

    }

}
