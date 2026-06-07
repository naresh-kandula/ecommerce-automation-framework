package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LockedUserLoginTest extends BaseTest {

    @Test
    public void lockedUserLoginTest() {

        LoginPage loginPage = new LoginPage();

        loginPage.login("locked_out_user", "secret_sauce");

        Assert.assertEquals(loginPage.getLoginErrorMessage(), "Epic sadface: Sorry, this user has been locked out.", "Incorrect error message");

        System.out.println("Locked user validation successful");
    }
}