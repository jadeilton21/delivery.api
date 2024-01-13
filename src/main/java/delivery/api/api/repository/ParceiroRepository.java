package delivery.api.api.repository;

import delivery.api.api.domain.Parceiro;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParceiroRepository extends MongoRepository<Parceiro,String> {
}
