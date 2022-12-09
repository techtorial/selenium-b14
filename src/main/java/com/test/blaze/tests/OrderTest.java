package com.test.blaze.tests;

import com.test.blaze.pages.*;
import org.testng.annotations.Test;

public class OrderTest extends TestBaseBlaze{

    @Test
    public void validateOrderMessage() throws InterruptedException {
        MainPage mainPage=new MainPage(driver);
        mainPage.clickLaptop();
        LaptopPage laptopPage=new LaptopPage(driver);
        laptopPage.chooseLaptop("MacBook Pro");
        MacBookProPage macBookProPage=new MacBookProPage(driver);
        macBookProPage.clickAddToCardAndValidate(driver,"Product added");
        CartPage cartPage=new CartPage(driver);
        cartPage.validateCartInformation("MacBook Pro","1100");
        OrderPage orderPage=new OrderPage(driver);
        orderPage.validateOrderMessage("Ahmet","Turkey","Ankara"
        ,"1234344343","12","1991","Thank you for your purchase!");









    }
}
