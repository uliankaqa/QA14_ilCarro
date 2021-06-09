package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTest extends TestBase{

    //Click on the [Search] button
    @Test
    public void findSearchTest() {
        clickOnSearchTab();
        isSearchFormPresent();
    }

    //Click on the [let the car work] button
    @Test
    public void findLetTheCarWorkTest(){
        clickOnAddCarTab();
        isAddCarFormPresent();
    }

    //Click on [Sign up] button
    @Test
    public void findSignUpTest(){
        clickOnSignUpTab();
        isSignUpFormPresent();
    }

    //Click on [Log in] button
    @Test
    public void findLogInTest(){
        clickOnLogInTab();
        isLogInTabPresent();
    }

//Click on [Terms of use] button,
   // @Test
//    public void findTermsOfUseTabTest() {
//        click(By.xpath("//ul[@class='header__nav desktop']/li[3]"));
//        Assert.assertTrue(isElementPresent1(By.xpath("//div[contains(.,'Terms')]")));

//    }
}
