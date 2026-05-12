package tests;

import base.BaseTest;
import data.LoginTestData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class DataDrivenLoginTest extends BaseTest {

    @Test(dataProvider = "loginData",
            dataProviderClass = LoginTestData.class)

    public void loginValidationTest(String username,
                                    String password) {

        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();

        loginPage.login(username, password);

        boolean loginSuccess =
                inventoryPage.isInventoryPageLoaded();

        System.out.println(
                "Username: " + username +
                        " | Login Success: " + loginSuccess
        );

        // Positive validation
        if(username.equals("standard_user")) {

            Assert.assertTrue(loginSuccess,
                    "Valid user failed to login");
        }

        // Negative validation
        else {

            Assert.assertFalse(loginSuccess,
                    "Invalid user unexpectedly logged in");
        }
    }
}