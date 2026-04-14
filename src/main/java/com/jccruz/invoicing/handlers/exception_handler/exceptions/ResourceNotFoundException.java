package com.jccruz.invoicing.handlers.exception_handler.exceptions;

import com.jccruz.invoicing.handlers.exception_handler.BusinessException;
import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends BusinessException {
    public ResourceNotFoundException(String message_description) {
        super(HttpStatus.NOT_FOUND, "NOT_FOUND", message_description);
    }
}
