package com.synergy.backend.global.exception;

import com.synergy.backend.global.common.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<BaseResponse<?>> handleBaseException(BaseException e) {
        return new ResponseEntity<>(new BaseResponse<>(e.getStatus()), HttpStatus.BAD_REQUEST);
    }
}
