/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fboot.controllers;

import javax.servlet.http.HttpServletRequest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author RipPer
 */
public class EtudiantControllerTest {
    
    public EtudiantControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of welcome method, of class EtudiantController.
     */
    @Test
    public void testWelcome() {
        System.out.println("welcome");
        EtudiantController instance = new EtudiantController();
        ModelAndView expResult = null;
        ModelAndView result = instance.welcome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of choisirType method, of class EtudiantController.
     */
    @Test
    public void testChoisirType() {
        System.out.println("choisirType");
        String type = "";
        HttpServletRequest request = null;
        EtudiantController instance = new EtudiantController();
        ModelAndView expResult = null;
        ModelAndView result = instance.choisirType(type, request);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afficherQuestion method, of class EtudiantController.
     */
    @Test
    public void testAfficherQuestion() {
        System.out.println("afficherQuestion");
        int idQcm = 0;
        int n = 0;
        EtudiantController instance = new EtudiantController();
        ModelAndView expResult = null;
        ModelAndView result = instance.afficherQuestion(idQcm, n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of afficherReponse method, of class EtudiantController.
     */
    @Test
    public void testAfficherReponse() {
        System.out.println("afficherReponse");
        HttpServletRequest request = null;
        int idQcm = 0;
        int n = 0;
        String choix = "";
        EtudiantController instance = new EtudiantController();
        ModelAndView expResult = null;
        ModelAndView result = instance.afficherReponse(request, idQcm, n, choix);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
