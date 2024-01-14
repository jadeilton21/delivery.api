package delivery.api.api.resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/parceiros")
public class ParceiroResource {
    @Service
    private ParceiroService parceiroService;
}
