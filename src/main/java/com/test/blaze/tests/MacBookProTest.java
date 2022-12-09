package com.test.blaze.tests;

import com.test.blaze.pages.CartPage;
import com.test.blaze.pages.LaptopPage;
import com.test.blaze.pages.MacBookProPage;
import com.test.blaze.pages.MainPage;
import org.checkerframework.checker.units.qual.C;
import org.testng.annotations.Test;

public class MacBookProTest extends TestBaseBlaze{

    @Test
    public void validateMacbookProProductInfo() throws InterruptedException {
        MainPage mainPage=new MainPage(driver);
        mainPage.clickLaptop();
        LaptopPage laptopPage=new LaptopPage(driver);
        laptopPage.chooseLaptop("MacBook Pro");
        MacBookProPage macBookProPage=new MacBookProPage(driver);
        macBookProPage.validateProductInfo("MacBook Pro","$1100 *includes tax",
                "Product description\n" +
                        "Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and 15-inch model with the Touch Bar, a thin, multi-touch strip display that sits above the MacBook Pro's keyboard.");
    }

    @Test
    public void validateOrder() throws InterruptedException {
        MainPage mainPage=new MainPage(driver);
        mainPage.clickLaptop();
        LaptopPage laptopPage=new LaptopPage(driver);
        laptopPage.chooseLaptop("MacBook Pro");
        MacBookProPage macBookProPage=new MacBookProPage(driver);
        macBookProPage.clickAddToCardAndValidate(driver,"Product added");
        CartPage cartPage=new CartPage(driver);
        cartPage.validateCartInformation("MacBook Pro","1100");
    }

     /*
    1-Click Add to cart button(after clicking this button put 3 sec of Thread.sleep)
    2-Validate the message "Product added" and click OK button
    3-Click Cart button at the top of page and validate the name "MacBook Pro" and "1100"
    4-Click PlaceOrder Button
    5-Fill all the necessary Information and click Purchase
    6-Validate the Message "Thank you for your purchase!"
    7-Click OK button
    8-Validate you are on the "https://www.demoblaze.com/index.html" (thread)
    9-driver.quit
    10-Then Proud of yourself
     */
}
