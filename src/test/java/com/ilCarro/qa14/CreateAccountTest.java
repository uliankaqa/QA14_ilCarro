package com.ilCarro.qa14;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase{
    //preconditions : user should be logged out
    // click on SignUp Button
    @BeforeMethod
    public void ensurePrecondition(){
        if(!isSignUpTabPresent()){
            //sign up mot present
            //click on logout button
            logOut();
        }
    }

    @Test
    public void signUpTest(){
        clickOnSignUpTab();
        isSignUpTabPresent();
        fillRegistrationForm(new User().withFirstName("Uli1")
                .withSecondName("Truli1")
                .withEmail("ulitruli1@gmail.com")
                .withPassword("!weAD5446"));
        clickOnCheckPolicyBox();
        submit();
        isLogInFormPresent();

    }

    //fill registration form
    //click Submit button
    //check login form displayed


}
