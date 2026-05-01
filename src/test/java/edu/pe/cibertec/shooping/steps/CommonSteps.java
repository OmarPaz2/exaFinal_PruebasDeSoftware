package edu.pe.cibertec.shooping.steps;

import edu.pe.cibertec.shooping.questions.TheMain;
import edu.pe.cibertec.shooping.tasks.Login;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class CommonSteps {

    @Given("que el usuario esta logueado en la aplicacion")
    public void queElUsuarioEstaLogueadoEnLaAplicacion() {
        OnStage.theActorCalled("Usuario")
                .attemptsTo(Login.withCredentials("admin@test.com", "123456"));

        OnStage.theActorInTheSpotlight()
                .should(seeThat(TheMain.isVisible(), equalTo(true)));
    }
}
