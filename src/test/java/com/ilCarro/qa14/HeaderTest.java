package com.ilCarro.qa14;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class HeaderTest extends TestBase{
    @Test
    public void headerButtonCklick(){
        driver.findElement(By.xpath("//ul[@class=\"header__nav desktop\"]//li//a[contains(.,'Search')]")).click();
        driver.findElement(By.xpath("//ul[@class=\"header__nav desktop\"]//li//a[contains(.,'Let the cat work')]")).click();
        //driver.findElement(By.xpath("//ul[@class=\"header__nav desktop\"]//li//a[contains(.,'Terms of use')]")).click();
        driver.findElement(By.xpath("//ul[@class=\"header__nav desktop\"]//li//a[contains(.,'Sign up')]")).click();
        driver.findElement(By.xpath("//ul[@class=\"header__nav desktop\"]//li//a[contains(.,'Log in')]")).click();
    }
}
