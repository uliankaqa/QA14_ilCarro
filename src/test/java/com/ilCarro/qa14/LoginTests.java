package com.ilCarro.qa14;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void ensurePreconditions(){
        //go to logintest
        //if user logged in . click logout, go to login
        if(!isSignUpTabPresent()){
            //sign up not present
            //click on logout button
            logOut();
        }
    }

    @Test
    public void loginRegisteredUserPositiveTest(){
        //go to login page
        clickOnLogInTab();
        //fill login form
        fillLoginForm(new User().withEmail("ulitruli1@gmail.com").withPassword("!weAD5446"));
        //click submit
        submit();
        try {
            pause();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //assert user logged in
        isLogOutTabPresent();
    }


    @Test
    public void loginRegisteredUserWithWrongPasswordNegativeTest() {

        //go to login page
        clickOnLogInTab();
        //fill login form
        fillLoginForm(new User().withEmail("ulitruli1@gmail.com").withPassword("!"));
        //click submit
        submit();
    }

}
