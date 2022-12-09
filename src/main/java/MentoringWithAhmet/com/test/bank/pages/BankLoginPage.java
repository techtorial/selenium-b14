package MentoringWithAhmet.com.test.bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankLoginPage {

    //whenever you create any page, the first thing you should do is creating constructor

    public BankLoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);//is a way to initiliaze your webElements
    }

    @FindBy(xpath ="//button[contains(text(),'Bank Manager Login')]")
    WebElement managerButton;

    public void clickManagerButton(){
        managerButton.click();
    }
}
