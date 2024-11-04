package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.RegisterPage;

public class RegisterTest extends BaseTest{

    private RegisterPage registerPage;


    @BeforeMethod
    public void setUpRegister(){
        registerPage = new RegisterPage(driver);
    }


    @Test
    public void registerUserTest(){
        registerPage.registerUser();
        Assert.assertTrue(registerPage.isUserRegistered());
    }


}
