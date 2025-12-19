package com.mohamedmostafa.IMS_project.exceptions;


import com.mohamedmostafa.IMS_project.dtos.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Response<String>> globalHandler(Exception exception) {
        Response<String> response = Response.<String>builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(exception.getMessage())
                .build();
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Response<String>> notFoundHandler(NotFoundException notFoundException) {
        Response<String> response = Response.<String>builder()
                .status(HttpStatus.NOT_FOUND.value())
                .message(notFoundException.getMessage())
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
