package edu.pe.cibertec.shooping.questions;

import edu.pe.cibertec.shooping.ui.CatalogPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class TheSearchResult {
    public static Question<Boolean> contains(String productName) {
        return Visibility.of(CatalogPage.productWithText(productName)).asBoolean();
    }
}
