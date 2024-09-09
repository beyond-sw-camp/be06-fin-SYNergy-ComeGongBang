package com.synergy.backend.exception;

import com.synergy.backend.common.BaseException;
import com.synergy.backend.common.BaseResponse;
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
