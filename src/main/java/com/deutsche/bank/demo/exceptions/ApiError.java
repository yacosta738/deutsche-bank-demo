package com.deutsche.bank.demo.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Class containing relevant information from an API call error.
 *
 * @author Yuniel Acosta
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {

  private String error;

  private String message;

  private int status;
}
