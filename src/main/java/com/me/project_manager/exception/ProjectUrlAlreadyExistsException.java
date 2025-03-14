package com.me.project_manager.exception;

public class ProjectUrlAlreadyExistsException extends RuntimeException {

    public ProjectUrlAlreadyExistsException(String message) {
        super(message);
    }
}
