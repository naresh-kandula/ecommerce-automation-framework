package utils;

import drivers.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    public static void captureScreenshot(String testName) {

        File source = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);

        String destination = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";

        try {

            FileUtils.copyFile(source, new File(destination));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}