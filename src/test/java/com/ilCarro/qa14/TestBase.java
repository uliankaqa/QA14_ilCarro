package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        //System.setProperty("webdriver.gecko.driver", "src/drivers/geckodriver");///Users/qa/Documents/QAManuell/AutoQA/GitHub/QA14UlianaLiman/src
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get("https://ilcarro-dev-v1.firebaseapp.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public boolean isFindeCarFormPresent() {
        return driver.findElements(By.cssSelector(".Main_mainpage__find_your_car__AHLkw")).size()>0;
    }

    public boolean isElementPresent(By locator){
        try{
           driver.findElements(locator);
           return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }

    //after - tearDown(){}
    @AfterMethod(enabled = true)
    public void tearDown(){
        driver.quit();//close all
        // driver.close();//close tab
    }
}
