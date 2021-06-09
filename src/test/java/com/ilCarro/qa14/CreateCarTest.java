package com.ilCarro.qa14;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateCarTest extends TestBase{
    @BeforeMethod
    public void ensurePrecondition(){
        //System.out.println("PRECONDITION : " + isUserLoggedIn());
        if(!isUserLoggedIn()){
           logIn();
       }
    }

    @Test
    public void addCarTest() throws InterruptedException{
        pause();

        clickOnAddCarTab();

        fillCarForm(new Car().withCountry("Germany")
                .withAddress("Friedrichstrasse")
                .withDistance("1000"));
    }

}
