package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password")
        );

        Assert.assertTrue(inventoryPage.isInventoryPageLoaded(),
                "Login failed - Inventory page not loaded");
    }

    @Test
    public void invalidLoginTest() {

        LoginPage loginPage = new LoginPage();

        loginPage.login("invalid_user", "wrong_password");

        String error = loginPage.getErrorMessage();

        Assert.assertTrue(error.contains("Username and password do not match"),
                "Error message not displayed for invalid login");
    }
}