package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeCheckoutFlowTest() {

        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();
        CartPage cartPage = new CartPage();
        CheckoutPage checkoutPage = new CheckoutPage();

        // Step 1: Login
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(inventoryPage.isInventoryPageLoaded(),
                "Login failed");

        // Step 2: Add product
        inventoryPage.addBackpackToCart();

        // Step 3: Open cart
        inventoryPage.openCart();

        Assert.assertTrue(cartPage.isItemDisplayed("Sauce Labs Backpack"),
                "Cart validation failed");

        // Step 4: Checkout
        checkoutPage.clickCheckout();

        // Step 5: Enter details
        checkoutPage.enterCheckoutInformation(
                "Naresh",
                "Kandula",
                "520010"
        );

        checkoutPage.clickContinue();

        // Step 6: Finish order
        checkoutPage.clickFinish();

        // Step 7: Validate success
        String successText = checkoutPage.getSuccessMessage();

        Assert.assertEquals(successText,
                "Thank you for your order!",
                "Order completion failed");
    }
}