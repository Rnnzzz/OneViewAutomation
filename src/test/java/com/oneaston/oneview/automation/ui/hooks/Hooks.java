package com.oneaston.oneview.automation.ui.hooks;

import com.oneaston.oneview.automation.ui.utils.webdriver.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Hooks {

    @Before
    public static void setUp() {
        {
            System.setProperty("ov_url", "http://172.31.27.138:8080/OACredit/login");
        }
        WebDriverFactory.setUpDriver();
    }

    @After
    public static void tearDown(Scenario scenario) {
        takeScreenshot(scenario);
        WebDriverFactory.tearDown();
    }

    private static void takeScreenshot(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName() + getTimeStamp());
    }

    public static String getTimeStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("hhmmss");
        return (sdf.format(new Date()));
    }

}
