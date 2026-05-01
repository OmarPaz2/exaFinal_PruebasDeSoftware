package edu.pe.cibertec.shooping.tasks;

import edu.pe.cibertec.shooping.ui.CheckoutScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;


public class PrepareCart implements Task {

    private final String productName;

    public PrepareCart(String productName) {
        this.productName = productName;
    }

    public static PrepareCart withProduct(String productName) {
        return new PrepareCart(productName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CheckoutScreen.productByName(productName)),
                Click.on(CheckoutScreen.ADD_TO_CART_BUTTON)
        );

        try {
            BrowseTheWeb.as(actor).getDriver().navigate().back();
        } catch (Exception ignored) {
        }

        actor.attemptsTo(
                Click.on(CheckoutScreen.CART_TAB)
        );
    }
}
