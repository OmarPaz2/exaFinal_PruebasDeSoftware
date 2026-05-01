package edu.pe.cibertec.shooping.questions;

import edu.pe.cibertec.shooping.ui.CatalogPage;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;


public class TheCategoryResult {
    public static Question<Boolean> showsProductFor(String category) {
        return Visibility.of(CatalogPage.productFromCategory(category)).asBoolean();
    }
}
