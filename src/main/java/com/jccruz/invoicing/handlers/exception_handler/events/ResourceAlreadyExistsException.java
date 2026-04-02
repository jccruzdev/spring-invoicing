package com.jccruz.invoicing.handlers.exception_handler.events;

import com.jccruz.invoicing.handlers.exception_handler.BusinessException;
import org.springframework.http.HttpStatus;

public class ResourceAlreadyExistsException extends BusinessException {
    public ResourceAlreadyExistsException(String message_description) {
        super(HttpStatus.CONFLICT, "ALREADY_EXISTS", message_description);
    }
}
