package mss.global.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseData exceptionHandler(Exception e) {
        e.printStackTrace();
        return ResponseData.fail("服务器异常：" + e.getMessage());
    }
}