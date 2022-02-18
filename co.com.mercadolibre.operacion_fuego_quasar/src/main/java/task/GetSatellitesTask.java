package task;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetSatellitesTask implements Task {

    private final String satellite;

    public GetSatellitesTask(String satellite) {
        this.satellite = satellite;
    }

    public static Performable fromSatellite(String satellite){
        return instrumented(GetSatellitesTask.class,satellite);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("/topsecret_split?satellite_name="+satellite)
                        .with(requestSpecification -> requestSpecification.contentType(ContentType.JSON))
        );
    }
}
