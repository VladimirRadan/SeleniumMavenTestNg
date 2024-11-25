package core;

import jdk.jshell.execution.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import utils.Constants;
import utils.Utils;

public class Environment {

    private String homeUrl;
    private WebDriver driver;

    private static final Logger log = LogManager.getLogger(Environment.class.getName());

    public Environment(WebDriver driver) {
        this.driver = driver;
    }

    public void openBrowser(){
        String env = Utils.dotEnv().get("ENV");
        if (env.equalsIgnoreCase("dev")){
            homeUrl = Utils.dotEnv().get("DEV_URL");
            //homeUrl = Constants.DEV_URL;
        } else if (env.equalsIgnoreCase("stage")) {
            homeUrl = Utils.dotEnv().get("STAGE_URL");
        }
        log.info("Opening browser: " + Utils.dotEnv().get("BROWSER") + " navigating to: " + homeUrl);
        driver.get(homeUrl);
    }

}
