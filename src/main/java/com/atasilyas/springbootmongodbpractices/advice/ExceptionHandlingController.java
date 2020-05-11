package com.atasilyas.springbootmongodbpractices.advice;

import com.atasilyas.springbootmongodbpractices.service.UserServiceCriteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

@RestControllerAdvice
public class ExceptionHandlingController extends ResponseEntityExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(UserServiceCriteria.class);

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {

        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }
        log.warn("!!!!!Exception:" + ex.getMessage() + ", Status:" + status.name());
        ExceptionResponse response = new ExceptionResponse();
        response.setException(ex.getClass().getSimpleName());
        response.setMessage(status.name() + ":" + ex.getMessage());
        response.setDetails(request.getDescription(false));
        return new ResponseEntity<>(response, headers, status);
    }

    @ResponseBody
    @ExceptionHandler(ResourceAlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String resourceAlreadyExists(ResourceAlreadyExistException ex) {
        return ex.getMessage();

    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFoundHandler(BusinessException ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse();
        response.setException(HttpStatus.NOT_FOUND.name());
        response.setMessage(ex.getMessage());
        response.setDetails(request.getDescription(false));

        return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
    }

}