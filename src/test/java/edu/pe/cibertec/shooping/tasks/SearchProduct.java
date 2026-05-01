package edu.pe.cibertec.shooping.tasks;

import edu.pe.cibertec.shooping.ui.CatalogPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;

public class SearchProduct implements Task{
    private final String productName;

    public SearchProduct(String productName) {
        this.productName = productName;
    }

    public static SearchProduct byName(String productName) {
        return new SearchProduct(productName);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Clear.field(CatalogPage.SEARCH_INPUT),
                Enter.theValue(productName).into(CatalogPage.SEARCH_INPUT)
        );
    }
}
