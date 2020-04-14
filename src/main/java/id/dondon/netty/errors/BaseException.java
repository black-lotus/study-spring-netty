package id.dondon.netty.errors;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BaseException extends RuntimeException {

  private String code;
  private String message;

}
