package com.revature.flash_back_api.util.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("No resource found using provided search criteria.");
    }
}
