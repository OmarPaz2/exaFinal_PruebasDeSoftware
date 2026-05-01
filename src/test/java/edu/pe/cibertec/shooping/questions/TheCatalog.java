package edu.pe.cibertec.shooping.questions;

import edu.pe.cibertec.shooping.ui.CatalogPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class TheCatalog {
    public static Question<Boolean> isVisible() {
        return Visibility.of(CatalogPage.CATALOG_TITLE).asBoolean();
    }

    public static Question<Boolean> hasProducts() {
        return Visibility.of(CatalogPage.FIRST_PRODUCT).asBoolean();
    }
}
