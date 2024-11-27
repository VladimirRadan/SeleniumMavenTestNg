package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import utils.Utils;

import java.time.Duration;

import static core.OptionsManager.getChromeOptions;
import static core.OptionsManager.getFirefoxOptions;

public class DriverManager {

    private static String browser = Utils.dotEnv().get("BROWSER");

    private DriverManager(){}

    private static final DriverManager instance = new DriverManager();

    public static DriverManager getInstance(){
        return instance;
    }

    //ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    public WebDriver setDriver(){
        WebDriver driver = null;

        if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver(getChromeOptions());
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver(getFirefoxOptions());
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        return driver;
    }

    public WebDriver setDriver(String browser){
        WebDriver driver = null;

        if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver(getChromeOptions());
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver(getFirefoxOptions());
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        return driver;
    }


}
