package edu.pe.cibertec.shooping.questions;

import edu.pe.cibertec.shooping.ui.CheckoutScreen;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class ThePurchase {

    public static Question<Boolean> isConfirmed() {
        return Visibility.of(CheckoutScreen.ORDER_CONFIRMED).asBoolean();
    }

    public static Question<Boolean> requiresAddress() {
        return Visibility.of(CheckoutScreen.ADDRESS_REQUIRED).asBoolean();
    }
}