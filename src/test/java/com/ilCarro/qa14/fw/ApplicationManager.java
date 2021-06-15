package com.ilCarro.qa14.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private String browser;
    private WebDriver driver;
    private UserHelper user;
    private CarHelper car;
    private HeaderHelper header;
    private FooterHelper footer;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() {
        if(browser.equals(BrowserType.CHROME)) {
            //System.setProperty("webdriver.gecko.driver", "src/drivers/geckodriver");///Users/qa/Documents/QAManuell/AutoQA/GitHub/QA14UlianaLiman/src
            driver = new ChromeDriver();
        }else if (browser.equals(BrowserType.FIREFOX)) {
            driver = new FirefoxDriver();
        }
        driver.get("https://ilcarro-dev-v1.firebaseapp.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        user = new UserHelper(driver);
        car = new CarHelper(driver);
        header = new HeaderHelper(driver);
        footer = new FooterHelper(driver);
    }

    public UserHelper user() {
        return user;
    }

    public CarHelper car() {
        return car;
    }

    public HeaderHelper header() {
        return header;
    }

    public FooterHelper footer() {
        return footer;
    }

    public void stop() {
        driver.quit();//close all
        // driver.close();//close tab
    }

}
