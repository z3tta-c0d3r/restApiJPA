package com.inss.imv.restapi.util.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GlobalExceptionResponse {
    private int code;
    private String message;
    private String detail;
}
