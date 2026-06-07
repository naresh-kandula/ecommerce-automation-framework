package pages;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class LoginPage {

    WebDriver driver;

    public LoginPage() {
        this.driver = DriverFactory.getDriver();
    }

    // Locators
    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginBtn = By.id("login-button");
    private By errorMsg = By.cssSelector("[data-test='error']");
    private By usernameField = By.id("user-name");
    private By errorMessage = By.cssSelector("h3[data-test='error']");

    // Actions
    public void enterUsername(String user) {
        WaitUtils.waitForClickable(username);
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);
    }

    public void enterPassword(String pass) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    public void login(String user, String pass) {
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
    }

    public String getErrorMessage() {
        try {
            return driver.findElement(errorMsg).getText();
        } catch (Exception e) {
            return "";
        }
    }

    public boolean isLoginPageDisplayed() {

        try {
            return driver.findElement(usernameField).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getLoginErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
