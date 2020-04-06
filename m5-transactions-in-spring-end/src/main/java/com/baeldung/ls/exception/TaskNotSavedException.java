package com.baeldung.ls.exception;

public class TaskNotSavedException extends Exception {

    private static final long serialVersionUID = 1L;

    public TaskNotSavedException(String msg) {
        super(msg);
    }

}
