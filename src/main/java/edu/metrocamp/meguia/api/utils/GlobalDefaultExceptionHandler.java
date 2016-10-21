package edu.metrocamp.meguia.api.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.metrocamp.meguia.api.dtos.JsonErro;
import edu.metrocamp.meguia.api.exceptions.AbstractMeGuiaException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(AbstractMeGuiaException.class)
    public ResponseEntity<JsonErro> handleMeGuiaException(final HttpServletRequest request,
                                             final HttpServletResponse response,
                                             final AbstractMeGuiaException ex) {

        final JsonErro error = new JsonErro(ex.getCodigo(), ex.getMensagem());

        return new ResponseEntity<>(error, ex.getHttpStatus());
    }
    
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<JsonErro> handleException(final HttpServletRequest request,
                                             final HttpServletResponse response,
                                             final Exception ex) {

        final JsonErro error = new JsonErro(9999, "Um erro inexperado ocorreu! :o");

        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
