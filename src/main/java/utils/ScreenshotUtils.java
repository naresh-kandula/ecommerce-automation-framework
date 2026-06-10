package utils;

import drivers.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    public static String captureScreenshot(String testName) {

        File source =
                ((TakesScreenshot) DriverFactory.getDriver())
                        .getScreenshotAs(OutputType.FILE);

        String relativePath =
                "screenshots/" + testName + ".png";

        String fullPath =
                System.getProperty("user.dir")
                        + "/" + relativePath;

        try {
            FileUtils.copyFile(
                    source,
                    new File(fullPath)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        return relativePath;
    }
}