
package com.example.controller;

import com.example.model.Feedback;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;

@RestController
@RequestMapping("/api") // Base URL for the controller
public class FeedbackController {

  @PostMapping("/submit-feedback") // Handle POST requests to /api/submit-feedback
  public String submitFeedback(@RequestParam("feedback") String feedbackMessage) {
    saveFeedbackToFile(feedbackMessage); // Save the feedback to a file
    return "Feedback submitted successfully!"; // Response message
  }

  // Method to save feedback to a text file
  private void saveFeedbackToFile(String message) {
    try (FileWriter fileWriter = new FileWriter("feedback.txt", true)) {
      fileWriter.write(message + "\n"); // Write message to the file
    } catch (IOException e) {
      e.printStackTrace(); // Print stack trace if an error occurs
    }
  }
}
