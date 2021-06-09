package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FooterTest extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        jumpToFooter();
        isFooterPresent();
    }

    @Test
    public void clickOnLogoButton(){
        clickOnLogoTab();
        Assert.assertTrue(isFindCarFormPresent());
    }

}
