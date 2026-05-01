package edu.pe.cibertec.shooping.tasks;

import edu.pe.cibertec.shooping.ui.CheckoutScreen;
import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;

public class ConfirmPurchase implements Task {

    public static ConfirmPurchase now() {
        return new ConfirmPurchase();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            BrowseTheWeb.as(actor).getDriver().findElement(
                    AppiumBy.androidUIAutomator(
                            "new UiScrollable(new UiSelector().scrollable(true))" +
                                    ".scrollIntoView(new UiSelector().text(\"Confirmar Compra\"))"
                    )
            );
        } catch (Exception ignored) {
        }

        actor.attemptsTo(
                Click.on(CheckoutScreen.CONFIRM_PURCHASE)
        );
    }
}