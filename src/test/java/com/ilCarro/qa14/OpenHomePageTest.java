package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class OpenHomePageTest extends TestBase {
    //befor - setUp(){}

    //Test
    @Test
    public void homePageTest() {
        System.out.println("FindCarForm: " + isElementPresent1(By.cssSelector(".Main_mainpage__find_your_car__AHLkw")));
    }
}
