package com.fboot.controllers;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Duration;
import org.openqa.selenium.support.ui.Sleeper;

public class ChromeTest {

/*@Test
public void LaunchChrome_Method1() {
    System.setProperty("webdriver.chrome.driver", "D:\\env\\tools\\chromedriver.exe");

    WebDriver scenario1 = new ChromeDriver();
    scenario1.get("http://127.0.0.1:8080/");
    
    WebElement usernameCorrect = scenario1.findElement(By.name("name"));
    usernameCorrect.sendKeys("bennouna");

    WebElement passwordIncorrect = scenario1.findElement(By.name("password"));
    passwordIncorrect.sendKeys("1234");

    try {
        Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    usernameCorrect.submit();
    scenario1.findElement(By.name("newQCM")).click();
    scenario1.findElement(By.name("titre")).sendKeys("QCMtest");
    scenario1.findElement(By.name("seuil")).clear();
    scenario1.findElement(By.name("seuil")).sendKeys("10");
    scenario1.findElement(By.name("duree")).clear();
    scenario1.findElement(By.name("duree")).sendKeys("2");

    try {
        Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    scenario1.findElement(By.name("duree")).submit();

    scenario1.findElement(By.name("ajouterQ")).click();
    try {
        Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    scenario1.findElement(By.name("3")).click();

    scenario1.findElement(By.name("enonce")).sendKeys("la premier question");
    scenario1.findElement(By.name("choix1")).clear();
    scenario1.findElement(By.name("choix1")).sendKeys("choix correcte");
    scenario1.findElement(By.name("choix2")).clear();
    scenario1.findElement(By.name("choix2")).sendKeys("choix incorrecte 2");
    scenario1.findElement(By.name("choix3")).clear();
    scenario1.findElement(By.name("choix3")).sendKeys("choix incorrecte 3");
    try {
        Sleeper.SYSTEM_SLEEPER.sleep(new Duration(2, TimeUnit.SECONDS));
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    scenario1.findElement(By.name("choix3")).submit();


    WebDriver scenario2 = new ChromeDriver();
    scenario2.get("http://127.0.0.1:8080/");
    WebElement usernameInCorrect = scenario2.findElement(By.name("name"));
    usernameInCorrect.sendKeys("balbal");

    WebElement passwordCorrect = scenario2.findElement(By.name("password"));
    passwordCorrect.sendKeys("1235");

    try {
        Sleeper.SYSTEM_SLEEPER.sleep(new Duration(3, TimeUnit.SECONDS));
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    usernameInCorrect.submit();

    scenario2.findElement(By.name("diag")).click();
    scenario2.findElement(By.name("3")).click();
    scenario2.findElement(By.name("choix correcte")).click();
    scenario2.findElement(By.name("choix correcte")).submit();

    }*/
}
