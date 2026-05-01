package edu.pe.cibertec.shooping.questions;

import edu.pe.cibertec.shooping.ui.CheckoutScreen;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class TheCart {
    public static Question<Boolean> isVisible() {
        return Visibility.of(CheckoutScreen.CART_TITLE).asBoolean();
    }

    public static Question<Boolean> isEmpty() {
        return Visibility.of(CheckoutScreen.EMPTY_CART_MESSAGE).asBoolean();
    }

    public static Question<Boolean> containsProduct(String productName) {
        return Visibility.of(CheckoutScreen.productInCart(productName)).asBoolean();
    }
}
