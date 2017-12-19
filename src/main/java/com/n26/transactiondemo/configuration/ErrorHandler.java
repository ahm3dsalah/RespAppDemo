package com.n26.transactiondemo.configuration;

import com.n26.transactiondemo.exceptions.InvalidTransactionException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Created by MAC Windows on 12/19/2017.
 */
@ControllerAdvice
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(InvalidTransactionException.class)
    protected void handleInvalidTransactionException(
            InvalidTransactionException ex) {
    }
}
