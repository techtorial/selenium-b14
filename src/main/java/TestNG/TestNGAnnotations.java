package TestNG;

import org.testng.annotations.*;

public class TestNGAnnotations {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite");
        //you can use to setup your chrome browser properties(setProperty.....)
        //You can delete the cookies

    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest");
        //You can use to launch your browser
        //WebDriver driver=DriverHelper.getDriver();
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("BeforeClass");
        //navigate to the website
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod");
        //it runs before every test annotation
        //it is good to be used for setup automation and navigation
    }
   @Test
    public void test1(){
       System.out.println("test1");
       //it executes the implementation
   }

   @Test
    public void test2(){
       System.out.println("test2");
       //it executes the implementation
   }
   @AfterMethod
    public void afterMethod(){
       System.out.println("After Method");
       //it runs after every test annotation
       //it is good to be used for ScreenShot,driver.quit, driver.close
   }
   @AfterClass
    public void afterClass(){
       System.out.println("AfterClass Annotation");
   }

   @AfterTest
    public void afterTest(){
       System.out.println("AfterTest");
   }

   @AfterSuite
    public void AfterSuite(){
       System.out.println("AfterSuite");
   }





}
