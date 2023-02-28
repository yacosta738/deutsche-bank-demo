package com.deutsche.bank.demo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class NaceDTO {
  @NotNull(message = "Level cannot be null")
  @Min(value = 1, message = "Level must be greater than 0")
  private Integer level;
  @NotBlank(message = "Code cannot be blank")
  private String code;
  @NotBlank(message = "Parent cannot be blank")
  private String parent;
  @NotBlank(message = "Description cannot be blank")
  private String description;
  @NotBlank(message = "Includes cannot be blank")
  private String includes;
  @NotBlank(message = "AlsoIncludes cannot be blank")
  private String alsoIncludes;
  @NotBlank(message = "Rulings cannot be blank")
  private String rulings;
  @NotBlank(message = "Excludes cannot be blank")
  private String excludes;
  @NotBlank(message = "Reference cannot be blank")
  private String reference;
}
