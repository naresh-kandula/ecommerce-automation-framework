package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigReader;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    static WebDriver driver;

    public static void initDriver() {

        String browser =
                ConfigReader.getProperty("browser");

        if(browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            options.addArguments("--start-maximized");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");

            options.setExperimentalOption(
                    "excludeSwitches",
                    new String[]{"enable-automation"}
            );

            options.setExperimentalOption(
                    "useAutomationExtension",
                    false
            );

            Map<String, Object> prefs = new HashMap<>();

            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.password_manager_leak_detection", false);

            options.setExperimentalOption("prefs", prefs);

            driver = new ChromeDriver(options);
        }

        else if(browser.equalsIgnoreCase("edge")) {

            WebDriverManager.edgedriver().setup();

            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }

        else if(browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();

            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }

        else {

            throw new IllegalArgumentException(
                    "Unsupported Browser : " + browser
            );
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {

        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}