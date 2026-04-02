package com.jccruz.invoicing.handlers.exception_handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ApiErrorResponse> handleBusinessException(BusinessException ex){
        ApiErrorResponse response = new ApiErrorResponse(ex.getMessage_code(), ex.getMessage_description());
        return ResponseEntity
                .status(ex.getHttp_status())
                .body(response);
    }

}
