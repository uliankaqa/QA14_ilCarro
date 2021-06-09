package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class TestBase {

    static WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //System.setProperty("webdriver.gecko.driver", "src/drivers/geckodriver");///Users/qa/Documents/QAManuell/AutoQA/GitHub/QA14UlianaLiman/src
        driver = new ChromeDriver();
        //driver = new FirefoxDriver();
        driver.get("https://ilcarro-dev-v1.firebaseapp.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

//    public boolean isElementPresent() {
//        return driver.findElements(By.cssSelector(".Main_mainpage__find_your_car__AHLkw")).size() > 0;
//    }

    public boolean isElementPresent1(By locator) {
        try {
            driver.findElements(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //after - tearDown(){}
    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();//close all
        // driver.close();//close tab
    }
    //Click on methods

    public void click(By locator) {
        driver.findElement(locator).click();
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

    public void clickOnCheckPolicyBox() {
        click(By.cssSelector("#check_policy"));
    }

    public void clickOnLogoTab() {
        click(By.cssSelector(".footer__top_row_logo"));
    }


    //Boolean methods

    //Add Car
    public void isAddCarFormPresent() {
        Assert.assertTrue(isElementPresent1(By.cssSelector(".let-carwork-style_let_car__work__2nUyo.let-carwork-style_container__2JKHv")));
    }

    //Sign Up
    public boolean isSignUpTabPresent() {
        return isElementPresent1(By.cssSelector("[href='/signup']"));

    }

    public void isSignUpFormPresent() {
        Assert.assertTrue(isElementPresent1(By.cssSelector("form.signup__fields")));
    }

    //Log Out
    public void isLogOutTabPresent() {
        Assert.assertTrue(isElementPresent1(By.xpath("//a[contains(.,'logOut')]")));
        //Assert.assertTrue(isElementPresent(By.xpath("//a[contains(.,'logOut')]")));
    }

    //Main page, form "Find your car now!"
    public boolean isFindCarFormPresent() {
        return isElementPresent1(By.cssSelector(".Main_mainpage__find_your_car__AHLkw"));
    }

    //Search page, form "Find your car now!"
    public void isSearchFormPresent() {
        Assert.assertTrue(isElementPresent1(By.cssSelector(".search-sidebar__content")));
    }

    //Log In
    public boolean isLogInTabPresent() {
        return isElementPresent1(By.xpath("//ul[@class=\"header__nav desktop\"]/li[5]"));

    }

    public boolean isUserLoggedIn() {
        return isElementPresent1(By.xpath("//a[contains(., 'logOut')]"));
    }


    public void isLogInFormPresent() {
        Assert.assertTrue(isElementPresent1(By.cssSelector(".Login_login__right_block__1niYm")));
    }

    //Footer
    public void isFooterPresent() {
        Assert.assertTrue(isElementPresent1(By.xpath("//footer[@class=\"container-full\"]")));
    }

    ////-------------------------------------------------------------------
    public void logIn() {
        click(By.xpath("//ul[@class='header__nav desktop']/li[5]"));
        fillLoginForm(new User().withEmail("ulitruli1@gmail.com").withPassword("!weAD5446"));
        submit();
    }

    public void logOut() {
        click(By.xpath("//a[contains(.,'logOut')]"));
    }

    public void submit() {
        click(By.cssSelector("[type=\"submit\"]"));
    }

    public void jumpToFooter() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.END, Keys.COMMAND);
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

    public void fillCarForm(Car car) {
        type(By.cssSelector(".country"), car.getCountry());
        type(By.cssSelector(".address"), car.getAddress());
        type(By.cssSelector(".distance_included"), car.getDistance());
    }

    public void fillRegistrationForm(User user) {
        type(By.cssSelector("#first_name"), user.getFirstName());
        type(By.cssSelector("#second_name"), user.getSecondName());
        type(By.cssSelector("#email"), user.getEmail());
        type(By.cssSelector("#password"), user.getPassword());
    }

    public void fillLoginForm(User user) {
        //fill email
        type(By.name("email"), user.getEmail());
        //fill password
        type(By.name("password"), user.getPassword());
    }

}
