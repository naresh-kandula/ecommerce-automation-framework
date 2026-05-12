package pages;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage() {
        this.driver = DriverFactory.getDriver();
    }

    // Locators

    private By checkoutBtn = By.id("checkout");

    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By postalCode = By.id("postal-code");

    private By continueBtn = By.id("continue");
    private By finishBtn = By.id("finish");

    private By successMessage = By.className("complete-header");

    // Methods

    public void clickCheckout() {
        WaitUtils.waitForClickable(checkoutBtn);
        driver.findElement(checkoutBtn).click();
    }

    public void enterCheckoutInformation(String fName,
                                         String lName,
                                         String zip) {

        WaitUtils.waitForClickable(firstName);

        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(postalCode).sendKeys(zip);
    }

    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }

    public void clickFinish() {
        WaitUtils.waitForClickable(finishBtn);
        driver.findElement(finishBtn).click();
    }

    public String getSuccessMessage() {
        try {
            return driver.findElement(successMessage).getText();
        } catch (Exception e) {
            return "";
        }
    }
}