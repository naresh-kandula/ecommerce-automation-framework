package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class EmptyLoginTest extends BaseTest {

    @Test
    public void emptyLoginTest() {

        LoginPage loginPage = new LoginPage();

        loginPage.login("", "");

        Assert.assertTrue(loginPage.getLoginErrorMessage().contains("Username is required"), "Validation message mismatch");

        System.out.println("Empty login validation successful");
    }
}