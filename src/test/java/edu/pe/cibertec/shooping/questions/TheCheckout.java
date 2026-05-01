package edu.pe.cibertec.shooping.questions;

import edu.pe.cibertec.shooping.ui.CheckoutScreen;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class TheCheckout {

    public static Question<Boolean> isVisible() {
        return Visibility.of(CheckoutScreen.CHECKOUT_TITLE).asBoolean();
    }
}