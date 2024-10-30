package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest{

    @BeforeTest
    public void setUp(){
        //driver = new ChromeDriver();
        System.out.println("Before test");
    }

    @BeforeClass
    public void setUpClass(){
        System.out.println("Before class");
    }


    @Test(priority = 0, groups = "regression")
    public void test1(){
        System.out.println("Test1");
    }

    @Test(dependsOnMethods = "test1")
    public void test2(){
        System.out.println("Test2");
    }

    @Test(dependsOnGroups = "", groups = "smoke, regression")
    public void test3(){
        System.out.println("Test3");
    }





}
