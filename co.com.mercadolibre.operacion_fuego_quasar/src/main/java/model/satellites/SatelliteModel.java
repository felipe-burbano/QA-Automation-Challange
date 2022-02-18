package model.satellites;

import builders.SatelliteRequestBuilder;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONObject;

public class SatelliteModel {

    private DocumentContext documentContext = JsonPath.parse(new JSONObject());

    public SatelliteModel(){
    }

    public String getRequestBody() {
        return documentContext.jsonString();
    }

    public static class Builder {

        private SatelliteModel satelliteModel = new SatelliteModel();
        private SatelliteRequestBuilder satelliteRequestBuilder = new SatelliteRequestBuilder();


        private Builder(Double satelliteDistance){
            satelliteModel.documentContext.put("$","distance",satelliteDistance);
        }

        public static Builder withSatelliteDistance(Double satelliteDistance){
            return new Builder(satelliteDistance);
        }

        public SatelliteModel andSatelliteMessage(String satelliteMessage){
            satelliteRequestBuilder.addSatellite(satelliteMessage);
            satelliteModel.documentContext.put("$","[]",satelliteRequestBuilder.getSatellitesJsonArrayOfJsonType());
            return satelliteModel;
        }

        /*public Builder SatelliteInformation(Double satelliteDistance, String satelliteMessage){
            satelliteRequestBuilder.addSatellite(satelliteMessage);
            satelliteModel.documentContext.put("$","[]",satelliteRequestBuilder.getSatellitesJsonArrayOfJsonType());
            return this;
        }*/

    }

}
