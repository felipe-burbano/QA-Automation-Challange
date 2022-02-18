package stepsdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import utils.SharedData;
import model.satellites.SatelliteModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.annotations.Steps;


import questions.SatelliteQuestion;
import task.GetCoordinatesAndMessageTask;
import task.GetSatellitesTask;
import utils.SharedData;

//import static model.satellites.SatelliteModel.Builder.forSatellite;
import static model.satellites.SatelliteModel.Builder.withSatelliteDistance;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static questions.HttpResponseStatusCodeQuestion.httpResponseStatusCodeIs;
import static task.GetCoordinatesAndMessageTask.satelliteValue;

public class SendMessageAndPositionStepDefinitions {

    @Steps(shared = true)
    SharedData sharedData;

    private static final String restApiUrl = "https://quasar-qa-challenge.prodeng-playground.mercadolibre.com";
    Actor APP_USER;
    String satelliteInformation,mensaje;
    Double distancia;

    @Dado("^que se ha enviado el mensaje hacia el satelite  (.*)")
    public void queSeHaEnviadoElMensajeHaciaElSatelite(String satellite) {
        APP_USER = Actor.named("Han Solo")
                .whoCan(CallAnApi.at(restApiUrl)
                );

        APP_USER.attemptsTo(
                GetCoordinatesAndMessageTask.satelliteValue(new SatelliteModel())
        );
    }

    @Cuando("^se envia la distancia (.*) y el mensaje secreto (.*)$")
    public void seEnviaLaDistanciaYelMensaje() {


        APP_USER.attemptsTo(
                satelliteValue(
                                withSatelliteDistance(sharedData.getSateliteDistance())
                                        .andSatelliteMessage(sharedData.getSatelliteMessage())
                )
        );

        APP_USER.should(seeThat(httpResponseStatusCodeIs(),equalTo(200)));
    }

    @Entonces("^la informacion se almacena correctamente$")
    public void seObtieneLasCoordenadasYConElEsteEsUnMensajeSecreto() {

        APP_USER.should(seeThat(
                "El codigo de respuesta es",
                SatelliteQuestion.message("Información guardada correctamente")
        ));
    }
}
