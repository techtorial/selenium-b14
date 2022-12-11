package com.test.etsy.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class EtsyMainPage {

    public EtsyMainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#global-enhancements-search-query")
    WebElement searchBox;

    @FindBy(xpath = "//li//h3")
    List<WebElement> allHeaders;

    public void searchItem(String itemName) {
        searchBox.sendKeys(itemName, Keys.ENTER);
    }

    //first way and what I would do in real job
    public boolean validationOfSearchFunctionality(String word1, String word2, String word3) {
        for (WebElement header : allHeaders) {
            String text = BrowserUtils.getText(header).toLowerCase();
            if (!(text.contains(word1) || text.contains(word2) || text.contains(word3))) {
                return false;
            }
        }
        return true;
    }

    //second way and what I would do in real job
    public void validationOfSearchFunctionality2(String word1, String word2, String word3) {
        for (WebElement header : allHeaders) {
            String text = BrowserUtils.getText(header).toLowerCase();
            Assert.assertTrue(text.contains(word1) || text.contains(word2) || text.contains(word3));
        }
    }
}
