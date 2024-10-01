// JavaScript for handling modal open/close
const createTripBtn = document.getElementById('createTripBtn');
const tripModal = document.getElementById('tripModal');
const closeModal = document.getElementById('closeModal');

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
  if (event.target == tripModal) {
    tripModal.style.display = 'none'; // Hide modal when clicking outside
  }
});
