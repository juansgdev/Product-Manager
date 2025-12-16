package com.techsolutions.productmanager.security;

import java.util.List;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException; 
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

import com.techsolutions.productmanager.record.error.ApiError;

import jakarta.persistence.EntityNotFoundException;
import tools.jackson.databind.exc.UnrecognizedPropertyException;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<ApiError> notFound (EntityNotFoundException e) {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(ApiError.of(e.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class) 
    private ResponseEntity<ApiError> illegalArgument (IllegalArgumentException e) {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ApiError.of(e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    private ResponseEntity<ApiError> typeMismatch () {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ApiError.of("Parâmetro via url inválido!"));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    private ResponseEntity<ApiError> messageNotReadable () {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ApiError.of("Corpo inválido!"));
    }

    @ExceptionHandler(NoResourceFoundException.class)
    private ResponseEntity<ApiError> noResourceFound () {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(ApiError.of("Recurso não existente, requisição inválida!"));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<ApiError> argumentNotValid (MethodArgumentNotValidException e) {
        List<String> errors = e.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(FieldError::getDefaultMessage)
            .toList();

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ApiError.of(errors));
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    private ResponseEntity<ApiError> mediaTypeNorSupported () {
        return ResponseEntity
            .status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
            .body(ApiError.of("Tipo de mídia não suportado!"));
    }
    
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    private ResponseEntity<ApiError> requestMethodNotSupported () {
        return ResponseEntity
            .status(HttpStatus.METHOD_NOT_ALLOWED)
            .body(ApiError.of("Método não suportado!"));
    }

    @ExceptionHandler(UnrecognizedPropertyException.class)
    private ResponseEntity<ApiError> unrecognizedProperty () {
        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ApiError.of("Corpo com propriedade desconhecida!"));
    }

    @ExceptionHandler(Exception.class)
    private ResponseEntity<ApiError> genericException () {
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ApiError.of("Erro interno de servidor!"));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    private ResponseEntity<ApiError> constraintViolation (ConstraintViolationException e) {
        
        List<String> errors = e.getConstraintViolations()
        .stream()
        .map(ConstraintViolation::getMessage)
        .toList();

        return ResponseEntity
            .status(HttpStatus.BAD_REQUEST)
            .body(ApiError.of(errors));
    }

}
