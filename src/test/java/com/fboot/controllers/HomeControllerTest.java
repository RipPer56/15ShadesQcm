package com.fboot.controllers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
public class HomeControllerTest {
    
    private MockMvc mockMvc;
    
    @InjectMocks
    private HomeController homeController;
    
    public HomeControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.mockMvc = standaloneSetup(new HomeController()).build();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testIsCorrectLoginPassword() {
        System.out.println("isCorrectLoginPassword");
        String login = "test12";
        String password = "1234";
        boolean expResult = false;
        boolean result = homeController.isCorrectLoginPassword(login, password);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testIsNotCorrectLoginPassword() {
        System.out.println("isCorrectLoginPassword");
        String login = "balbal";
        String password = "126";
        boolean expResult = false;
        boolean result = homeController.isCorrectLoginPassword(login, password);
        assertEquals(expResult, result);
    }
    
}
