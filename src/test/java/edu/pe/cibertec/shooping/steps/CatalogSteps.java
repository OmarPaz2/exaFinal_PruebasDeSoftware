package edu.pe.cibertec.shooping.steps;

import edu.pe.cibertec.shooping.questions.TheCatalog;
import edu.pe.cibertec.shooping.questions.TheCategoryResult;
import edu.pe.cibertec.shooping.questions.TheSearchResult;
import edu.pe.cibertec.shooping.tasks.FilterCatalog;
import edu.pe.cibertec.shooping.tasks.Login;
import edu.pe.cibertec.shooping.tasks.SearchProduct;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class CatalogSteps {
    //@Given("que el usuario esta logueado en la aplicacion")
     //esto esta implementado en CommonSteps

    @When("navega al catalogo de productos")
    public void navegaAlCatalogoDeProductos() {
        OnStage.theActorInTheSpotlight()
                .should(seeThat(TheCatalog.isVisible(), equalTo(true)));
    }

    @Then("deberia ver la lista de productos disponibles")
    public void deberiaVerLaListaDeProductosDisponibles() {
        OnStage.theActorInTheSpotlight()
                .should(seeThat(TheCatalog.hasProducts(), equalTo(true)));
    }

    @Given("que el usuario esta en el catalogo")
    public void queElUsuarioEstaEnElCatalogo() {
        OnStage.theActorCalled("Usuario")
                .attemptsTo(Login.withCredentials("user1@test.com", "password1"));

        OnStage.theActorInTheSpotlight()
                .should(seeThat(TheCatalog.isVisible(), equalTo(true)));
    }

    @When("busca el producto {string}")
    public void buscaElProducto(String productName) {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(SearchProduct.byName(productName));
    }

    @Then("deberia ver productos que contengan {string}")
    public void deberiaVerProductosQueContengan(String productName) {
        OnStage.theActorInTheSpotlight()
                .should(seeThat(TheSearchResult.contains(productName), equalTo(true)));
    }

    @When("filtra productos por la categoria {string}")
    public void filtraProductosPorLaCategoria(String category) {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(FilterCatalog.byCategory(category));
    }

    @Then("deberia ver productos de la categoria {string}")
    public void deberiaVerProductosDeLaCategoria(String category) {
        OnStage.theActorInTheSpotlight()
                .should(seeThat(TheCategoryResult.showsProductFor(category), equalTo(true)));
    }
}
