package com.anshumanprajapati.problem.filesystem.exception;

public class NotEmptyDirectoryException extends FileSystemException {
    public NotEmptyDirectoryException(String path) {
        super("Directory is not empty: " + path);
    }
}