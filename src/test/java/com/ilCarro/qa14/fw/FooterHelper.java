package com.ilCarro.qa14.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class FooterHelper extends HelperBase{

    public FooterHelper(WebDriver driver) {
        super(driver);
    }

    public void jumpToFooter() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.END, Keys.COMMAND);
    }

    //Footer
    public void isFooterPresent() {
        Assert.assertTrue(isElementPresent1(By.xpath("//footer[@class=\"container-full\"]")));
    }


    public void clickOnLogoTab() {
        click(By.cssSelector(".footer__top_row_logo"));
    }
}
