package com.synergy.backend.global.exception;

import com.synergy.backend.global.common.BaseResponse;
import com.synergy.backend.global.common.BaseResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 400
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<BaseResponse<?>> handleBaseException(BaseException e) {
        return new ResponseEntity<>(new BaseResponse<>(e.getStatus()), HttpStatus.BAD_REQUEST);
    }

    // 404
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<BaseResponse<?>> handle404(NoHandlerFoundException e) {
        return new ResponseEntity<>(new BaseResponse<>(BaseResponseStatus.NOT_FOUND),
                HttpStatus.NOT_FOUND);
    }

    // 500
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<BaseResponse<?>> handle500(Exception e) {
//        return new ResponseEntity<>(new BaseResponse<>(BaseResponseStatus.INTERNAL_SERVER_ERROR),
//                HttpStatus.INTERNAL_SERVER_ERROR);
//    }

}
