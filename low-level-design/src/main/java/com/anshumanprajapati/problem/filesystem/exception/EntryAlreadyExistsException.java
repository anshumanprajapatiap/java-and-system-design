package com.anshumanprajapati.problem.filesystem.exception;

public class EntryAlreadyExistsException extends FileSystemException {
    public EntryAlreadyExistsException(String name, String parentPath) {
        super("Entry '" + name + "' already exists in '" + parentPath + "'");
    }
}
