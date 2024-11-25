package tests;

import core.DriverManager;
import core.Environment;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {


    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void initialSetup(){
        driver = DriverManager.setDriver();
        //driver.get("https://demowebshop.tricentis.com/");
        new Environment(driver).openBrowser();
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver(){
        if (driver != null){
            driver.quit();
        }
    }

    public WebDriver getDriver(){
        return driver;
    }

}
