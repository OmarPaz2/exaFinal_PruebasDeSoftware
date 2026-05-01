package edu.pe.cibertec.shooping.tasks;

import edu.pe.cibertec.shooping.ui.CheckoutScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class FillCheckoutWithoutAddress implements Task {

    public static FillCheckoutWithoutAddress data() {
        return new FillCheckoutWithoutAddress();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(CheckoutScreen.ADDRESS_FIELD),

                Clear.field(CheckoutScreen.CITY_FIELD),
                Enter.theValue("Lima").into(CheckoutScreen.CITY_FIELD),

                Clear.field(CheckoutScreen.POSTAL_CODE_FIELD),
                Enter.theValue("15001").into(CheckoutScreen.POSTAL_CODE_FIELD),

                Clear.field(CheckoutScreen.CARD_NUMBER_FIELD),
                Enter.theValue("9876543210234567").into(CheckoutScreen.CARD_NUMBER_FIELD),

                Clear.field(CheckoutScreen.CARD_DATE_FIELD),
                Enter.theValue("10/30").into(CheckoutScreen.CARD_DATE_FIELD),

                Clear.field(CheckoutScreen.CVV_FIELD),
                Enter.theValue("197").into(CheckoutScreen.CVV_FIELD)
        );


    }
}
