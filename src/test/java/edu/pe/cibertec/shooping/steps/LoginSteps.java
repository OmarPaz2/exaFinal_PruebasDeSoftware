package edu.pe.cibertec.shooping.steps;

import edu.pe.cibertec.shooping.questions.TheLogin;
import edu.pe.cibertec.shooping.questions.TheMain;
import edu.pe.cibertec.shooping.tasks.Login;
import edu.pe.cibertec.shooping.ui.LoginScreen;
import edu.pe.cibertec.shooping.ui.TheMainScreen;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.equalTo;

public class LoginSteps {
    private String email;
    private String password;

    @Given("Andrea opens the shopping Cart application")
    public void opensTheShoopingCartApplication() {
        Actor andrea = OnStage.theActorCalled("Andrea");

        andrea.should(
                seeThat(TheLogin.isVisible(), equalTo(true))
        );

    }

    @Given("she enters her email {string} and password {string}")
    public void entersHerEmailAndPassword(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @And("she taps the Login button")
    public void tapsTheLoginButton() {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(Login.withCredentials(email, password));
    }

    @Then("she should see the main screen of the application")
    public void checksTheMainScreenOfTheApplication() {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        WaitUntil.the(TheMainScreen.HOME_INDICATOR, isVisible())
                                .forNoMoreThan(10).seconds()
                );

        OnStage.theActorInTheSpotlight()
                .should(seeThat(TheMainScreen.isVisible(), equalTo(true)));
    }

    @Then("she should see a login error message")
    public void sheShouldSeeALoginErrorMessage() {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        WaitUntil.the(LoginScreen.LOGIN_ERROR_MESSAGE, isVisible())
                                .forNoMoreThan(10).seconds()
                );
        OnStage.theActorInTheSpotlight()
                .should(seeThat(TheLogin.showsErrorMessage(), equalTo(true)));
    }
}
