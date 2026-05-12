package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class RemoveFromCartTest extends BaseTest {

    @Test
    public void removeProductFromCartTest() {

        LoginPage loginPage = new LoginPage();

        InventoryPage inventoryPage =
                new InventoryPage();

        // Step 1: Login
        loginPage.login(
                "standard_user",
                "secret_sauce"
        );

        Assert.assertTrue(
                inventoryPage.isInventoryPageLoaded(),
                "Login failed"
        );

        // Step 2: Add product
        inventoryPage.addBackpackToCart();

        // Step 3: Validate cart count
        Assert.assertEquals(
                inventoryPage.getCartCount(),
                "1",
                "Cart count mismatch after add"
        );

        // Step 4: Remove product
        inventoryPage.removeBackpackFromCart();

        // Small wait for UI update
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Step 5: Validate cart badge removed
        Assert.assertFalse(
                inventoryPage.isCartBadgeDisplayed(),
                "Cart badge still displayed after removal"
        );

        System.out.println(
                "Remove from cart flow completed successfully"
        );
    }
}