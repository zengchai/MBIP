function validateForm() {
  var electricityUsage = document.getElementById("electricityusage").value;
  var days = document.getElementById("days").value;
  var proportionFactor = document.getElementById("proportion_factor").value;
  var amount = document.getElementById("amount").value;
  var currentCharge = document.getElementById("current_charge").value;

  if (!isValidNonNegativeNumber(electricityUsage)) {
    alert("Please enter a valid number for Usage (m³).");
    return false; // Prevent form submission
  }

  if (!isValidNonNegativeNumber(days)) {
    alert("Please enter a valid number for Days.");
    return false; // Prevent form submission
  }

  if (!isValidNonNegativeNumber(proportionFactor)) {
    alert("Please enter a valid number for Proportion Factor.");
    return false; // Prevent form submission
  }

  if (!isValidNonNegativeNumber(amount)) {
    alert("Please enter a valid number for Amount.");
    return false; // Prevent form submission
  }

  if (!isValidNonNegativeNumber(currentCharge)) {
    alert("Please enter a valid number for Current Charge.");
    return false; // Prevent form submission
  }

  return true; // Allow form submission
}

function isValidNonNegativeNumber(value) {
  return !isNaN(value) && parseFloat(value) >= 0;
}

function validateUpload() {
  var fileInput = document.getElementById("file");
  var allowedExtensions = /(\.pdf)$/i;

  if (!allowedExtensions.exec(fileInput.value)) {
    alert("Please upload a valid PDF file.");
    return false; // Prevent form submission
  }

  var fileSize = fileInput.files[0].size;
  var maxSize = 2 * 1024 * 1024; // 2MB

  if (fileSize > maxSize) {
    alert("File size should not exceed 2 MB.");
    return false; // Prevent form submission
  }

  return true; // Allow form submission
}
