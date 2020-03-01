package com.baeldung.ls.exception;

public class TaskNotAddedException extends Exception {

    private static final long serialVersionUID = 1L;

    public TaskNotAddedException(String msg) {
        super(msg);
    }

}
