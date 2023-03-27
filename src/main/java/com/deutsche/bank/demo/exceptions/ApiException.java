package com.deutsche.bank.demo.exceptions;

import java.io.Serial;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Exception containing relevant information for API errors.
 *
 * @author Yuniel Acosta
 */
@Getter
@AllArgsConstructor
public class ApiException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = 7954487639001126933L;

  private final String code;

  private final String description;

  private final Integer statusCode;
}
