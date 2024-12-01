package com.ecommerce.exceptions;

import com.ecommerce.dto.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class ExceptionHandlers {

    @ExceptionHandler(ModelNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public BaseResponse<String> handleModelNotFoundException(final ModelNotFoundException exception){
        log.error("ModelNotFoundException: "+exception.getMessage());
        return new BaseResponse<>(HttpStatus.NOT_FOUND.value(),exception.getMessage(),null,exception.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public BaseResponse<String> handleException(final RuntimeException exception){
        return new BaseResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value() ,exception.getMessage(),null,exception.getMessage());
    }

}
