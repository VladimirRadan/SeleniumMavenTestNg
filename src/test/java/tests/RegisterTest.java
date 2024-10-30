package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.RegisterPage;

public class RegisterTest extends BaseTest{

    private RegisterPage registerPage;


    @BeforeMethod
    public void setUpRegister(){
        registerPage = new RegisterPage();
    }

    @Test
    public void testRegisterHappyPath(){
        registerPage.ispis();
    }
    @Test
    public void testRegisterHappyPath2(){
        registerPage.ispis();
    }

    @Test
    public void testRegisterValidations(){
        registerPage.ispis();
    }

    @Test
    public void testRegisterErrorMessages(){
        registerPage.ispis();
    }



}
