package com.example.demo.exception;

/**
 * Custom exception thrown when business rules or input validation fails.
 * Examples:
 * - startDate after endDate
 * - duplicate email during registration
 * - invalid date ranges
 * - any other domain-specific validation failure
 */
public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }

    // Optional: constructor without message
    public ValidationException() {
        super("Validation failed");
    }
}