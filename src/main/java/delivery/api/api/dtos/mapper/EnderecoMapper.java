package delivery.api.api.dtos.mapper;

import delivery.api.api.domain.Endereco;
import delivery.api.api.dtos.EnderecoDTO;

public class EnderecoMapper {

    public static Endereco toEntity(EnderecoDTO addressDTO) {
    return new Endereco(addressDTO.getType(), addressDTO.getCordinates());
}

    public static EnderecoDTO toDTO(Endereco address) {
        return new EnderecoDTO(address.getType(), address.getCoordinates());
    }
}
