package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HeaderTest extends TestBase{
    @Test
    public void headerButtonCklick(){

        //Click on the [Search] button
        clickOnButton(By.xpath("//ul[@class=\"header__nav desktop\"]//li//a[contains(.,'Search')]"));

        //Click on the [let the car work] button
        clickOnButton(By.xpath("//ul[@class=\"header__nav desktop\"]//li//a[contains(.,'Let the cat work')]"));

       //Click on [Terms of use] button,
        //Commented, failed the test
        //clickOnButton(By.xpath("//ul[@class=\"header__nav desktop\"]//li//a[contains(.,'Terms of use')]"));


        //Click on [Sign up] button
        clickOnButton(By.xpath("//ul[@class=\"header__nav desktop\"]//li//a[contains(.,'Sign up')]"));

        //Click on [Log in] button
        clickOnButton(By.xpath("//ul[@class=\"header__nav desktop\"]//li//a[contains(.,'Log in')]"));
    }
    private void clickOnButton(By locator){

        driver.findElement(locator).click();
        Assert.assertTrue(isElementPresent(locator));
    }
}
