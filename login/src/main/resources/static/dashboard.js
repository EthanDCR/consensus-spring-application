
// JavaScript for handling modal open/close and form submission
document.addEventListener('DOMContentLoaded', () => {
  const createTripBtn = document.getElementById('createTripBtn');
  const tripModal = document.getElementById('tripModal');
  const closeModal = document.getElementById('closeModal');
  const tripForm = document.getElementById('tripForm');

  // Open the modal when the "Create New Trip" button is clicked
  createTripBtn.addEventListener('click', () => {
    tripModal.style.display = 'flex'; // Show the modal
  });

  // Close the modal when the "x" button is clicked
  closeModal.addEventListener('click', () => {
    tripModal.style.display = 'none'; // Hide the modal
  });

  // Close the modal if the user clicks outside the modal content
  window.addEventListener('click', (event) => {
    if (event.target === tripModal) {
      tripModal.style.display = 'none'; // Hide modal when clicking outside
    }
  });

  // Handle form submission
  tripForm.addEventListener('submit', (event) => {
    event.preventDefault(); // Prevent traditional form submission

    // Gather form data
    const tripName = document.getElementById('tripName').value;
    const tripDate = document.getElementById('tripDate').value;
    const timeSlot = document.getElementById('timeSlot').value;

    // Log the data (replace this with your backend call or API request)
    console.log(`Trip Name: ${tripName}, Date: ${tripDate}, Time Slot: ${timeSlot}`);

    // Add the new trip to the dashboard (for now just appending to a list)
    addTripToDashboard(tripName, tripDate, timeSlot);

    // Reset the form and close the modal
    tripForm.reset();
    tripModal.style.display = 'none'; // Hide the modal after submission
  });

  // Function to dynamically add trip details to the dashboard
  function addTripToDashboard(tripName, tripDate, timeSlot) {
    const tripList = document.getElementById('tripList');

    // Create a new list item for the trip
    const newTrip = document.createElement('li');
    newTrip.textContent = `${tripName} - ${tripDate} - ${timeSlot}`;

    // Create a button to link to the individual trip page
    const tripButton = document.createElement('button');
    tripButton.textContent = 'View Details';
    tripButton.classList.add('trip-button');
    
    // You could generate a unique trip ID to use in the URL
    const tripId = Date.now(); // Example of generating a unique ID based on timestamp

    // Set up the link to the individual trip page
    tripButton.addEventListener('click', () => {
      window.location.href = `trip-details.html?tripId=${tripId}`;
    });

    // Append the button to the list item
    newTrip.appendChild(tripButton);

    // Append the new trip to the list
    tripList.appendChild(newTrip);
  }
});
