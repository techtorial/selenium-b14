package MentoringWithAhmet.com.test.bank.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class BankManagerPage {

    public BankManagerPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='center']//button[contains(text(),'Add Customer')]")
    WebElement addCustomerButton;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @FindBy(xpath ="//input[@placeholder='Last Name']" )
    WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;

    @FindBy(xpath ="//button[@type='submit']" )
    WebElement submitCustomerButton;

    @FindBy(id = "userSelect")
    WebElement customerBox;

    @FindBy(id = "currency")
    WebElement currencyBox;

    @FindBy(xpath = "//button[.='Process']")
    WebElement processButton;

    @FindBy(xpath = "//button[contains(text(),'Open Account')]")
    WebElement openAccountButton;

    @FindBy(xpath = "//button[contains(text(),'Customers')]")
    WebElement customersButton;

    @FindBy(xpath = "//input[@placeholder='Search Customer']")
    WebElement searchBar;

    @FindBy(xpath = "//tbody//tr[1]//td")
    List<WebElement> allInformation;


    public void provideCustomerInformation(WebDriver driver,String firsName,String lastName,String postCode,
                                           String expectedMessage){
        addCustomerButton.click();
        this.firstName.sendKeys(firsName);
        this.lastName.sendKeys(lastName);
        this.postCode.sendKeys(postCode);
        submitCustomerButton.click();
        Alert alert=driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedMessage));
        alert.accept();
    }

    public void provideCurrencyInformation(WebDriver driver,String customerName,String currency,
                                           String expectedMessage){
        openAccountButton.click();
        BrowserUtils.selectBy(customerBox,customerName,"text");
        BrowserUtils.selectBy(currencyBox,currency,"text");
        processButton.click();
        Alert alert=driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(expectedMessage));
        alert.accept();
    }

    public void validateGivenCustomerData(String searchName,String firstName,String lastName,String postCode){
        customersButton.click();
        searchBar.sendKeys(searchName);
        List<String> expectedValues= Arrays.asList(firstName,lastName,postCode);
        for(int i=0;i<allInformation.size()-2;i++){
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)),expectedValues.get(i));
        }
    }

}
