package id.dondon.netty.repositories;

import id.dondon.netty.entities.Parameter;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ParameterRepository extends ReactiveMongoRepository<Parameter, String> {

  Mono<Parameter> findParameterByKey(String key);

}
