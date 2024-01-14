package delivery.api.api.service;

import delivery.api.api.domain.Parceiro;
import delivery.api.api.dtos.ParceiroDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ParceiroService {
    ParceiroDTO cadastrar(Parceiro parceiro);

    ParceiroDTO buscarPorId(String id);

    Optional<Parceiro> buscarPorEndereco(double lng, double ltd);
}
