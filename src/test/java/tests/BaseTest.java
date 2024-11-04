package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    protected WebDriver driver;
    protected SoftAssert softAssert;

    @BeforeMethod
    public void setupMethod(){
        driver = new ChromeDriver();
        softAssert = new SoftAssert();
        driver.get("https://demowebshop.tricentis.com/");
    }


}
