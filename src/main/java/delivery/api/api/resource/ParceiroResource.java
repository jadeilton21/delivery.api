package delivery.api.api.resource;

import delivery.api.api.dtos.ParceiroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/parceiros")
public class ParceiroResource {
    @Service
    private ParceiroService parceiroService;
    @PostMapping
    public ResponseEntity cadastrarParceiro(@RequestBody @Valid ParceiroDTO parceiroDTO) throws URISyntaxException {
        ParceiroDTO parceiroCadastrado = parceiroService.cadastrar(toEntity(parceiroDTO));
        return ResponseEntity.created(new URI(parceiroCadastrado.getId())).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParceiroDTO> buscarPorId(@PathVariable("id") String id) {
        ParceiroDTO parceiroDTO = parceiroService.buscarPorId(id);
        return ResponseEntity.ok(parceiroDTO);
    }

    @GetMapping("/proximo")
    public ResponseEntity<ParceiroDTO> buscarParceiro(@RequestParam("long") double lng, @RequestParam("lat") double lat) {
        return parceiroService.buscarPorEndereco(lng, lat)
                .map(parceiro -> ResponseEntity.ok(toDTO(parceiro)))
                .orElse(ResponseEntity.notFound().build());
    }
}
