package com.anshumanprajapati.problem.filesystem;


import com.anshumanprajapati.problem.filesystem.exception.*;

import java.sql.Date;
import java.util.Set;

class FileSystem {
    private Directory root;

    public FileSystem() {
        this.root = new Directory(""); // Root directory has an empty name, its path will be "/"
    }

    // Helper method to resolve an FSEntry from a given path
    // Returns a PathResult object containing the resolved entry and its parent directory
    private PathResult resolvePath(String path) throws FileSystemException {
        if (path == null || path.trim().isEmpty()) {
            throw new InvalidPathException("Path cannot be null or empty.");
        }
        if (!path.startsWith("/")) {
            throw new InvalidPathException("Path must start with '/': " + path);
        }

        Directory currentDir = root;
        Directory parentDir = null;
        FSEntry targetEntry = root;

        String[] components = path.substring(1).split("/"); // Skip leading slash, split by slash
        if (path.equals("/")) {
            // Root path handled specially
            return new PathResult(root, null);
        }

        // Handle cases like "/a/b/" or "/a/b"
        int lastComponentIndex = components.length - 1;
        if (components.length == 1 && components[0].isEmpty()) { // Path was "/"
            lastComponentIndex = -1;
        }

        for (int i = 0; i < components.length; i++) {
            String component = components[i];
            if (component.isEmpty()) { // Handle "//" or trailing "/"
                if (i == components.length - 1) { // It's a trailing slash, valid for directories
                    targetEntry = currentDir;
                    break;
                }
                throw new InvalidPathException("Path contains empty component: " + path);
            }

            FSEntry nextEntry = currentDir.getEntry(component);

            if (nextEntry == null) {
                // If it's the last component, and not found, it might be a file/dir to be created
                if (i == lastComponentIndex) {
                    return new PathResult(null, currentDir, component); // Signal entry not found, but parent is
                } else {
                    // Intermediate path component not found
                    throw new FileNotFoundException(path);
                }
            }

            if (i == lastComponentIndex) {
                targetEntry = nextEntry;
                parentDir = currentDir;
            } else {
                if (!(nextEntry instanceof Directory)) {
                    throw new InvalidPathException("Path component is not a directory: " + nextEntry.getPath());
                }
                parentDir = currentDir;
                currentDir = (Directory) nextEntry;
            }
        }
        return new PathResult(targetEntry, parentDir);
    }

    // Helper class to return multiple values from resolvePath
    private static class PathResult {
        FSEntry resolvedEntry;
        Directory parentDirectory;
        String fileNameToCreate; // If resolvedEntry is null, this is the name of the new entry

        PathResult(FSEntry entry, Directory parent) {
            this.resolvedEntry = entry;
            this.parentDirectory = parent;
            this.fileNameToCreate = null;
        }

        PathResult(FSEntry entry, Directory parent, String fileNameToCreate) {
            this.resolvedEntry = entry;
            this.parentDirectory = parent;
            this.fileNameToCreate = fileNameToCreate;
        }
    }


    // Public API for File System Operations

    // Creates a new file
    public void createFile(String path) throws FileSystemException {
        PathResult pr = resolvePath(path);
        if (pr.resolvedEntry != null) {
            throw new EntryAlreadyExistsException(pr.resolvedEntry.getName(), pr.resolvedEntry.getParent().getPath());
        }
        if (pr.parentDirectory == null) { // This means path was "/", trying to create file in root, but root is Dir.
            throw new InvalidPathException("Cannot create a file at the root path: " + path);
        }
        pr.parentDirectory.createFile(pr.fileNameToCreate);
        System.out.println("Created file: " + path);
    }

    // Creates a new directory
    public void createDirectory(String path) throws FileSystemException {
        PathResult pr = resolvePath(path);
        if (pr.resolvedEntry != null) {
            throw new EntryAlreadyExistsException(pr.resolvedEntry.getName(), pr.resolvedEntry.getParent().getPath());
        }
        if (pr.parentDirectory == null) { // Trying to create a directory at root, which means root exists
            throw new EntryAlreadyExistsException("", "/"); // Root already exists
        }
        pr.parentDirectory.createDirectory(pr.fileNameToCreate);
        System.out.println("Created directory: " + path);
    }

    // Reads content of a file
    public String readFile(String path) throws FileSystemException {
        PathResult pr = resolvePath(path);
        if (pr.resolvedEntry == null) {
            throw new FileNotFoundException(path);
        }
        if (!(pr.resolvedEntry instanceof File)) {
            throw new FileSystemException("Path does not point to a file: " + path);
        }
        File file = (File) pr.resolvedEntry;
        return file.readContent();
    }

    // Updates content of a file
    public void updateFile(String path, String newContent) throws FileSystemException {
        PathResult pr = resolvePath(path);
        if (pr.resolvedEntry == null) {
            throw new FileNotFoundException(path);
        }
        if (!(pr.resolvedEntry instanceof File)) {
            throw new FileSystemException("Path does not point to a file: " + path);
        }
        File file = (File) pr.resolvedEntry;
        file.writeContent(newContent);
        System.out.println("Updated file: " + path);
    }

    // Appends content to a file
    public void appendFile(String path, String contentToAppend) throws FileSystemException {
        PathResult pr = resolvePath(path);
        if (pr.resolvedEntry == null) {
            throw new FileNotFoundException(path);
        }
        if (!(pr.resolvedEntry instanceof File)) {
            throw new FileSystemException("Path does not point to a file: " + path);
        }
        File file = (File) pr.resolvedEntry;
        file.appendContent(contentToAppend);
        System.out.println("Appended to file: " + path);
    }

    // Deletes a file or an empty directory
    public void deleteEntry(String path) throws FileSystemException {
        PathResult pr = resolvePath(path);
        if (pr.resolvedEntry == null) {
            throw new FileNotFoundException(path);
        }
        if (pr.resolvedEntry == root) {
            throw new FileSystemException("Cannot delete the root directory.");
        }
        pr.resolvedEntry.delete();
        System.out.println("Deleted: " + path);
    }

    // Renames a file or directory
    public void renameEntry(String path, String newName) throws FileSystemException {
        PathResult pr = resolvePath(path);
        if (pr.resolvedEntry == null) {
            throw new FileNotFoundException(path);
        }
        pr.resolvedEntry.rename(newName);
        System.out.println("Renamed " + path + " to " + pr.resolvedEntry.getPath());
    }

    // Lists contents of a directory
    public Set<String> listDirectory(String path) throws FileSystemException {
        PathResult pr = resolvePath(path);
        if (pr.resolvedEntry == null) {
            throw new FileNotFoundException(path);
        }
        if (!(pr.resolvedEntry instanceof Directory)) {
            throw new FileSystemException("Path does not point to a directory: " + path);
        }
        Directory dir = (Directory) pr.resolvedEntry;
        return dir.listContents();
    }

    // Gets information about an entry (name, type, times)
    public String getEntryInfo(String path) throws FileSystemException {
        PathResult pr = resolvePath(path);
        if (pr.resolvedEntry == null) {
            throw new FileNotFoundException(path);
        }
        FSEntry entry = pr.resolvedEntry;
        Date creationDate = new Date(entry.getCreationTime());
        Date modifiedDate = new Date(entry.getLastModifiedTime());
        return String.format("Name: %s\nType: %s\nPath: %s\nCreated: %s\nLast Modified: %s",
                entry.getName(), entry.getType(), entry.getPath(), creationDate, modifiedDate);
    }


    // Main method for demonstration
    public static void main(String[] args) {
        FileSystem fs = new FileSystem();

        // --- Create Operations ---
        try {
            System.out.println("\n--- Creating Entries ---");
            fs.createDirectory("/documents");
            fs.createDirectory("/documents/personal");
            fs.createFile("/documents/personal/my_letter.txt");
            fs.createDirectory("/photos");
            fs.createFile("/photos/vacation.jpg");
            fs.createFile("/README.md");

            System.out.println("\nContents of /:");
            fs.listDirectory("/").forEach(System.out::println);
            System.out.println("\nContents of /documents:");
            fs.listDirectory("/documents").forEach(System.out::println);

        } catch (FileSystemException e) {
            System.err.println("Error during creation: " + e.getMessage());
        }

        // --- File Content Operations ---
        try {
            System.out.println("\n--- File Content Operations ---");
            fs.updateFile("/documents/personal/my_letter.txt", "Dear Reader,\nThis is my first draft.");
            System.out.println("Content of /documents/personal/my_letter.txt: \n" + fs.readFile("/documents/personal/my_letter.txt"));

            fs.appendFile("/documents/personal/my_letter.txt", "\nSincerely,\nJohn Doe.");
            System.out.println("Content after append: \n" + fs.readFile("/documents/personal/my_letter.txt"));

            fs.updateFile("/README.md", "# My Awesome Project\nThis is a placeholder readme.");
            System.out.println("Content of /README.md: \n" + fs.readFile("/README.md"));
        } catch (FileSystemException e) {
            System.err.println("Error during file content operation: " + e.getMessage());
        }

        // --- Rename Operations ---
        try {
            System.out.println("\n--- Renaming Entries ---");
            fs.renameEntry("/documents/personal/my_letter.txt", "final_letter.txt");
            System.out.println("Contents of /documents/personal after rename:");
            fs.listDirectory("/documents/personal").forEach(System.out::println);

            fs.renameEntry("/documents/personal", "private_docs");
            System.out.println("Contents of /documents after rename:");
            fs.listDirectory("/documents").forEach(System.out::println);

            // Attempt to rename to an existing name
            // fs.renameEntry("/photos", "documents"); // This should fail
        } catch (FileSystemException e) {
            System.err.println("Error during rename: " + e.getMessage());
        }

        // --- Info Operations ---
        try {
            System.out.println("\n--- Entry Info ---");
            System.out.println(fs.getEntryInfo("/README.md"));
            System.out.println("\n" + fs.getEntryInfo("/documents/private_docs"));
        } catch (FileSystemException e) {
            System.err.println("Error getting info: " + e.getMessage());
        }


        // --- Delete Operations ---
        try {
            System.out.println("\n--- Deleting Entries ---");
            fs.deleteEntry("/photos/vacation.jpg");
            System.out.println("Contents of /photos after delete:");
            fs.listDirectory("/photos").forEach(System.out::println);

            // Attempt to delete non-empty directory
            // fs.deleteEntry("/documents"); // This should fail

            fs.createDirectory("/temp_dir");
            fs.createFile("/temp_dir/temp_file.txt");
            fs.deleteEntry("/temp_dir/temp_file.txt"); // Delete file first
            fs.deleteEntry("/temp_dir"); // Then delete empty directory
            System.out.println("Contents of / after temp_dir deletion:");
            fs.listDirectory("/").forEach(System.out::println);

        } catch (FileSystemException e) {
            System.err.println("Error during deletion: " + e.getMessage());
        }

        // --- Error Handling Demonstration ---
        System.out.println("\n--- Error Handling Demo ---");
        try {
            fs.createFile("/documents/private_docs/final_letter.txt"); // Already exists
        } catch (FileSystemException e) {
            System.err.println("Expected error: " + e.getMessage());
        }

        try {
            fs.readFile("/non_existent_file.txt"); // Not found
        } catch (FileSystemException e) {
            System.err.println("Expected error: " + e.getMessage());
        }

        try {
            fs.createFile("/documents/private_docs/non_existent_path/new_file.txt"); // Intermediate path missing
        } catch (FileSystemException e) {
            System.err.println("Expected error: " + e.getMessage());
        }

        try {
            fs.deleteEntry("/documents"); // Not empty
        } catch (FileSystemException e) {
            System.err.println("Expected error: " + e.getMessage());
        }

        try {
            fs.renameEntry("/documents/private_docs", "documents"); // Rename to existing
        } catch (FileSystemException e) {
            System.err.println("Expected error: " + e.getMessage());
        }

        try {
            fs.createDirectory("/photos/subphotos"); // Trailing slash test
            fs.createDirectory("/documents//extra"); // Double slash test
        } catch (FileSystemException e) {
            System.err.println("Error during path test: " + e.getMessage());
        }
    }
}