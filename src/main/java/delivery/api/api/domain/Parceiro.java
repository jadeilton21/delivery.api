package delivery.api.api.domain;

import com.mapbox.geojson.Point;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;
import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "parceiros")
public class Parceiro implements Serializable {


    @Id
    private String id;
    private String tradingName;
    private String ownerName;
    private String document;
    private Endereco endereco;

    private CoverageArea coverageArea;


    public Parceiro(String tradingName, String ownerName, String document, Endereco endereco, CoverageArea coverageArea) {
        this.tradingName = tradingName;
        this.ownerName = ownerName;
        this.document = document;
        this.endereco = endereco;
        this.coverageArea = coverageArea;
    }


    public String getId() {
        return id;
    }

    public String getTradingName() {
        return tradingName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getDocument() {
        return document;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public CoverageArea getCoverageArea() {
        return coverageArea;
    }
    public boolean atendeRegiao(Endereco addres){
        return this.coverageArea.estaContido(addres);
    }

    public double disstanciaDe(Point pontoReferencia){
        Point point = Point.fromJson(this.getEndereco().toJson());
        return this.getCoverageArea().distanciaEmCentimetros(point,pontoReferencia);
    }
}
