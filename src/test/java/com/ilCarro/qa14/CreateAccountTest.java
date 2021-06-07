package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase{
    //preconditions : user should be logged out
    // click on SignUp Button
    @BeforeMethod
    public void ensurePrecondition(){
        if(!isSignUpFormPresent()){
            //sign up mot present
            //click on logout button
            logOut();
        }
    }

    @Test
    public void signUpTest(){
        click(By.cssSelector("[href='/signup']"));
        isLoginFormPresent();
        type(By.cssSelector("#first_name"), "Uli1");
        type(By.cssSelector("#second_name"), "Truli1");
        type(By.cssSelector("#email"), "ulitruli1@gmail.com");
        type(By.cssSelector("#password"), "!weAD5446");
        click(By.cssSelector("#check_policy"));
        submit();
        Assert.assertTrue(isElementPresent1(By.cssSelector(".Login_login__right_block__1niYm")));

    }

    //fill registration form
    //click Submit button
    //check login form displayed


}
