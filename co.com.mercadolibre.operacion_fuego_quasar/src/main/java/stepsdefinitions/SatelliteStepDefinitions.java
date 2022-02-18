package stepsdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Steps;
import questions.ResponseCodeQuestion;
import task.GetSatellitesTask;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;
import static task.GetCoordinatesAndMessageTask.satelliteValue;

public class SatelliteStepDefinitions {



    String satellite;
    Actor actor;
    private static final String restApiUrl = "https://quasar-qa-challenge.prodeng-playground.mercadolibre.com";

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^tengo la disponibilidad del satelite$")
    public void tengo_la_disponibilidad_del_satelite() {
        actor = Actor.named("Andres Felipe")
                .whoCan(CallAnApi.at(restApiUrl));
    }

    @Cuando("^se envia el nombre del satelite (.*)$")
    public void seRealizaLaPeticionDelSatelite(String satellite) {
       this.satellite = satellite;
        actor.attemptsTo(
                GetSatellitesTask.fromSatellite(satellite)
        );

    }

    @Entonces("^obtengo las coordenadas y el mensaje$")
    public void obtengoLasCoordenadasYElMensaje() {

    actor.should(seeThat(
            "El codigo de respuesta es",
            ResponseCodeQuestion.was(),
            equalTo(200)
    ));
    }


}
