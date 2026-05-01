package edu.pe.cibertec.shooping.questions;

import edu.pe.cibertec.shooping.ui.TheMainScreen;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class TheMain {
    public static Question<Boolean> isVisible() {
        return Visibility.of(TheMainScreen.HOME_INDICATOR).asBoolean();
    }
}
