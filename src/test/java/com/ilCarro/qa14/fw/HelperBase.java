package com.ilCarro.qa14.fw;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
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
            //driver.findElement(locator).clear();
            //driver.findElement(locator).sendKeys(text);
            driver.findElement(locator).sendKeys(Keys
                    .chord(Keys.CONTROL,"a") + Keys.DELETE + text);
        }
    }

    //clear form methods
    public void clear(By locator) {
        click(locator);
        driver.findElement(locator).clear();
    }

    //Screenshots maker

    public String takeScreenshot(){
        File tmp = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//OutputType.FILE - small wight
                                                                   // OutputType.BASE64 - quickly
        File screenshot = new File("src/test/screenshots/screenshot" + System.currentTimeMillis() + ".png");
        try {
            Files.copy(tmp, screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshot.getAbsolutePath();

    }




}
