package model.satellites;

import java.util.List;

public class MessageAndPosition {
    private String name;
    private Double distance;
    private String message;
    private Double puntoX;
    private Double puntoY;

    public Double getPuntoX(Double puntoX) {
        return this.puntoX;
    }

    public void setPuntoX(Double puntoX) {
        this.puntoX = puntoX;
    }

    public Double getPuntoY(Double puntoY) {
        return this.puntoY;
    }

    public void setPuntoY(Double puntoY) {
        this.puntoY = puntoY;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDistance(Double distance) {
        return this.distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public String getMessage(String mensaje) {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
