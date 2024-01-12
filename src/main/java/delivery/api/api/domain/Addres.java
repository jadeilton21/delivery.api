package delivery.api.api.domain;

import com.google.gson.GsonBuilder;
import com.mapbox.services.commons.geojson.custom.PositionSerializer;
import com.mapbox.services.commons.models.Position;

import java.io.Serializable;

public class Addres implements Serializable {

    private String type;

    private double[] coordinates = new double[2];



    public Addres(String type, double[] coordinates){
        this.type =type;
        this.coordinates= coordinates;
    }



    public String toJson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Position.class,new PositionSerializer());
        return gsonBuilder.create().toJson(this);
    }
}
