package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import pages.MenuPage;

public class LogoutTest extends BaseTest {

    @Test
    public void logoutTest() {

        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();
        MenuPage menuPage = new MenuPage();

        // Login
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.isInventoryPageLoaded(), "Login failed");

        // Logout
        menuPage.openMenu();
        menuPage.clickLogout();

        // Verify
        Assert.assertTrue(loginPage.isLoginPageDisplayed(), "Logout failed");
        System.out.println("Logout flow completed successfully");
    }
}