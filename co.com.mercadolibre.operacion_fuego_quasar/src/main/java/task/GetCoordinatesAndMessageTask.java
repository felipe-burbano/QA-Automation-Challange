package task;

import io.restassured.http.ContentType;
import model.satellites.SatelliteModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetCoordinatesAndMessageTask implements Task {

    private SatelliteModel satelliteModel;
    private final String SATELLITE;


    public GetCoordinatesAndMessageTask(SatelliteModel satelliteModel, String satellite) {
        this.satelliteModel = satelliteModel;
        SATELLITE = satellite;
    }

    @Override
    @Step("{0} envia la distancia y el mensaje secreto")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/topsecret_split/"+SATELLITE)
                        .with(
                                request->request
                                        .header("Content-Type", "application/json")
                                        .and()
                                        .body(satelliteModel.getRequestBody())));
    }

    public static GetCoordinatesAndMessageTask satelliteValue(SatelliteModel satelliteModel){
            return instrumented(GetCoordinatesAndMessageTask.class, satelliteModel);
    }
}


























  /*  private final Object satelliteInformation;
    private final String satellite;

    public  GetCoordinatesAndMessageTask(Object satelliteInformation, String satellite, Double distancia, String mensaje){
        this.satelliteInformation = satelliteInformation;
        this.satellite = satellite;
    }

    public static Performable withInfo(Object satelliteInformation){
        return instrumented(GetCoordinatesAndMessageTask.class, satelliteInformation);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/topsecret_split/"+satellite)
                                .with(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(satelliteInformation))
        );
    }

   */

