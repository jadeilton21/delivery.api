package delivery.api.api.dtos;

public class CoverageAreaDTO {
    private String type;


    private double[][][] coordinates;


    public CoverageAreaDTO(){

    }


    public CoverageAreaDTO(String type, double[][][] coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }

    public String getType() {
        return type;
    }

    public double[][][] getCoordinates() {
        return coordinates;
    }
}
