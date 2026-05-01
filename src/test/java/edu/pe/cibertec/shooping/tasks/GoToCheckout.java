package edu.pe.cibertec.shooping.tasks;

import edu.pe.cibertec.shooping.ui.CheckoutScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class GoToCheckout implements Task {

    public static GoToCheckout fromCart() {
        return new GoToCheckout();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CheckoutScreen.PAY_BUTTON)
        );
    }
}