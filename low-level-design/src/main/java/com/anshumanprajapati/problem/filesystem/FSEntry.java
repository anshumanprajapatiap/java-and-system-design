package com.anshumanprajapati.problem.filesystem;

import com.anshumanprajapati.problem.filesystem.exception.*;
import com.anshumanprajapati.problem.filesystem.exception.FileSystemException;
import com.anshumanprajapati.problem.filesystem.exception.InvalidPathException;

import java.nio.file.*;

// Abstract Base Class for File System Entries
abstract class FSEntry {
    protected String name;
    protected Directory parent; // null for root directory
    protected long creationTime;
    protected long lastModifiedTime;

    public FSEntry(String name, Directory parent) {
        if (name == null || name.trim().isEmpty() || name.contains("/")) {
            throw new IllegalArgumentException("Entry name cannot be null, empty, or contain '/'");
        }
        this.name = name;
        this.parent = parent;
        this.creationTime = System.currentTimeMillis();
        this.lastModifiedTime = this.creationTime;
    }

    public String getName() {
        return name;
    }

    // Package-private setter for internal use during rename
    void setName(String name) {
        this.name = name;
        updateLastModifiedTime();
    }

    public Directory getParent() {
        return parent;
    }

    // Package-private setter for internal use (e.g., when moving, though not implemented here)
    void setParent(Directory parent) {
        this.parent = parent;
        updateLastModifiedTime();
    }

    public long getCreationTime() {
        return creationTime;
    }

    public long getLastModifiedTime() {
        return lastModifiedTime;
    }

    protected void updateLastModifiedTime() {
        this.lastModifiedTime = System.currentTimeMillis();
        if (parent != null) {
            parent.updateLastModifiedTime(); // Propagate modification time up to parent
        }
    }

    // Generates the full path of the entry
    public String getPath() {
        if (parent == null) { // This is the root
            return "/";
        }
        String parentPath = parent.getPath();
        return parentPath.equals("/") ? "/" + name : parentPath + "/" + name;
    }

    // Renames the entry. This operation handles updating the parent's children map.
    public void rename(String newName) throws FileSystemException {
        if (newName == null || newName.trim().isEmpty() || newName.contains("/")) {
            throw new InvalidPathException("New name cannot be null, empty, or contain '/': " + newName);
        }
        if (this instanceof Directory && "/".equals(this.getPath())) {
            throw new FileSystemException("Cannot rename the root directory.");
        }

        if (parent != null) {
            if (parent.children.containsKey(newName)) {
                throw new EntryAlreadyExistsException(newName, parent.getPath());
            }
            parent.children.remove(this.name); // Remove old entry
            this.name = newName; // Update name
            parent.children.put(newName, this); // Add with new name
            updateLastModifiedTime();
            parent.updateLastModifiedTime(); // Ensure parent also gets updated
        } else {
            // For root, no parent to update map
            throw new FileSystemException("Cannot rename the root directory.");
        }
    }

    // Abstract method for deleting the entry
    public abstract void delete() throws FileSystemException;

    public abstract String getType();
}