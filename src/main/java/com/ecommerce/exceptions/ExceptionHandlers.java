package com.ecommerce.exceptions;

import com.ecommerce.dto.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@Slf4j
public class ExceptionHandlers {

    @ExceptionHandler(ModelNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseEntity<BaseResponse<String>> handleModelNotFoundException(final ModelNotFoundException exception){
        log.error("ModelNotFoundException: "+exception.getMessage());
        BaseResponse<String> baseResponse = new BaseResponse<>(HttpStatus.NOT_FOUND.value(), exception.getMessage(), null, exception.getMessage());
        return new ResponseEntity<>(baseResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyPresentException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ResponseEntity<BaseResponse<String>> handleUserAlreadyPresentException(final UserAlreadyPresentException exception){
        log.error("UserAlreadyPresentException: "+exception.getMessage());
        BaseResponse<String> baseResponse = new BaseResponse<>(HttpStatus.CONFLICT.value(), exception.getMessage(), null, exception.getMessage());
        return new ResponseEntity<>(baseResponse,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<BaseResponse<Map<String,String>>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        BaseResponse<Map<String, String>> baseResponse = new BaseResponse<>(HttpStatus.BAD_REQUEST.value(), "validations.error", null, errors);
        return new ResponseEntity<>(baseResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<BaseResponse<String>> handleException(final RuntimeException exception){
        BaseResponse<String> baseResponse = new BaseResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(), null, exception.getMessage());
        return new ResponseEntity<>(baseResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
