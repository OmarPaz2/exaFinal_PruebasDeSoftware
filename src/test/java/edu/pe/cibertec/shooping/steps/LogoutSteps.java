package edu.pe.cibertec.shooping.steps;

import edu.pe.cibertec.shooping.questions.TheMain;
import edu.pe.cibertec.shooping.questions.TheLogin;
import edu.pe.cibertec.shooping.questions.TheProfile;
import edu.pe.cibertec.shooping.tasks.Login;
import edu.pe.cibertec.shooping.ui.TheMainScreen;
import edu.pe.cibertec.shooping.ui.ProfileScreen;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class LogoutSteps {

    private static final String ACTOR_NAME = "Usuario";

    //@Given("que el usuario esta logueado en la aplicacion")
    //esto esta implementado en CommonSteps

    @When("hace clic en el menu de usuario")
    public void haceClicEnElMenuDeUsuario() {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(Click.on(TheMainScreen.PROFILE_TAB));

        OnStage.theActorInTheSpotlight()
                .should(seeThat(TheProfile.isVisible(), equalTo(true)));

        OnStage.theActorInTheSpotlight()
                .should(seeThat(TheProfile.showsUserData(), equalTo(true)));
    }

    @And("hace clic en cerrar sesion")
    public void haceClicEnCerrarSesion() {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(Click.on(ProfileScreen.LOGOUT_BUTTON));

        OnStage.theActorInTheSpotlight()
                .should(seeThat(TheProfile.showsLogoutAlert(), equalTo(true)));

        OnStage.theActorInTheSpotlight()
                .attemptsTo(Click.on(ProfileScreen.CONFIRM_LOGOUT_BUTTON));
    }

    @Then("deberia regresar a la pantalla de login")
    public void deberiaRegresarALaPantallaDeLogin() {
        OnStage.theActorInTheSpotlight()
                .should(seeThat(TheLogin.isVisible(), equalTo(true)));
    }
}
