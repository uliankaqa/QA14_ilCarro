package com.ilCarro.qa14.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.NoSuchElementException;

public class HelperBase {
    public WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    //    public boolean isElementPresent(By by) {
//        return driver.findElements(by).size() > 0;
//    }
    public boolean isElementPresent1(By locator) {
        try {
            driver.findElements(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void pause() throws InterruptedException {
        Thread.sleep(2000);
    }

    //Fill forms methods
    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }






}
