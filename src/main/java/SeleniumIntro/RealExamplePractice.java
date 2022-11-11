package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RealExamplePractice {
    //  Test Case - Open Godaddy.com and validate it's Page title and the url.
//    Steps to Automate:
//            1. Launch browser of your choice say., Firefox, chrome etc.
//            2. Open this URL - https://www.godaddy.com/
//            3. Maximize or set size of browser window.
//4. Get Title of page and validate it.(if conditions) expected title from website
//4. Get URL of current page and validate it.          expected url from website
//            5. Close browser.(driver.close)

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.godaddy.com/");
        String actualTitle=driver.getTitle().trim();
        String expectedTitle="Domain Names, Websites, Hosting & Online Marketing Tools - GoDaddy";
        if(actualTitle.equals(expectedTitle)){
            System.out.println("your title is passed");
        }else{
            System.out.println("Your title is failed");
        }
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.godaddy.com/";
        if(actualUrl.equals(expectedUrl)){
            System.out.println("Url is passed");
        }else{
            System.out.println("Url is failed");
        }
        driver.close();
    }


}
