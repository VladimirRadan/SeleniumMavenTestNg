package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;
import utils.Constants;

public class Main {


    static WebDriver driver;

    static WebElement getElement(By locator){
        return driver.findElement(locator);
    }

    static void typeIn(By locator, String text){
        getElement(locator).sendKeys(text);
    }


    public static void main(String[] args) {

        SoftAssert softAssert = new SoftAssert();

        By usernameLocator = By.id("username");
        By passwordLocator = By.id("password");
        By buttonLocator = By.cssSelector("button[class='radius']");

        //System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver"); //importovati odgovarajuci driver
        //WebdriverManager
        //WebDriverManager.chromedriver().setup(); //pre 4.6.0 selenium verzije
        //WebDriverManager.firefoxdriver().browserVersion("").setup();
        //driver = new ChromeDriver();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/login");

        //WebElement usernameField = driver.findElement(usernameLocator);
        //WebElement usernameField = driver.findElement(By.cssSelector("#username"));
        //getElement(usernameLocator).sendKeys("tomsmith");
        typeIn(usernameLocator, Constants.USERNAME);

        //WebElement passwordField = driver.findElement(passwordLocator);
        //getElement(passwordLocator).sendKeys("SuperSecretPassword!");
        typeIn(passwordLocator, Constants.PASSWORD);

        //WebElement button = driver.findElement(buttonLocator);
        //WebElement button = driver.findElement(By.cssSelector(".radius")); primeri dohvatanja elementa preko klase
        //WebElement button = driver.findElement(By.className("radius")); primeri dohvatanja elementa preko klase
        getElement(buttonLocator).click();

//        driver.findElement(By.className("fa fa-2x fa-sign-in")); primeri dohvatanja elementa preko klase
//        driver.findElement(By.cssSelector(".fa.fa-2x")); primeri dohvatanja elementa preko klase

        String expectedText = "You logged into a secure area!";

        WebElement loggedInUserText = driver.findElement(By.cssSelector(".flash.success"));
        String actualText = loggedInUserText.getText();

        String actual = loggedInUserText.getText().substring(0, loggedInUserText.getText().length()-1);

        String [] actualRegexArray = loggedInUserText.getText().split("(?<=!)");

        String actualRegexText = actualRegexArray[0];


        String expectedColor = null;

        if (driver instanceof ChromeDriver){
            expectedColor = "rgba(93, 164, 35, 1)";
        }else if (driver instanceof FirefoxDriver){
            expectedColor = "rgb(93, 164, 35)";
        }

        String actualColor = loggedInUserText.getCssValue("background-color");

        System.out.println(actualColor);

//        Assert.assertEquals(actualColor, expectedColor, "Failed");// hard assert
//
//        Assert.assertEquals(actualRegexText.trim(), expectedText, "Failed");

        softAssert.assertEquals(actualColor, expectedColor, "Failed");// hard assert

        softAssert.assertEquals(actualRegexText.trim(), expectedText, "Failed");

        softAssert.assertAll();

        //driver.close();// zatvara prozor ili tab na kom se korisnik nalazi
        driver.quit();//zatvara sve otvoreno






    }




}