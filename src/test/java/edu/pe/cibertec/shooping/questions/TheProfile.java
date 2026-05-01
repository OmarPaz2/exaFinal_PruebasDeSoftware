package edu.pe.cibertec.shooping.questions;

import edu.pe.cibertec.shooping.ui.ProfileScreen;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class TheProfile {

    public static Question<Boolean> isVisible() {
        return Visibility.of(ProfileScreen.PROFILE_TITLE).asBoolean();
    }

    public static Question<Boolean> showsUserData() {
        return actor -> Visibility.of(ProfileScreen.PERSONAL_INFO_TITLE).answeredBy(actor)
                && Visibility.of(ProfileScreen.USER_EMAIL).answeredBy(actor);
    }

    public static Question<Boolean> showsLogoutAlert() {
        return actor -> Visibility.of(ProfileScreen.LOGOUT_ALERT_TITLE).answeredBy(actor)
                && Visibility.of(ProfileScreen.LOGOUT_ALERT_MESSAGE).answeredBy(actor);
    }
}
