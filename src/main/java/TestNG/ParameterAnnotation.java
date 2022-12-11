package TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterAnnotation {

    @Parameters("firstName")
    @Test
    public void test(String ahmeysfhfdh){
        System.out.println(ahmeysfhfdh);
    }

    @Parameters({"Cntry","City","ZipCode"})
    @Test
    public void test2(String two,String one,String three){
        System.out.println(one);
        System.out.println(two);
        System.out.println(three);

       // country, city,zipcode
      //  city,country zipcode


    }

}
