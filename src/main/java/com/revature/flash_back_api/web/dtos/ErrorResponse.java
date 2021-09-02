package com.revature.flash_back_api.web.dtos;

import java.time.LocalDateTime;

public class ErrorResponse {

    // #TODO finish implementing class; necessary for ErrorResponseAspect

    private int statusCode;
    private String message;
    private String timestamp;

    public ErrorResponse(){

    }

    public ErrorResponse(int statusCode, String message){
        this.statusCode = statusCode;
        this.message = message;
        this.timestamp = LocalDateTime.now().toString();
    }

    //#TODO generate getters and setters, hashcode, equals, toString
}
