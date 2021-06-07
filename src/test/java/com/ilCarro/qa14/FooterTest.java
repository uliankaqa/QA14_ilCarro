package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FooterTest extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        jumpToFooter();
        Assert.assertTrue(isElementPresent1(By.xpath("//footer[@class=\"container-full\"]")));
    }

    @Test
    public void clickOnLogoButton(){
        click(By.cssSelector(".footer__top_row_logo"));
        Assert.assertTrue(isElementPresent1(By.cssSelector(".Main_mainpage__find_your_car__AHLkw")));
    }
}
