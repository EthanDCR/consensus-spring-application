package com.example.controller;

import com.example.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;

@RestController
@RequestMapping("/api")  // Base URL for the controller
public class FeedbackController {

    @Autowired
    private JavaMailSender mailSender;  // Automatically inject the JavaMailSender

    @PostMapping("/submit-feedback")  // Handle POST requests to /api/submit-feedback
    public String submitFeedback(@RequestBody Feedback feedback) {
        sendEmail(feedback.getMessage());  // Send the feedback via email
        saveFeedbackToFile(feedback.getMessage());  // Save the feedback to a file
        return "Feedback submitted successfully!";  // Response message
    }

    // Method to send email with feedback message
    private void sendEmail(String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("recipient-email@gmail.com");  // Change this to your email
        mailMessage.setSubject("New Feedback Submission");
        mailMessage.setText(message);
        mailSender.send(mailMessage);  // Send the email
    }

    // Method to save feedback to a text file
    private void saveFeedbackToFile(String message) {
        try (FileWriter fileWriter = new FileWriter("feedback.txt", true)) {
            fileWriter.write(message + "\n");  // Write message to the file
        } catch (IOException e) {
            e.printStackTrace();  // Print stack trace if an error occurs
        }
    }
}
