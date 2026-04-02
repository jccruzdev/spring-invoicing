package com.jccruz.invoicing.handlers.exception_handler.events;

import com.jccruz.invoicing.handlers.exception_handler.BusinessException;
import org.springframework.http.HttpStatus;

public class DataIntegrityException extends BusinessException {
    public DataIntegrityException(String message_description) {
        super(HttpStatus.CONFLICT, "DATA_INTEGRITY_VIOLATION", message_description);
    }
}
