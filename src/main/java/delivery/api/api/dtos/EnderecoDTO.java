package delivery.api.api.dtos;

public class EnderecoDTO {

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
}
