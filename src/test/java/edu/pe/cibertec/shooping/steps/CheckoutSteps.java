package edu.pe.cibertec.shooping.steps;

import edu.pe.cibertec.shooping.questions.TheCart;
import edu.pe.cibertec.shooping.questions.TheCheckout;
import edu.pe.cibertec.shooping.questions.ThePurchase;
import edu.pe.cibertec.shooping.questions.TheCatalog;
import edu.pe.cibertec.shooping.tasks.*;
import edu.pe.cibertec.shooping.ui.CheckoutScreen;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;

public class CheckoutSteps {
    private static final String PRODUCT_NAME = "Laptop HP Pavilion";

    @Given("que el usuario tiene productos en el carrito")
    public void queElUsuarioTieneProductosEnElCarrito() {
        OnStage.theActorCalled("Usuario")
                .attemptsTo(Login.withCredentials("admin@test.com", "123456"));
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        WaitUntil.the(CheckoutScreen.productInCart(PRODUCT_NAME), isVisible())
                                .forNoMoreThan(10).seconds()
                );
        OnStage.theActorInTheSpotlight()
                .attemptsTo(PrepareCart.withProduct(PRODUCT_NAME));

        OnStage.theActorInTheSpotlight()
                .should(seeThat(TheCart.containsProduct(PRODUCT_NAME), equalTo(true)));
    }

    @When("procede al checkout")
    public void procedeAlCheckout() {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(GoToCheckout.fromCart());

        OnStage.theActorInTheSpotlight()
                .should(seeThat(TheCheckout.isVisible(), equalTo(true)));
    }

    @And("ingresa los datos de envio")
    public void ingresaLosDatosDeEnvio() {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(FillCheckoutData.complete());
    }

    @And("confirma la compra")
    public void confirmaLaCompra() {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(ConfirmPurchase.now());
    }

    @Then("deberia ver el mensaje de compra exitosa")
    public void deberiaVerElMensajeDeCompraExitosa() {
        OnStage.theActorInTheSpotlight()
                .should(seeThat(ThePurchase.isConfirmed(), equalTo(true)));
    }

    @Given("que el usuario tiene el carrito vacio")
    public void queElUsuarioTieneElCarritoVacio() {
        OnStage.theActorCalled("Usuario")
                .attemptsTo(Login.withCredentials("admin@test.com", "123456"));

        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        Click.on(CheckoutScreen.CART_TAB)
                );

        OnStage.theActorInTheSpotlight()
                .should(seeThat(TheCart.isEmpty(), equalTo(true)));
    }

    @When("intenta proceder al checkout")
    public void intentaProcederAlCheckout() {
        OnStage.theActorInTheSpotlight()
                .should(seeThat(TheCart.isVisible(), equalTo(true)));
    }

    @Then("deberia ver mensaje de carrito vacio")
    public void deberiaVerMensajeDeCarritoVacio() {
        OnStage.theActorInTheSpotlight()
                .should(seeThat(TheCart.isEmpty(), equalTo(true)));
    }

    @And("no ingresa la direccion de envio")
    public void noIngresaLaDireccionDeEnvio() {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(FillCheckoutWithoutAddress.data());
    }

    @Then("deberia ver un mensaje indicando que la direccion es obligatoria")
    public void deberiaVerUnMensajeIndicandoQueLaDireccionEsObligatoria() {
        OnStage.theActorInTheSpotlight()
                .should(seeThat(ThePurchase.requiresAddress(), equalTo(true)));
    }
}
