package com.okhoxi.common.spring.exception;

import com.okhoxi.common.core.exception.BaseException;
import com.okhoxi.common.spring.model.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseDTO<Object> handleException(HttpServletResponse response, BaseException e) {
        response.setStatus(e.getCode());
        log.error("", e);
        return ResponseDTO.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseDTO<Object> handleException(HttpServletResponse response, Exception e) {
        response.setStatus(HttpStatus.EXCEPTION_DEFAULT.value());
        log.error("", e);
        return ResponseDTO.error(
                HttpStatus.EXCEPTION_DEFAULT.value(),
                HttpStatus.EXCEPTION_DEFAULT.getReasonPhrase(),
                e.getMessage()
        );
    }

    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.ILLEGAL_STATE_EXCEPTION)
    public ResponseDTO<Object> handleException(IllegalStateException e) {
        log.error("", e);
        return ResponseDTO.error(e.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.ILLEGAL_ARGUMENT_EXCEPTION)
    public ResponseDTO<Object> handleException(IllegalArgumentException e) {
        log.error("", e);
        return ResponseDTO.error(e.getMessage());
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BIND_EXCEPTION)
    public ResponseDTO<Object> handleException(BindException e) {
        log.error("", e);
        return ResponseDTO.error(buildMessage(e.getFieldErrors()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.METHOD_ARGUMENT_NOT_VALID_EXCEPTION)
    public ResponseDTO<Object> handleException(MethodArgumentNotValidException e) {
        log.error("", e);
        return ResponseDTO.error(buildMessage(e.getBindingResult().getFieldErrors()));
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION)
    public ResponseDTO<Object> handleException(MissingServletRequestParameterException e) {
        log.error("", e);
        StringBuilder sb = new StringBuilder();
        buildLog(sb, e.getParameterName(), e.getMessage());
        return ResponseDTO.error(sb.toString());
    }


    ////////////////////////////////////////////////
    private void buildLog(StringBuilder sb, String field, String msg) {
        sb.append("field:[");
        sb.append(field);
        sb.append("] message:[");
        sb.append(msg);
        sb.append("]");
        log.error(sb.toString());
    }

    private String buildMessage(List<FieldError> fieldErrors) {
        StringBuilder sb = new StringBuilder();
        for (FieldError fieldError : fieldErrors) {
            buildLog(sb, fieldError.getField(), fieldError.getDefaultMessage());
        }
        return sb.toString();
    }

}
