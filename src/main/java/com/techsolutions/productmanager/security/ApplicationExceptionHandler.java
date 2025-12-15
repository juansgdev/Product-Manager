package com.techsolutions.productmanager.security;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import jakarta.persistence.EntityNotFoundException;
import tools.jackson.databind.exc.UnrecognizedPropertyException;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<String> notFound (EntityNotFoundException e) {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class) 
    private ResponseEntity<String> illegalArgument (IllegalArgumentException e) {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    private ResponseEntity<String> typeMismatch () {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body("Parâmetro via url inválido!");
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    private ResponseEntity<String> messageNotReadable () {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body("Corpo inválido!");
    }

    @ExceptionHandler(NoResourceFoundException.class)
    private ResponseEntity<String> noResourceFound () {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body("Recurso não existente, requisição inválida!");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<List<String>> argumentNotValid (MethodArgumentNotValidException e) {
        List<String> errors = e.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(FieldError::getDefaultMessage)
            .toList();

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(errors);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    private ResponseEntity<String> mediaTypeNorSupported () {
        return ResponseEntity
            .status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
            .body("Tipo de mídia não suportado!");
    }
    
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    private ResponseEntity<String> requestMethodNotSupported () {
        return ResponseEntity
            .status(HttpStatus.METHOD_NOT_ALLOWED)
            .body("Método não suportado!");
    }

    @ExceptionHandler(UnrecognizedPropertyException.class)
    private ResponseEntity<String> unrecognizedProperty () {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body("Corpo com propriedade desconhecida!");
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<String> genericException () {
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("Erro interno de servidor!");
    }

}
