package delivery.api.api.service.impl;

import com.mapbox.geojson.Point;
import delivery.api.api.domain.Endereco;
import delivery.api.api.domain.Parceiro;
import delivery.api.api.dtos.ParceiroDTO;
import delivery.api.api.exception.DocumentoDuplicadoException;
import delivery.api.api.repository.ParceiroRepository;
import delivery.api.api.service.ParceiroService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;
import java.util.Optional;

public class ParceiroServiceImpl implements ParceiroService {
    @Autowired
    private final ParceiroRepository parceiroRepository;

    public ParceiroServiceImpl(ParceiroRepository parceiroRepository) {
        this.parceiroRepository = parceiroRepository;
    }

    @Override
    public ParceiroDTO cadastrar(Parceiro parceiro) {
        parceiroRepository.findParceiroByDocument(parceiro.getDocument()).ifPresent(parceiroConsultado -> {
            throw new DocumentoDuplicadoException("");
        });
        return toDTO(parceiroRepository.save(parceiro));
    }

    @Override
    public ParceiroDTO buscarPorId(String id) {
        Optional<Parceiro> parceiroConsultado = parceiroRepository.findById(id);
        if (parceiroConsultado.isPresent()) {
            return toDTO(parceiroConsultado.get());
        }
        return null;
    }

    @Override
    public Optional<Parceiro> buscarPorEndereco(double lng, double ltd) {
        Point pontoReferencia = Point.fromLngLat(lng, ltd);
        Endereco addres = Endereco.fromJson(pontoReferencia.toJson());

        return obterPontoMaisProximo(pontoReferencia, addres);
    }

    private Optional<Parceiro> obterPontoMaisProximo(Point pontoReferencia, Endereco addres) {
        return parceiroRepository.findAll()
                .stream().sorted(Comparator.comparing(parceiro -> parceiro.distanciaDe(pontoReferencia)))
                .filter(parceiro -> parceiro.atendeRegiao(addres))
                .findFirst();
    }
}
