package com.jccruz.invoicing.handlers.exception_handler;

public record ApiErrorResponse(boolean isValid, String error, String message){}
