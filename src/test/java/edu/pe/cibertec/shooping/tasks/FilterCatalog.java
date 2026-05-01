package edu.pe.cibertec.shooping.tasks;


import edu.pe.cibertec.shooping.ui.CatalogPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class FilterCatalog implements Task{
    private final String category;

    public FilterCatalog(String category) {
        this.category = category;
    }

    public static FilterCatalog byCategory(String category) {
        return new FilterCatalog(category);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(CatalogPage.categoryOption(category))
        );
    }
}
