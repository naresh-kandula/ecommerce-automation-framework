package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    static WebDriver driver;

    public static void initDriver() {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();

        // Browser setup
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        // Disable automation popup
        options.setExperimentalOption(
                "excludeSwitches",
                new String[]{"enable-automation"}
        );

        options.setExperimentalOption(
                "useAutomationExtension",
                false
        );

        // Disable password manager popup
        Map<String, Object> prefs = new HashMap<>();

        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);

        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {

        if (driver != null) {
            driver.quit();
        }
    }
}