package com.anshumanprajapati.problem.filesystem;

import com.anshumanprajapati.problem.filesystem.exception.FileSystemException;

// File Class
class File extends FSEntry {
    private String content;

    public File(String name, Directory parent) {
        super(name, parent);
        this.content = ""; // Initialize with empty content
    }

    public String readContent() {
        updateLastModifiedTime();
        return content;
    }

    public void writeContent(String newContent) {
        this.content = newContent;
        updateLastModifiedTime();
    }

    public void appendContent(String contentToAppend) {
        this.content += contentToAppend;
        updateLastModifiedTime();
    }

    @Override
    public void delete() throws FileSystemException {
        if (parent != null) {
            parent.removeEntry(this.name);
            parent.updateLastModifiedTime(); // Parent's modification time also changes
        } else {
            // This case should ideally not happen for a file (unless it's the root, which is a Directory)
            throw new FileSystemException("Cannot delete a file without a parent.");
        }
    }

    @Override
    public String getType() {
        return "File";
    }

    @Override
    public String toString() {
        return "File [name='" + name + "', path='" + getPath() + "', content.length=" + content.length() + "]";
    }
}