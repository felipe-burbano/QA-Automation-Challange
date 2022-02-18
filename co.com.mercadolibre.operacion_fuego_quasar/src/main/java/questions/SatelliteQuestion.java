package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class SatelliteQuestion implements Question {

    private String message;

    public SatelliteQuestion(String message) {
    }

    @Override
    public String answeredBy(Actor actor) {
       String satellitePositionAndMessage = lastResponse().jsonPath().getString("");
       return satellitePositionAndMessage;
    }

    public static SatelliteQuestion possition(){
      //  return new SatelliteQuestion();
        return null;
    }
    public static SatelliteQuestion message(String message){
        return new SatelliteQuestion(message);
    }
}
