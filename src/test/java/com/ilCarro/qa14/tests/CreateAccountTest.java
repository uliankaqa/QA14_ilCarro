package com.ilCarro.qa14.tests;

import com.ilCarro.qa14.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateAccountTest extends TestBase {
    //preconditions : user should be logged out
    // click on SignUp Button


    @BeforeMethod
    public void ensurePrecondition(){
        if(!app.header().isSignUpTabPresent()){
            //sign up mot present
            //click on logout button
            app.header().logOut();
        }
    }

    @Test
    public void signUpTest(){
        app.header().clickOnSignUpTab();
        app.header().isSignUpTabPresent();
        app.user().fillRegistrationForm(new User().withFirstName("Uli1")
                .withSecondName("Truli1")
                .withEmail("ulitruli1@gmail.com")
                .withPassword("!weAD5446"));
        app.user().clickOnCheckPolicyBox();
        app.user().submit();
        Assert.assertTrue(app.user().isLogInFormPresent());

    }

    @Test(dataProvider = "validUser", dataProviderClass = DataProviders.class)
    public void signUpFromDataProviderTest(String fName, String sName, String email, String password){
        app.header().clickOnSignUpTab();
        app.header().isSignUpTabPresent();
        app.user().fillRegistrationForm(new User().withFirstName(fName)
                .withSecondName(sName)
                .withEmail(email)
                .withPassword(password));
        app.user().clickOnCheckPolicyBox();
        app.user().submit();

        logger.info("Log In form present : " + app.user().isLogInFormPresent() + " , Expected value : true ");
        Assert.assertTrue(app.user().isLogInFormPresent());
    }

    @Test(dataProvider = "validUserFromCSV", dataProviderClass = DataProviders.class)
    public void signUpFromDataProviderFromCSVTest(User user){

        app.header().clickOnSignUpTab();
        app.header().isSignUpTabPresent();
        app.user().fillRegistrationForm(user);
        app.user().clickOnCheckPolicyBox();
        app.user().submit();

        logger.info("Log In form present : " + app.user().isLogInFormPresent() + " , Expected value : true ");
        Assert.assertTrue(app.user().isLogInFormPresent());
    }

    //fill registration form
    //click Submit button
    //check login form displayed


}
