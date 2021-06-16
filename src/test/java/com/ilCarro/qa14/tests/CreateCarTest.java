package com.ilCarro.qa14.tests;

import com.ilCarro.qa14.models.Car;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateCarTest extends TestBase {
    @BeforeMethod
    public void ensurePrecondition(){
        //System.out.println("PRECONDITION : " + isUserLoggedIn());
        if(!app.user().isUserLoggedIn()){
           app.user().logIn();
       }
    }

    @Test
    public void addCarTest() throws InterruptedException{
        app.user().pause();

        app.header().clickOnAddCarTab();

        app.car().fillCarForm(new Car().withCountry("Germany")
                .withAddress("Friedrichstrasse")
                .withDistance("1000"));
    }

    @Test(dataProvider = "validCarFromCSV", dataProviderClass = DataProviders.class)
    public void addCarTestFromCSV(Car car) throws InterruptedException{
        app.user().pause();

        app.header().clickOnAddCarTab();

        app.car().fillCarForm(car);
    }

}
