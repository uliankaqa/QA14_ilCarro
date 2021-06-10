package com.ilCarro.qa14.fw;

import com.ilCarro.qa14.models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CarHelper extends HelperBase{

    public CarHelper(WebDriver driver) {
        super(driver);
    }

    //Add Car
    public void isAddCarFormPresent() {
        Assert.assertTrue(isElementPresent1(By.cssSelector(".let-carwork-style_let_car__work__2nUyo.let-carwork-style_container__2JKHv")));
    }

    //Main page, form "Find your car now!"
    public boolean isFindCarFormPresent() {
        return isElementPresent1(By.cssSelector(".Main_mainpage__find_your_car__AHLkw"));
    }


    public void fillCarForm(Car car) {
        type(By.cssSelector(".country"), car.getCountry());
        type(By.cssSelector(".address"), car.getAddress());
        type(By.cssSelector(".distance_included"), car.getDistance());
    }
}
