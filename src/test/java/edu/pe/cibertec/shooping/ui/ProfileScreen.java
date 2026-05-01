package edu.pe.cibertec.shooping.ui;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class ProfileScreen {
    public static final Target PROFILE_TITLE = Target
            .the("profile title")
            .located(AppiumBy.xpath("//android.widget.TextView[@text='Mi Perfil']"));

    public static final Target PERSONAL_INFO_TITLE = Target
            .the("personal information title")
            .located(AppiumBy.xpath("//android.widget.TextView[@text='Información Personal']"));

    public static final Target USER_EMAIL = Target
            .the("user email shown")
            .located(AppiumBy.xpath("//*[contains(@text,'@')]"));

    public static final Target LOGOUT_BUTTON = Target
            .the("logout button")
            .located(AppiumBy.accessibilityId("Cerrar sesión"));

    public static final Target LOGOUT_ALERT_TITLE = Target
            .the("logout alert title")
            .located(AppiumBy.xpath("//android.widget.TextView[@text='Cerrar Sesión']"));

    public static final Target LOGOUT_ALERT_MESSAGE = Target
            .the("logout alert message")
            .located(AppiumBy.xpath("//android.widget.TextView[@text='¿Estás seguro que deseas cerrar sesión?']"));

    public static final Target CONFIRM_LOGOUT_BUTTON = Target
            .the("confirm logout button")
            .located(AppiumBy.xpath("//android.widget.TextView[@text='Sí, cerrar sesión']"));
}
