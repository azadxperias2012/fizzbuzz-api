package com.azad.fizzbuzz.api.fizzbuzzapi.controller;

import com.azad.fizzbuzz.api.fizzbuzzapi.FizzbuzzApiApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = FizzbuzzApiApplication.class)
@SpringBootTest
public class FizzBuzzApiControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    public void testFizzBuzzForSmallPositiveLimit() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/fizzbuzz/api/3"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("1, 2, Fizz"));
    }

    @Test
    public void testFizzBuzzForPositiveLimit() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/fizzbuzz/api/6"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("1, 2, Fizz, 4, Buzz, Fizz"));
    }

    @Test
    public void testFizzBuzzForLargePositiveLimit() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/fizzbuzz/api/15"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz"));
    }

    @Test
    public void testFizzBuzzForSmallNegativeLimit() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/fizzbuzz/api/-3"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Fizz, -2, -1"));
    }

    @Test
    public void testFizzBuzzForNegativeLimit() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/fizzbuzz/api/-9"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Fizz, -8, -7, Fizz, Buzz, -4, Fizz, -2, -1"));
    }

    @Test
    public void testFizzBuzzForLargeNegativeLimit() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/fizzbuzz/api/-15"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("FizzBuzz, -14, -13, Fizz, -11, Buzz, Fizz, -8, -7, Fizz, Buzz, -4, Fizz, -2, -1"));
    }
}