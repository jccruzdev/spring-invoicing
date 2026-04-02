package com.jccruz.invoicing.handlers.exception_handler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public abstract class BusinessException extends RuntimeException{
    private final HttpStatus http_status;
    private final String message_code;
    private final String message_description;
}
