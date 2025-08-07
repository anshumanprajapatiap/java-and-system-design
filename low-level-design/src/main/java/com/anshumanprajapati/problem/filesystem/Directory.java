package com.anshumanprajapati.problem.filesystem;

import java.util.*;
import com.anshumanprajapati.problem.filesystem.exception.*;
// Directory Class
public class Directory extends FSEntry {
    // Using LinkedHashMap to maintain insertion order for predictable listing
    Map<String, FSEntry> children;

    // Constructor for regular directories
    public Directory(String name, Directory parent) {
        super(name, parent);
        this.children = new LinkedHashMap<>();
    }

    // Special constructor for the root directory (no parent)
    public Directory(String name) {
        super(name, null); // Parent is null for root
        this.children = new LinkedHashMap<>();
    }

    // Creates a new file within this directory
    public File createFile(String fileName) throws FileSystemException {
        if (children.containsKey(fileName)) {
            throw new EntryAlreadyExistsException(fileName, this.getPath());
        }
        File newFile = new File(fileName, this);
        children.put(fileName, newFile);
        updateLastModifiedTime();
        return newFile;
    }

    // Creates a new directory within this directory
    public Directory createDirectory(String dirName) throws FileSystemException {
        if (children.containsKey(dirName)) {
            throw new EntryAlreadyExistsException(dirName, this.getPath());
        }
        Directory newDir = new Directory(dirName, this);
        children.put(dirName, newDir);
        updateLastModifiedTime();
        return newDir;
    }

    // Gets a child entry by name
    public FSEntry getEntry(String name) {
        return children.get(name);
    }

    // Lists the names of all direct children
    public Set<String> listContents() {
        updateLastModifiedTime(); // Listing implies access
        return children.keySet();
    }

    // Removes a child entry by name
    public void removeEntry(String name) throws FileSystemException {
        if (!children.containsKey(name)) {
            throw new FileNotFoundException(this.getPath() + "/" + name);
        }
        children.remove(name);
        updateLastModifiedTime();
    }

    // Deletes the directory.
    // By default, a directory must be empty to be deleted.
    // A force parameter can be added to delete recursively, but for simplicity,
    // we'll enforce empty deletion.
    @Override
    public void delete() throws FileSystemException {
        if (children.size() > 0) {
            throw new NotEmptyDirectoryException(this.getPath());
        }
        if (parent != null) { // If not root
            parent.removeEntry(this.name);
            parent.updateLastModifiedTime();
        } else {
            throw new FileSystemException("Cannot delete the root directory.");
        }
    }

    @Override
    public String getType() {
        return "Directory";
    }

    @Override
    public String toString() {
        return "Directory [name='" + name + "', path='" + getPath() + "', children=" + children.size() + "]";
    }
}