package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    static WebDriver driver;

    @BeforeSuite
    public void setUp(){
        //System.setProperty("webdriver.gecko.driver", "src/drivers/geckodriver");///Users/qa/Documents/QAManuell/AutoQA/GitHub/QA14UlianaLiman/src
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get("https://ilcarro-dev-v1.firebaseapp.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

//    public boolean isElementPresent() {
//        return driver.findElement(By.cssSelector(".Main_mainpage__find_your_car__AHLkw")).size()>0;
//    }

    public boolean isElementPresent1(By locator){
        try{
           driver.findElements(locator);
           return true;
        }catch(NoSuchElementException e){
            return false;
        }
    }

    //after - tearDown(){}
    @AfterMethod(enabled = false)
    public void tearDown(){
        driver.quit();//close all
        // driver.close();//close tab
    }

    public void logOut() {
        driver.findElement(By.xpath("//a[contains(.,'logOut')]")).click();
    }

    public boolean isSignUpFormPresent() {
        return isElementPresent1(By.cssSelector("[href='/signup']"));
    }

    public void isLoginFormPresent() {
        Assert.assertTrue(isElementPresent1(By.cssSelector("form.signup__fields")));
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text){
        click(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void submit() {
        click(By.cssSelector("[type=\"submit\"]"));
    }

    public void isLogOutTabPresent() {
        Assert.assertTrue(isElementPresent1(By.xpath("//a[contains(.,'logOut')]")));
    }

    public void jumpToFooter(){
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.COMMAND, Keys.END);
    }
}
