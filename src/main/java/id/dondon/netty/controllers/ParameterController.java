package id.dondon.netty.controllers;

import id.dondon.netty.entities.Parameter;
import id.dondon.netty.services.api.ParameterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/parameter")
public class ParameterController {

  private final ParameterService parameterService;

  public ParameterController(ParameterService parameterService) {
    this.parameterService = parameterService;
  }

  @RequestMapping(path = "/id/{id}", method = RequestMethod.GET)
  public Mono<Parameter> findParameterById(@PathVariable("id") String id) {
    return parameterService.findParameterById(id);
  }

  @RequestMapping(path = "/key/{key}", method = RequestMethod.GET)
  public Mono<Parameter> findParameterByKey(@PathVariable("key") String key) {
    return parameterService.findParameterByKey(key);
  }

  @RequestMapping(path = "/set/{key}/{value}", method = RequestMethod.POST)
  public Mono<Parameter> setParameter(@PathVariable("key") String key, @PathVariable("value") String value) {
    return parameterService.setParameterValueByKey(key, value);
  }

}
