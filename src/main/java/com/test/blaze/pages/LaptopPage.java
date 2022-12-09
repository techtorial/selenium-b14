package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class LaptopPage {

    public LaptopPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@class='hrefch']")//6
    List<WebElement> allLaptops;
    // List<WebElement> allPages = driver.findElements(By.xpath("//a[@class='hrefch']"));


    public void chooseLaptop(String brand) throws InterruptedException {
        Thread.sleep(3000);
        for(WebElement laptop:allLaptops){
            if(BrowserUtils.getText(laptop).contains(brand)){//in real job, .equals
                laptop.click();
                break;
            }
        }
    }




}
