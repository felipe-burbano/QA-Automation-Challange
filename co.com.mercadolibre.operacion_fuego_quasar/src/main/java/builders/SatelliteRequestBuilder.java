package builders;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import net.minidev.json.JSONArray;

public class SatelliteRequestBuilder {

    //private static final String DISTANCE = "distance";
    //private static final String MESSAGE = "message";

    private JsonArray satellites = new JsonArray();

    public void addSatellite(String message) {
       // JsonObject satellite = new JsonObject();
        //satellite.addProperty(DISTANCE,distance);
        //satellites.addProperty(MESSAGE,message);
        satellites.add(message);
    }

    public String getSatellitesJsonString() {
        return satellites.toString();
    }

    public JSONArray getSatellitesJsonArrayOfJsonType() {
        try {
            return (JSONArray) new JSONParser().parse(getSatellitesJsonString());
        } catch (ParseException e) {
            return new JSONArray();
        }
    }



}
