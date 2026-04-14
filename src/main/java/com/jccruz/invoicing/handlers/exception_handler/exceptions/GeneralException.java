package com.jccruz.invoicing.handlers.exception_handler.exceptions;

import com.jccruz.invoicing.handlers.exception_handler.BusinessException;
import org.springframework.http.HttpStatus;

public class GeneralException extends BusinessException {
    public GeneralException(String message_description) {
        super(HttpStatus.BAD_REQUEST, "GENERAL_ERROR", message_description);
    }
}
