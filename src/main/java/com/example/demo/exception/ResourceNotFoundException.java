package com.example.demo.exception;

/**
 * Custom exception thrown when a requested resource (entity) is not found in the database.
 * Used across all services when findById or similar operations return empty results.
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    // Optional: constructor without message (though message is recommended for clarity)
    public ResourceNotFoundException() {
        super("Resource not found");
    }
}