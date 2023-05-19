package dev.abhisek.studentbackend.exception;

import java.util.NoSuchElementException;

/**
 * Custom Exception to handle if Student is not present in the database
 */
public class StudentNotFoundException extends NoSuchElementException {

    public StudentNotFoundException() {
        super("Requested student not found in database...");
    }
}
