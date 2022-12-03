package com.kucher.la56.controller;

import com.kucher.la56.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ResponseBody
    @ExceptionHandler(ObjectcNotFoundxception.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String objectNotFoundHandler(ObjectcNotFoundxception ex) {
        return ex.getMessage();
    }
}
