package id.dondon.netty.services.impl;

import id.dondon.netty.entities.Parameter;
import id.dondon.netty.errors.BaseException;
import id.dondon.netty.repositories.ParameterRepository;
import id.dondon.netty.services.api.ParameterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ParameterServiceImpl implements ParameterService {

  private final ParameterRepository parameterRepository;

  public ParameterServiceImpl(ParameterRepository parameterRepository) {
    this.parameterRepository = parameterRepository;
  }

  @Override
  public Mono<Parameter> findParameterById(String id) {
    return parameterRepository.findById(id)
        .switchIfEmpty(Mono.error(BaseException.builder()
            .code("DATA_NOT_EXIST")
            .message("Data not exist")
            .build()))
        .onErrorResume(throwable -> {
          log.error("find parameter by id {} has error {}", id, throwable);
          return Mono.error(throwable);
        });
  }

  @Override
  public Mono<Parameter> findParameterByKey(String key) {
    return parameterRepository.findParameterByKey(key)
        .switchIfEmpty(Mono.error(BaseException.builder()
            .code("DATA_NOT_EXIST")
            .message("Data not exist")
            .build()))
        .onErrorResume(throwable -> {
          log.error("find parameter by key {} has error {}", key, throwable);
          return Mono.error(throwable);
        });
  }

  @Override
  public Mono<Parameter> setParameterValueByKey(String key, String value) {
    return parameterRepository.findParameterByKey(key)
        .switchIfEmpty(Mono.defer(() -> {
          Parameter parameter = Parameter.builder()
              .key(key)
              .value(value)
              .description("not necessary")
              .build();

          return Mono.just(parameter);
        }))
        .map(parameter -> {
          parameter.setValue(value);
          return parameter;
        })
        .flatMap(parameterRepository::save)
        .onErrorResume(throwable -> {
          log.error("set parameter by key {} and value {} has error {}", key, value, throwable);
          return Mono.error(throwable);
        });
  }
}
