package delivery.api.api.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParceiroDTO {

    private String id;

    private String tradingName;

    private String ownerName;

    private String document;

    public CoverageAreaDTO coverageArea;
    public EnderecoDTO enderecoDTO;

}
