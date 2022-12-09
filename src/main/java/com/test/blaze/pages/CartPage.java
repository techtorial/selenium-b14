package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class CartPage {

    public CartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "Cart")
    WebElement cartbutton;

    @FindBy(xpath = "//td")//4
    List<WebElement> allInformation;

    @FindBy(xpath = "//button[contains(text(),'Place Order')]")
    WebElement placeOrderButton;


    public void validateCartInformation(String brand,String price){
        cartbutton.click();
        List<String> expectedInformation= Arrays.asList("",brand,price,"");
        for(int i=1;i<3;i++){
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)),expectedInformation.get(i));
        }
        placeOrderButton.click();
    }
}
