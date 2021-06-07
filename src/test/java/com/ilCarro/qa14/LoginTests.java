package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void ensurePreconditions(){
        //go to logintest
        //if user logged in . click logout, go to login
        if(!isSignUpFormPresent()){
            //sign up not present
            //click on logout button
            logOut();
        }
    }

    public boolean isLogInTabPresent() {
        return isElementPresent1(By.xpath("//ul[@class=\"header__nav desktop\"]/li[5]"));

    }

    @Test
    public void loginRegisteredUserPositiveTest(){
        //go to login page
        click(By.xpath("//ul[@class=\"header__nav desktop\"]/li[5]"));
        //fill login form
        //fill email
       type(By.name("email"), "ulitruli1@gmail.com");
        //fill password
        type(By.name("password"), "!weAD5446");
        //click submit
        submit();
        //assert user logged in
        isLogOutTabPresent();
    }

}
