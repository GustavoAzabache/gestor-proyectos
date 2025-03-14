package com.me.project_manager.exception;

public class ProjectNotFoundException extends RuntimeException {

    public ProjectNotFoundException(String message) {
        super(message);
    }

}
