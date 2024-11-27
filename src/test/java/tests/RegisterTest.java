package tests;

import listeners.TestListener;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.RegisterPage;
@Listeners(TestListener.class)
public class RegisterTest extends BaseTest{

    private RegisterPage registerPage;


    @BeforeMethod
    public void setUpRegister(){
        registerPage = new RegisterPage(driver.get());
    }


    @Test(description = "Register user happy path; Expected result: User is successfully registered")
    public void registerUserTest(){
        registerPage.registerUser();
        Assert.assertTrue(registerPage.isUserRegistered());
    }

    @Test(description = "Register user happy path; Expected result: User is successfully registered")
    public void registerUserTestFail(){
//        registerPage.registerUser();
//        Assert.assertTrue(registerPage.isUserRegistered());
        Assert.assertTrue(false);
    }



}
