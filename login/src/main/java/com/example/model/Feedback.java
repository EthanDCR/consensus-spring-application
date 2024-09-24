package com.example.model;

public class Feedback {
    // Field to store feedback message
    private String message;

    // Default constructor
    public Feedback() {
    }

    // Constructor that accepts a message
    public Feedback(String message) {
        this.message = message;
    }

    // Getter for message
    public String getMessage() {
        return message;
    }

    // Setter for message
    public void setMessage(String message) {
        this.message = message;
    }
}
