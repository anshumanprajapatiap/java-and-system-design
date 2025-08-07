package com.anshumanprajapati.problem.filesystem.exception;


public class FileNotFoundException extends FileSystemException {
    public FileNotFoundException(String path) {
        super("File or directory not found: " + path);
    }
}