package com.schedule.appointment.ResourceService.exception;

public class ResourceServiceCustomException extends RuntimeException{

    private String errorCode;

    public ResourceServiceCustomException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
