package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;

public class AddToCartTest extends BaseTest {

    @Test
    public void addProductToCartTest() {

        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();
        CartPage cartPage = new CartPage();

        // Step 1: Login
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertTrue(inventoryPage.isInventoryPageLoaded(),
                "Login failed");

        // Step 2: Add product
        inventoryPage.addBackpackToCart();

        // Step 3: Validate cart count
        String count = inventoryPage.getCartCount();
        Assert.assertEquals(count, "2", "Cart count mismatch");

        // Step 4: Open cart
        inventoryPage.openCart();

        // Step 5: Validate item
        Assert.assertTrue(cartPage.isItemDisplayed("Sauce Labs Backpack"),
                "Item not found in cart");
    }
}