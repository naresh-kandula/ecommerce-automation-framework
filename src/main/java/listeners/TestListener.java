package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("Listener Triggered");

        System.out.println("TEST FAILED: " + result.getName());

        ScreenshotUtils.captureScreenshot(result.getName());
    }
}