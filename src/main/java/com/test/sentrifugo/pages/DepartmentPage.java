package com.test.sentrifugo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class DepartmentPage {

    public DepartmentPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@title='Add']")
    WebElement addButton;

    @FindBy(name = "deptname")
    WebElement departmentName;

    @FindBy(id = "s2id_unitid")
    WebElement businessUnit;

    @FindBy(id = "deptcode")
    WebElement deptCode;

    @FindBy(id = "s2id_depthead")
    WebElement deptHead;

    @FindBy(xpath = "//span[contains(text(),'Orange Blossom')]")
    WebElement orangeBlossom;

    @FindBy(xpath = "//span[contains(text(),'Thomas E')]")
    WebElement thomasE;

    @FindBy(id = "submitbutton")
    WebElement saveButton;

    @FindBy(className = "ml-alert-1-success")
    WebElement message;

    @FindBy(xpath = "//tbody//tr[1]//td")//7
    List<WebElement> allInformation;

    public void validateMessageOfCreationEmployee(WebDriver driver,String departmentName,String deptCode,String expected) throws InterruptedException {
        addButton.click();
        Thread.sleep(3000);
        this.departmentName.sendKeys(departmentName);
        businessUnit.click();
        Thread.sleep(3000);
        orangeBlossom.click();
        Thread.sleep(3000);
        this.deptCode.sendKeys(deptCode);
        Thread.sleep(3000);
        deptHead.click();
        Thread.sleep(3000);
        thomasE.click();
        Thread.sleep(3000);
        BrowserUtils.scrollIntoView(driver,saveButton);
        saveButton.click();
        Thread.sleep(3000);
        Assert.assertEquals(BrowserUtils.getText(message),expected);
    }

    public void validateInformationFromTable(String departmentName,String departmentCode,String startOn,
                                             String departmentHead,String timeZone,String businessUnit){
        List<String> expectedInformation= Arrays.asList("",departmentName,departmentCode,startOn,departmentHead,timeZone,businessUnit);

        for(int i = 1;i<allInformation.size();i++){
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)),expectedInformation.get(i));
            System.out.println(allInformation.get(i).getText().trim());
            System.out.println(expectedInformation.get(i).trim());
        }
    }





}
