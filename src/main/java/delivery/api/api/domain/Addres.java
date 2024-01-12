package delivery.api.api.domain;

import java.io.Serializable;

public class Addres implements Serializable {

    private String type;

    private double[] coordinates = new double[2];



    public Addres(String type, double[] coordinates){
        this.type =type;
        this.coordinates= coordinates;
    }


}
