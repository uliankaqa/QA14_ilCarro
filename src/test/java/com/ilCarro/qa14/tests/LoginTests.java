package com.ilCarro.qa14.tests;

import com.ilCarro.qa14.models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        //go to logintest
        //if user logged in . click logout, go to login
        if (!app.header().isSignUpTabPresent()) {
            //sign up not present
            //click on logout button
            app.header().logOut();
        }
    }

    @Test
    public void loginRegisteredUserPositiveTest() {
        //go to login page
        app.header().clickOnLogInTab();
        //fill login form
        app.user().fillLoginForm(new User().withEmail("ulitruli1@gmail.com").withPassword("!weAD5446"));
        //click submit
        app.user().submit();
        try {
            app.user().pause();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //assert user logged in
        app.header().isLogOutTabPresent();
    }


    @Test
    public void loginRegisteredUserWithWrongPasswordNegativeTest() {

        //go to login page
        app.header().clickOnLogInTab();
        //fill login form
        app.user().fillLoginForm(new User().withEmail("ulitruli1@gmail.com").withPassword("!"));
        //click submit
        app.user().submit();
    }

}
