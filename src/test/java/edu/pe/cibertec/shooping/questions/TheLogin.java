package edu.pe.cibertec.shooping.questions;

import edu.pe.cibertec.shooping.ui.LoginScreen;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class TheLogin {
    public static Question<Boolean> isVisible() {
        return Visibility.of(LoginScreen.LOGIN_TITLE).asBoolean();
    }

    public static Question<Boolean> showsErrorMessage() {
        return Visibility.of(LoginScreen.LOGIN_ERROR_MESSAGE).asBoolean();
    }
}
