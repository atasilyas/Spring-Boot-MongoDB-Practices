package com.atasilyas.springbootmongodbpractices.advice;

public class ExceptionResponse {

    private String exception;
    private String message;
    private String details;

    public ExceptionResponse() {
    }

    public ExceptionResponse(String exception, String message, String details) {
        super();
        this.exception = exception;
        this.message = message;
        this.details = details;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}