package delivery.api.api.dtos;

import com.google.gson.GsonBuilder;
import com.mapbox.services.commons.geojson.custom.PositionDeserializer;
import com.mapbox.services.commons.geojson.custom.PositionSerializer;
import com.mongodb.client.model.geojson.Position;

public class EnderecoDTO {


    private Long id;
    private String type;
    private double[] cordinates;

    public EnderecoDTO(){

    }

    public EnderecoDTO(String type, double[] cordinates) {
        this.type = type;
        this.cordinates = cordinates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double[] getCordinates() {
        return cordinates;
    }

    public void setCordinates(double[] cordinates) {
        this.cordinates = cordinates;
    }

    public static EnderecoDTO fromJson(String json) {
        GsonBuilder gson = new GsonBuilder();
        gson.registerTypeAdapter(Position.class, new PositionDeserializer());
        return gson.create().fromJson(json, EnderecoDTO.class);
    }
    public String toJson(){
        GsonBuilder gson = new GsonBuilder();
        gson.registerTypeAdapter(Position.class,new PositionSerializer());
        return gson.create().toJson(this);
    }


}
