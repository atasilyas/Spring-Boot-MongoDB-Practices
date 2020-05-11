package com.atasilyas.springbootmongodbpractices.advice;

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BusinessException(String resourceId) {
        super("Could not find resource with resourceId= " + resourceId);
    }

    public BusinessException(String resourceId, String message) {
        super("Could not find resource with resourceId= " + resourceId + ", Message=" +message);
    }

}