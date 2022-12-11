package com.test.blaze.tests;

import com.test.blaze.pages.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrderTest extends TestBaseBlaze{

    @Parameters({"laptopBrand","expectedCardMessage","price","name","country","city","creditCard","month","year","expectedOrderMessage"})
    @Test   //These parameters order must match the order of Test Parameters(below).Name is not matter.
    public void validateOrderMessage(String laptopBrand,String expectedCardMessage,String price,
                                     String name,String country,String city,String creditCard,String month,
                                     String year,String expectedOrderMessage) throws InterruptedException {
        MainPage mainPage=new MainPage(driver);
        mainPage.clickLaptop();
        LaptopPage laptopPage=new LaptopPage(driver);
        laptopPage.chooseLaptop(laptopBrand);//MacBook Pro
        MacBookProPage macBookProPage=new MacBookProPage(driver);
        macBookProPage.clickAddToCardAndValidate(driver,expectedCardMessage);//Product added
        CartPage cartPage=new CartPage(driver);
        cartPage.validateCartInformation(laptopBrand,price);//1100
        OrderPage orderPage=new OrderPage(driver);
        orderPage.validateOrderMessage(name,country,city
        ,creditCard,month,year,expectedOrderMessage);//Thank you for your purchase!









    }
}
