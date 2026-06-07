package pages;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class InventoryPage {

    WebDriver driver;

    public InventoryPage() {
        this.driver = DriverFactory.getDriver();
    }

    // Locators
    private By inventoryContainer =
            By.id("inventory_container");

    private By addBackpackBtn =
            By.id("add-to-cart-sauce-labs-backpack");

    private By removeBackpackBtn =
            By.id("remove-sauce-labs-backpack");

    private By cartBadge =
            By.className("shopping_cart_badge");

    private By cartIcon =
            By.className("shopping_cart_link");

    // Methods

    public boolean isInventoryPageLoaded() {

        try {

            WaitUtils.waitForClickable(
                    inventoryContainer
            );

            return driver.findElement(
                    inventoryContainer
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

    public void addBackpackToCart() {

        WaitUtils.waitForClickable(
                addBackpackBtn
        );

        driver.findElement(
                addBackpackBtn
        ).click();
    }

    public void removeBackpackFromCart() {

        WaitUtils.waitForClickable(
                removeBackpackBtn
        );

        driver.findElement(
                removeBackpackBtn
        ).click();

        System.out.println(
                "Remove button clicked"
        );
    }

    public String getCartCount() {

        try {

            return driver.findElement(
                    cartBadge
            ).getText();

        } catch (Exception e) {

            return "0";
        }
    }

    public boolean isCartBadgeDisplayed() {

        return driver.findElements(
                cartBadge
        ).size() > 0;
    }

    public void openCart() {

        WaitUtils.waitForClickable(
                cartIcon    
        );

        driver.findElement(
                cartIcon
        ).click();
    }
}