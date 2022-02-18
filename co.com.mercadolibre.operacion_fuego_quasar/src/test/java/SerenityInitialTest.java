import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import questions.ResponseCodeQuestion;
import task.GetSatellitesTask;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
@CucumberOptions(
        features="src/test/resources/features",
        glue = "stepsdefinitions"
)

public class SerenityInitialTest {

   /*private static final String restApiUrl = "https://quasar-qa-challenge.prodeng-playground.mercadolibre.com";

    @Test
    public void getSatelliteKenobiInformation(){
        Actor APP_USER = Actor.named("Han Solo").whoCan(CallAnApi.at(restApiUrl));
        APP_USER.attemptsTo(
                GetSatellitesTask.fromSatellite("kenobi")
        );
        APP_USER.should(
                seeThat("el codigo de respuesta",ResponseCodeQuestion.was(),equalTo(200)
        ));
    }

    @Test
    public void getSatelliteSkywalkerInformation(){
        Actor APP_USER = Actor.named("Han Solo").whoCan(CallAnApi.at(restApiUrl));
        APP_USER.attemptsTo(
                GetSatellitesTask.fromSatellite("skywalker")
        );
        APP_USER.should(
                seeThat("el codigo de respuesta",ResponseCodeQuestion.was(),equalTo(200)
                ));
    }

    @Test
    public void getSatelliteSatoInformation(){
        Actor APP_USER = Actor.named("Han Solo").whoCan(CallAnApi.at(restApiUrl));
        APP_USER.attemptsTo(
                GetSatellitesTask.fromSatellite("sato")
        );
        APP_USER.should(
                seeThat("el codigo de respuesta",ResponseCodeQuestion.was(),equalTo(200)
                ));
    }
    */

}
