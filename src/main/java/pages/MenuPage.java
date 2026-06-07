package pages;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class MenuPage {

    WebDriver driver;

    public MenuPage() {
        this.driver = DriverFactory.getDriver();
    }

    private By menuButton =
            By.id("react-burger-menu-btn");

    private By logoutLink =
            By.id("logout_sidebar_link");

    public void openMenu() {

        WaitUtils.waitForClickable(menuButton);

        driver.findElement(menuButton).click();
    }

    public void clickLogout() {

        WaitUtils.waitForClickable(logoutLink);

        driver.findElement(logoutLink).click();
    }
}
