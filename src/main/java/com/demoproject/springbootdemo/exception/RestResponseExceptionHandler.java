package com.demoproject.springbootdemo.exception;

import com.demoproject.springbootdemo.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice // adding to all the controller and it will run whenever exception occurs
@ResponseStatus
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(DepartmentNotFoundException.class) //which exception it handles
    public ResponseEntity<ErrorMessage> departmentNotFoundException(DepartmentNotFoundException exception, WebRequest request){
         ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,exception.getMessage());
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }
}
