package tests;

import dataproviders.DataProviders;
import listeners.RetryAnalyzer;
import models.LoginUser;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Utils;

import java.util.List;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void loginSetup() {
        loginPage = new LoginPage(driver);
    }

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void loginUserTest(){
        loginPage.goToLoginForm()
                .loginUser("", "");
        Assert.assertTrue(false);
    }

    @Test(dataProvider = "loginDataProvider", dataProviderClass = DataProviders.class)
    public void invalidLoginTest(String username, String password){
        loginPage.goToLoginForm()
                .loginUser(username, password);
        //Utils.waitForSeconds(2);
        Assert.assertTrue(loginPage.isErrorMessagePresent());
    }

    @Test
    public void invalidLoginFromJsonTest(){
        List<LoginUser> list = Utils.getDataFromJson();
        for (int i = 0; i < list.size(); i++) {
             loginPage.goToLoginForm()
                     .loginUser(list.get(i).getUsername(), list.get(i).getPassword());
            Assert.assertTrue(loginPage.isErrorMessagePresent());
        }
    }

}
