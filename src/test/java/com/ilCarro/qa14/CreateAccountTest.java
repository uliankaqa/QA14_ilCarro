package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase{
    //preconditions : user should be logged out
    // click on SignUp Button
    @BeforeMethod
    public void ensureProcondition(){
        if(!isElementPresent(By.cssSelector("[href='/signup']"))){
            //sign up mot present
            //click on logout button
            driver.findElement(By.xpath("//a[contains(.,'logOut')]")).click();
        }
    }
    @Test
    public void signUpTest(){
        driver.findElement(By.cssSelector("[href='/signup']")).click();
        Assert.assertTrue(isElementPresent(By.cssSelector("form.signup__fields")));
        fillField(By.cssSelector("#first_name"), "Uli");
        fillField(By.cssSelector("#second_name"), "Truli");
        fillField(By.cssSelector("#email"), "ulitruli@gmail.com");
        fillField(By.cssSelector("#password"), "!weAD5445");
        



    }

    private void fillField(By locator, String text){
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }
    //fill registration form
    //click Submit button
    //check login form displayed


}
