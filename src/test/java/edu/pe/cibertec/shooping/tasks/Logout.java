package edu.pe.cibertec.shooping.tasks;

import edu.pe.cibertec.shooping.ui.TheMainScreen;
import edu.pe.cibertec.shooping.ui.ProfileScreen;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class Logout implements Task {

    public static Logout fromProfile() {
        return new Logout();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(TheMainScreen.PROFILE_TAB),
                Click.on(ProfileScreen.LOGOUT_BUTTON),
                Click.on(ProfileScreen.CONFIRM_LOGOUT_BUTTON)
        );
    }
}