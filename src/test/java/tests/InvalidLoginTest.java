package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class InvalidLoginTest extends BaseTest {

    @Test
    public void invalidLoginTest() {

        LoginPage loginPage = new LoginPage();

        loginPage.login("standard_user", "wrong_password");

        Assert.assertTrue(loginPage.getLoginErrorMessage().contains("Username and password do not match"), "Error message mismatch");

        System.out.println("Invalid login validation successful");
    }
}