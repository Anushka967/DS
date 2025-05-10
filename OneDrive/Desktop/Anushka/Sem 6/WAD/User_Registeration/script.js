document.getElementById("registrationForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Prevent form from refreshing the page

    // Get user inputs
    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;

    // Create user object
    let user = { name, email, password };

    // Get existing users from local storage (or create an empty array)
    let users = JSON.parse(localStorage.getItem("users")) || [];

    // Add new user to the array
    users.push(user);

    // Store updated array in local storage
    localStorage.setItem("users", JSON.stringify(users));

    // Send data using AJAX (Simulating a POST request)
    let xhr = new XMLHttpRequest();
    xhr.open("POST", "users.html", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(JSON.stringify(user));

    // Redirect to users page
    window.location.href = "users.html";
});
