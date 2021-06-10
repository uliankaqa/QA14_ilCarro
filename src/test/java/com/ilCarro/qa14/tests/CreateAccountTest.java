package com.ilCarro.qa14.tests;

import com.ilCarro.qa14.models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        app.user().isLogInFormPresent();

    }

    //fill registration form
    //click Submit button
    //check login form displayed


}
