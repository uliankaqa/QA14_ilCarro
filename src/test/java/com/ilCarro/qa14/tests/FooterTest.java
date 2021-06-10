package com.ilCarro.qa14.tests;

import com.ilCarro.qa14.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FooterTest extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        app.footer().jumpToFooter();
        app.footer().isFooterPresent();
    }

    @Test
    public void clickOnLogoButton(){
        app.footer().clickOnLogoTab();
        Assert.assertTrue(app.car().isFindCarFormPresent());
    }

}
