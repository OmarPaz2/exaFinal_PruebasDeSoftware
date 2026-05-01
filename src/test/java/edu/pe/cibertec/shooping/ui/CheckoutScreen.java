package edu.pe.cibertec.shooping.ui;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class CheckoutScreen {
    public static Target productByName(String productName) {
        return Target
                .the("product " + productName)
                .located(AppiumBy.xpath("//android.widget.TextView[@text='" + productName + "']"));
    }

    public static final Target ADD_TO_CART_BUTTON = Target
            .the("add to cart button")
            .located(AppiumBy.xpath("//android.widget.TextView[@text='Agregar al carrito']"));

    public static final Target CART_TAB = Target
            .the("cart tab")
            .located(AppiumBy.xpath("//android.widget.TextView[@text='Carrito']"));

    public static final Target CART_TITLE = Target
            .the("cart title")
            .located(AppiumBy.xpath("//android.widget.TextView[@text='Carrito de Compras']"));

    public static final Target EMPTY_CART_MESSAGE = Target
            .the("empty cart message")
            .located(AppiumBy.xpath("//android.widget.TextView[@text='Tu carrito está vacío']"));

    public static Target productInCart(String productName) {
        return Target
                .the("product in cart " + productName)
                .located(AppiumBy.xpath("//android.widget.TextView[@text='" + productName + "']"));
    }

    public static final Target PAY_BUTTON = Target
            .the("pay button")
            .located(AppiumBy.xpath("//android.widget.TextView[@text='Proceder al Pago']"));

    public static final Target CHECKOUT_TITLE = Target
            .the("checkout title")
            .located(AppiumBy.xpath("//android.widget.TextView[@text='Checkout']"));

    public static final Target ADDRESS_FIELD = Target
            .the("address field")
            .located(AppiumBy.xpath("(//android.widget.EditText)[1]"));

    public static final Target CITY_FIELD = Target
            .the("city field")
            .located(AppiumBy.xpath("(//android.widget.EditText)[2]"));

    public static final Target POSTAL_CODE_FIELD = Target
            .the("postal code field")
            .located(AppiumBy.xpath("(//android.widget.EditText)[3]"));

    public static final Target CARD_NUMBER_FIELD = Target
            .the("card number field")
            .located(AppiumBy.xpath("(//android.widget.EditText)[4]"));

    public static final Target CARD_DATE_FIELD = Target
            .the("card date field")
            .located(AppiumBy.xpath("(//android.widget.EditText)[5]"));

    public static final Target CVV_FIELD = Target
            .the("cvv field")
            .located(AppiumBy.xpath("(//android.widget.EditText)[6]"));

    public static final Target CONFIRM_PURCHASE = Target
            .the("confirm purchase button")
            .located(AppiumBy.xpath("//android.widget.TextView[@text='Confirmar Compra']"));

    public static final Target ORDER_CONFIRMED = Target
            .the("order confirmed message")
            .located(AppiumBy.xpath("//android.widget.TextView[@text='¡Pedido Confirmado!']"));

    public static final Target ADDRESS_REQUIRED = Target
            .the("address required message")
            .located(AppiumBy.xpath("//*[contains(@text,'dirección es requerida')]"));
}