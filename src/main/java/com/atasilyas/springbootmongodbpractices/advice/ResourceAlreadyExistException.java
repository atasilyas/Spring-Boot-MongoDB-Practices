package com.atasilyas.springbootmongodbpractices.advice;

public class ResourceAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ResourceAlreadyExistException(String resourceName) {
        super("Resource with resourceName={" + resourceName + "} already exists");
    }

}