package com.ilCarro.qa14.tests;

import com.ilCarro.qa14.fw.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() {
        app.init();

    }

    @BeforeMethod
    public void startTest(Method m){
        logger.info("Start test " + m.getName());
    }

    @AfterMethod
    public  void stopTest(Method m){
        logger.info("Stop test " + m.getName());
    }

    @AfterSuite(enabled = true)
    public void tearDown() {

        app.stop();

    }

}
