package com.ilCarro.qa14.fw;

import com.ilCarro.qa14.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UserHelper extends HelperBase{

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnCheckPolicyBox() {
        click(By.cssSelector("#check_policy"));
    }

    public void isSignUpFormPresent() {
        Assert.assertTrue(isElementPresent1(By.cssSelector("form.signup__fields")));
    }

    public boolean isUserLoggedIn() {
        return isElementPresent1(By.xpath("//a[contains(., 'logOut')]"));
    }

    public boolean isLogInFormPresent() {
        return isElementPresent1(By.cssSelector(".Login_login__right_block__1niYm"));
    }


    ////-------------------------------------------------------------------
    public void logIn() {
        click(By.xpath("//ul[@class='header__nav desktop']/li[5]"));
        fillLoginForm(new User().withEmail("ulitruli1@gmail.com").withPassword("!weAD5446"));
        submit();
    }

    public void submit() {
        click(By.cssSelector("[type=\"submit\"]"));
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

    public void clearLoginForm(){
        clear(By.name("email"));
        clear(By.name("password"));
    }
}
