package base;

import drivers.DriverFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    @BeforeMethod
    public void setUp() {

        DriverFactory.initDriver();

        DriverFactory.getDriver()
                .get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown() {

        DriverFactory.quitDriver();
    }
}