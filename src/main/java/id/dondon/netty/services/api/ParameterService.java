package id.dondon.netty.services.api;

import id.dondon.netty.entities.Parameter;
import reactor.core.publisher.Mono;

public interface ParameterService {

  Mono<Parameter> findParameterById(String id);
  Mono<Parameter> findParameterByKey(String key);
  Mono<Parameter> setParameterValueByKey(String key, String value);

}
