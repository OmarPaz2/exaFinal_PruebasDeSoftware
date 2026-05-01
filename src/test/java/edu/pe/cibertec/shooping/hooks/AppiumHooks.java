package edu.pe.cibertec.shooping.hooks;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.MalformedInputException;
import java.time.Duration;

public class AppiumHooks {

    private static AndroidDriver driver;
    private static final String APPIUM_SERVER_URL = "http://127.0.0.1:4723";

    @Before
    public void setUp() throws MalformedURLException {
        if (driver != null) {
            driver.quit();
            driver = null;
        }

        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setDeviceName("emulator-5554")
                .setAppPackage("edu.pe.cibertec.shooping_cart_appium_demo")
                .setAppActivity("edu.pe.cibertec.shooping_cart_appium_demo.MainActivity")
                .setNoReset(false)
                .setNewCommandTimeout(Duration.ofSeconds(120))
                .setUiautomator2ServerInstallTimeout(Duration.ofSeconds(90))
                .setUiautomator2ServerLaunchTimeout(Duration.ofSeconds(90))
                .setAdbExecTimeout(Duration.ofSeconds(90))
                .setDisableWindowAnimation(true)
                .setClearDeviceLogsOnStart(true);

        driver = new AndroidDriver(new URL(APPIUM_SERVER_URL), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        OnStage.setTheStage(Cast.whereEveryoneCan(actor -> actor.whoCan(
                BrowseTheWeb.with(driver)
        )));
    }

    @After
    public void tearDown() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } finally {
            driver = null;
            OnStage.drawTheCurtain();
        }
    }


}
