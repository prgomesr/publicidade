package devllop.api.publicidade.repository;

import devllop.api.publicidade.model.Lojista;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LojistaRepository extends MongoRepository<Lojista, String> {
}
