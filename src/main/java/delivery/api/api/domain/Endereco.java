package delivery.api.api.domain;

import com.google.gson.GsonBuilder;
import com.mapbox.services.commons.geojson.custom.PositionDeserializer;
import com.mapbox.services.commons.geojson.custom.PositionSerializer;
import com.mapbox.services.commons.models.Position;

import java.io.Serializable;

public class Endereco implements Serializable {

    private String type;

    private double[] coordinates = new double[2];


    public Endereco(String type, double[] coordinates){
        this.type =type;
        this.coordinates= coordinates;
    }
    public static Endereco fromJson(String json) {
        GsonBuilder gson = new GsonBuilder();
        gson.registerTypeAdapter(Position.class, new PositionDeserializer());
        return gson.create().fromJson(json, Endereco.class);
    }


    public String toJson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Position.class,new PositionSerializer());
        return gsonBuilder.create().toJson(this);
    }

    public String getType() {
        return type;
    }

    public double[] getCoordinates() {
        return coordinates;
    }
}
