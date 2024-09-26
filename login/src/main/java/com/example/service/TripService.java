package com.example.service;

import com.example.model.Trip;
import com.example.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {

  @Autowired
  private TripRepository tripRepository;

  // Method to create a new trip
  public Trip createTrip(Trip trip) {
    return tripRepository.save(trip);
  }

  // Method to get all trips
  public List<Trip> getAllTrips() {
    return tripRepository.findAll();
  }
}
