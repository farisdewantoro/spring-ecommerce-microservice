package com.faris.spring.ecommerce.core.http;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@Builder
public class ApiResponse<TData> {
    private HttpStatus code;
    private String message;
    private TData Data;
}
