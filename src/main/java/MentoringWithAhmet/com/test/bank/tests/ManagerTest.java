package MentoringWithAhmet.com.test.bank.tests;

import MentoringWithAhmet.com.test.bank.pages.BankLoginPage;
import MentoringWithAhmet.com.test.bank.pages.BankManagerPage;
import org.testng.annotations.Test;

public class ManagerTest extends TestBaseBank{
    /*
1-Navigate to the website https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login
2-Click Bank Manager Login
3-Click Add Customer
4-Fill the blanks and click add customer button
5-Get the text from pop-up and VALIDATE and click OK
6-Click Open Account
7-Choose your name from the list
8-Choose any currency you want from list
9-Get the text from pop-up and VALIDATE and click OK
10-Click Customers Button
11-Search your name on the searchBar
12-Validate your firstname,lastName,PostCode
13-driver.quit
14-Proud of yourself
 */
    /*
    TASK 2: (might be homework it depends on your performance)

     1-Click Customer Login
     2-Find your Name from the List
     3-Click Login
     4-Validate the "Welcome Your Name" from header
     5-Click Deposit and put 500
     6-Validate "Deposit Successful
     7-Click Withdrawl and put 300
     8-Validate "Transaction successful"
     9-Get the balance from the Customer Page(200)
     10-Click Transaction
     11-get the 500 and 300 from the table and substract them
     12-Validate balance from customer page amount(200) equals to transaction amount(500-300).
     12-Quit the driver

     */

    @Test
    public void validateCustomerCreation(){
        BankLoginPage bankLoginPage=new BankLoginPage(driver);
        bankLoginPage.clickManagerButton();
        BankManagerPage bankManagerPage=new BankManagerPage(driver);
        bankManagerPage.provideCustomerInformation(driver,"Ahmet","Baldir","06133",
                "Customer added successfully with customer id :");
        bankManagerPage.provideCurrencyInformation(driver,"Ahmet Baldir","Dollar",
                "Account created successfully with account Number :");
        bankManagerPage.validateGivenCustomerData("Ahmet","Ahmet","Baldir","06133");

    }

}
