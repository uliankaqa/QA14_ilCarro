package com.ilCarro.qa14.tests;

import org.testng.annotations.Test;

public class HeaderTest extends TestBase {

    //Click on the [Search] button
    @Test
    public void findSearchTest() {
        app.header().clickOnSearchTab();
        app.header().isSearchFormPresent();
    }

    //Click on the [let the car work] button
    @Test
    public void findLetTheCarWorkTest(){
        app.header().clickOnAddCarTab();
        app.car().isAddCarFormPresent();
    }

    //Click on [Sign up] button
    @Test
    public void findSignUpTest(){
        app.header().clickOnSignUpTab();
        app.user().isSignUpFormPresent();
    }

    //Click on [Log in] button
    @Test
    public void findLogInTest(){
        app.header().clickOnLogInTab();
        app.header().isLogInTabPresent();
    }

//Click on [Terms of use] button,
   // @Test
//    public void findTermsOfUseTabTest() {
//        click(By.xpath("//ul[@class='header__nav desktop']/li[3]"));
//        Assert.assertTrue(isElementPresent1(By.xpath("//div[contains(.,'Terms')]")));

//    }

}
