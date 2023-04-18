package com.espritech.security.config.handlers;


import com.espritech.security.config.exception.ErrorCodes;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDto {

  private Integer httpCode;

  private ErrorCodes code;

  private String message;

  private List<String> errors = new ArrayList<>();

}
