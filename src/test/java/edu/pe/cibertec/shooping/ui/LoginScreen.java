package edu.pe.cibertec.shooping.ui;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class LoginScreen {
    public static final Target EMAIL_FIELD = Target
            .the("email field")
            .located(AppiumBy.xpath("//android.widget.EditText[1]"));


    public static final Target PASSWORD_FIELD = Target
            .the("password field")
            .located(AppiumBy.xpath("//android.widget.EditText[2]"));


    public static final Target LOGIN_BUTTON = Target
            .the("login button")
            .located(AppiumBy.androidUIAutomator(
            "new UiSelector().className(\"android.widget.Button\").instance(1)"
    ));

    public static final Target LOGIN_TITLE = Target
            .the("login title")
            .located(AppiumBy.xpath("//android.widget.TextView[@text='Shopping Cart']"));

    public static final Target LOGIN_ERROR_MESSAGE = Target
            .the("login error message")
            .located(AppiumBy.xpath(
                    "//*[contains(@text,'Contraseña incorrecta') " +
                            "or contains(@text,'Email no registrado')]"
            ));
}
