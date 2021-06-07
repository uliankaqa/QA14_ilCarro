package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTest extends TestBase{

    //Click on the [Search] button
    @Test
    public void findSearchTest() {
        click(By.xpath("//ul[@class='header__nav desktop']/li[1]"));
        Assert.assertTrue(isElementPresent1(By.cssSelector(".search-sidebar__content")));
    }

    //Click on the [let the car work] button
    @Test
    public void findLetTheCarWorkTest(){
        click(By.xpath("//ul[@class='header__nav desktop']/li[2]"));
       Assert.assertTrue(isElementPresent1(By.cssSelector(".let-carwork-style_let_car__work__2nUyo.let-carwork-style_container__2JKHv")));
    }

    //Click on [Sign up] button
    @Test
    public void findSignUpTest(){
        click(By.xpath("//ul[@class='header__nav desktop']/li[4]"));
        Assert.assertTrue(isElementPresent1(By.cssSelector(".signup__right_block")));
    }

    //Click on [Log in] button
    @Test
    public void findLogIn(){
        click(By.xpath("//ul[@class='header__nav desktop']/li[2]"));
        isLoginFormPresent();
    }

//Click on [Terms of use] button,
   // @Test
//    public void findTermsOfUseTabTest() {
//        click(By.xpath("//ul[@class='header__nav desktop']/li[3]"));
//        Assert.assertTrue(isElementPresent1(By.xpath("//div[contains(.,'Terms')]")));

//    }
}
