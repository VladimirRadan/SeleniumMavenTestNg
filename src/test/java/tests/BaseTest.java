package tests;

import core.DriverManager;
import core.Environment;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {


    //protected WebDriver driver;

    protected static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void initialSetup(String browser){
        driver.set(DriverManager.getInstance().setDriver(browser));
        //driver.get("https://demowebshop.tricentis.com/");
        new Environment(driver.get()).openBrowser();
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver(){
        if (driver.get() != null){
            driver.get().quit();
        }
        driver.remove();
    }

    public WebDriver getDriver(){
        return driver.get();
    }

}
