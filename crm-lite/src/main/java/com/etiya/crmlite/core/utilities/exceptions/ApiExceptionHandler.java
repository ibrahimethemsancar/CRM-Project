package com.etiya.crmlite.core.utilities.exceptions;

import com.etiya.crmlite.core.utilities.constants.Messages;
import com.etiya.crmlite.core.utilities.messages.IMessageSourceService;
import com.etiya.crmlite.core.utilities.results.ErrorDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
@RestControllerAdvice
public class ApiExceptionHandler {

    private IMessageSourceService messageSourceService;

    @Autowired
    public ApiExceptionHandler(IMessageSourceService messageSourceService) {
        this.messageSourceService = messageSourceService;
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
        Map<String, String> validationErrors = new HashMap<>();

        for (FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), messageSourceService.getMessage(fieldError.getDefaultMessage()));
        }

        return new ErrorDataResult<>(validationErrors, messageSourceService.getMessage(Messages.Exception.validationException));
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleBusinessException(BusinessException exception) {
        ErrorDataResult<Object> businessErrors = new ErrorDataResult<>(exception.getMessage(),
                messageSourceService.getMessage(Messages.Exception.businessException));
        return businessErrors;
    }
}
