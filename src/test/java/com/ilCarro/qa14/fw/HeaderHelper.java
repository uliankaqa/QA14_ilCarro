package com.ilCarro.qa14.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HeaderHelper extends HelperBase{
    public HeaderHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnSignUpTab() {
        click(By.cssSelector("[href='/signup']"));
    }

    public void clickOnSearchTab() {
        click(By.xpath("//ul[@class='header__nav desktop']/li[1]"));
    }

    public void clickOnLogInTab() {
        click(By.xpath("//ul[@class=\"header__nav desktop\"]/li[5]"));
    }

    public void clickOnAddCarTab() {
        click(By.xpath("//ul[@class='header__nav desktop']/li[2]"));
    }

    public void logOut() {
        click(By.xpath("//a[contains(.,'logOut')]"));
    }

    //Sign Up
    public boolean isSignUpTabPresent() {
        return isElementPresent1(By.cssSelector("[href='/signup']"));

    }



    //Log Out
    public boolean isLogOutTabPresent() {
       return isElementPresent1(By.xpath("//a[contains(.,'logOut')]"));
        //Assert.assertTrue(isElementPresent(By.xpath("//a[contains(.,'logOut')]")));
    }

    //Search page, form "Find your car now!"
    public void isSearchFormPresent() {
        Assert.assertTrue(isElementPresent1(By.cssSelector(".search-sidebar__content")));
    }

    //Log In
    public boolean isLogInTabPresent() {
        return isElementPresent1(By.xpath("//ul[@class=\"header__nav desktop\"]/li[5]"));

    }
}
