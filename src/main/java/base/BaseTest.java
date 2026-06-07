package base;

import drivers.DriverFactory;
import listeners.TestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners(TestListener.class)
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