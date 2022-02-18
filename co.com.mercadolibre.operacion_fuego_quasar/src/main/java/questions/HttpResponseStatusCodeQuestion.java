package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

@Subject("el código de respuesta HTTP")
public class HttpResponseStatusCodeQuestion implements Question<Integer> {
    @Override
    public Integer answeredBy(Actor actor) {
        return lastResponse().getStatusCode();
    }

    public static HttpResponseStatusCodeQuestion httpResponseStatusCodeIs() {
        return new HttpResponseStatusCodeQuestion();
    }
}
