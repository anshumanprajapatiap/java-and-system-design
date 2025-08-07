package com.anshumanprajapati.problem.filesystem.exception;

public class InvalidPathException extends FileSystemException {
    public InvalidPathException(String path) {
        super("Invalid path: " + path);
    }
}
