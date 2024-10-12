#!/bin/bash

if [ -f "./mvnw" ]; then
  echo "Running Spring Boot application..."
  ./mvnw spring-boot:run
else
  echo "Error: mvnw not found in the current directory."
  exit 1
fi
