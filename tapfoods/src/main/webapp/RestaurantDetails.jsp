<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ADD ITEM</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"> <!-- Font Awesome -->
    <style>
        /* General Styles */
        body {
            font-family: 'Roboto', sans-serif;
            background-color: #f4f6f9; /* Light gray */
            color: #333;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            padding-top: 100px; /* Added space at the top */
            flex-direction: column;
        }

        .container {
            background-color: white;
            max-width: 1200px;
            width: 100%;
            padding: 40px;
            box-shadow: 0 15px 40px rgba(0, 0, 0, 0.1);
            border-radius: 12px;
            transition: all 0.3s ease;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .container:hover {
            transform: translateY(-5px);
            box-shadow: 0 20px 50px rgba(0, 0, 0, 0.2);
        }

        .top-right-button {
            background: linear-gradient(90deg, #007BFF, #0056b3);
            color: white;
            border-radius: 8px;
            padding: 12px 24px;
            font-size: 16px;
            text-decoration: none;
            display: flex;
            align-items: center;
            gap: 5px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            transition: background 0.3s, transform 0.3s;
        }

        .top-right-button:hover {
            background: linear-gradient(90deg, #0056b3, #003f7f);
            transform: scale(1.05);
        }

        /* Bottom-right Buttons */
        .bottom-right-buttons {
            position: fixed;
            bottom: 20px;
            right: 20px;
            display: flex; /* Change to flexbox */
            gap: 10px; /* Add space between the buttons */
            z-index: 10;
        }

        .first-container {
            margin-top: 450px; /* Adds top space for the first container */
        }

        .left-section {
            width: 45%;
            display: flex;
            justify-content: center;
            align-items: center;
            padding-right: 20px;
        }

        .left-section img {
            width: 100%;
            max-width: 500px;
            border-radius: 12px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.15);
            transition: all 0.3s ease;
        }

        .left-section img:hover {
            transform: scale(1.05);
            box-shadow: 0 15px 30px rgba(0, 0, 0, 0.2);
        }

        .right-section {
            width: 50%;
            display: flex;
            flex-direction: column;
            justify-content: center;
            gap: 20px;
        }

        .food-name {
            font-size: 2.2rem;
            font-weight: 600;
            color: #2c3e50;
            margin-bottom: 10px;
            text-align: left;
        }

        .food-price {
            font-size: 1.6rem;
            font-weight: 600;
            color: #27ae60;
            margin-top: 10px;
            text-align: left;
        }

        .quantity-controls {
            display: flex;
            align-items: center;
            gap: 20px;
            margin-top: 20px;
        }

        .quantity-button {
            padding: 12px 18px;
            background-color: #3498db;
            color: white;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            font-size: 1.4rem;
            transition: background-color 0.3s;
        }

        .quantity-button:hover {
            background-color: #2980b9;
        }

        .quantity {
            font-size: 1.8rem;
            font-weight: bold;
            color: #333;
        }

        .add-item-button {
            padding: 15px 30px;
            background-color: #2ecc71;
            color: white;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            font-size: 1.4rem;
            width: 100%;
            transition: background-color 0.3s;
        }

        .add-item-button:hover {
            background-color: #27ae60;
        }

        /* Restaurant Details Container */
        .restaurant-container {
            max-width: 1200px;
            width: 100%;
            background-color: white;
            padding: 40px;
            box-shadow: 0 15px 40px rgba(0, 0, 0, 0.1);
            border-radius: 12px;
            margin-top: 20px;
        }

        .restaurant-details-title {
            font-size: 2rem;
            font-weight: 600;
            color: #34495e;
            margin-bottom: 40px;
            text-align: center;
        }

        .restaurant-details {
            display: flex;
            flex-direction: column;
            gap: 20px;
        }

        .details-row {
            display: flex;
            justify-content: space-between;
            font-size: 1.2rem;
            color: #555;
            margin-bottom: 40px;
        }

        .detail-label {
            font-weight: bold;
            color: #333;
        }

        .detail-value {
            color: #777;
        }

        .status {
            font-weight: bold;
            color: #00e676;
        }

        .status-inactive {
            color: #e74c3c;
        }

        .status-icon {
            font-size: 1.3rem;
            margin-right: 10px;
        }

        /* Responsive Design */
        @media screen and (max-width: 768px) {
            .container {
                flex-direction: column;
                padding: 30px;
            }

            .left-section, .right-section {
                width: 100%;
                padding: 0;
            }

            .left-section img {
                max-width: 100%;
            }
        }
        
        
       /* Search and Menu Container */
.search-menu-container {
    position: fixed;
    top: 40px;
    left: 50%;
    transform: translateX(-50%);
    display: flex;
    align-items: center;
    gap: 15px; /* Space between the search bar and menu button */
    z-index: 10; /* Ensure it's above other content */
}

/* Menu Button Style */
/* Menu Button Style */
.menu-button {
    background: linear-gradient(90deg, #007BFF, #0056b3); /* Gradient background */
    border: none;
    color: white;
    font-size: 16px;
    display: flex;
    align-items: center;
    gap: 8px;
    cursor: pointer;
    font-weight: 500;
    padding: 10px 20px;
    border-radius: 30px; /* Rounded corners */
    transition: background 0.3s ease, transform 0.3s ease, box-shadow 0.3s ease;
    box-shadow: 0 4px 8px rgba(0, 123, 255, 0.2); /* Subtle shadow */
}

/* Menu Button Hover Effect */
.menu-button:hover {
    background: linear-gradient(90deg, #0056b3, #003f7f); /* Darker gradient on hover */
    transform: scale(1.05); /* Slightly enlarge the button */
    box-shadow: 0 6px 12px rgba(0, 123, 255, 0.3); /* More pronounced shadow */
}

/* Menu Button Active Effect */
.menu-button:active {
    background: linear-gradient(90deg, #003f7f, #0056b3); /* Even darker gradient when clicked */
    transform: scale(1); /* Reset the scaling */
    box-shadow: 0 4px 6px rgba(0, 123, 255, 0.2); /* Normal shadow */
}


/* Menu Icon Styling */
.menu-button i {
    font-size: 20px; /* Icon size */
}

/* Search Bar Container */
.search-bar-container {
    width: 350px;
    padding: 4px 10px;
    background: rgba(255, 255, 255, 0.5);
    backdrop-filter: blur(10px);
    border-radius: 20px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
    display: flex;
    align-items: center;
}

.search-bar-container input {
    width: 100%;
    padding: 6px;
    font-size: 14px;
    border: none;
    border-radius: 20px;
    outline: none;
    background: transparent;
    color: #333;
}

.search-bar-container input::placeholder {
    color: #888;
}

.search-bar-container button {
    background: transparent;
    border: none;
    padding: 5px;
    cursor: pointer;
}

        
        
        
    </style>
</head>
<body>

    <!-- Corrected HTML for the Search Bar Container -->
    <!-- Search Bar and Menu Container -->
<div class="search-menu-container">
    <div class="search-bar-container">
        <input type="text" id="searchInput" placeholder="Search restaurant...">
        <button id="clearSearch"><i class="fa fa-times"></i></button> <!-- Correct class here -->
    </div>
   <!-- Menu Button -->
<div class="menu-container">
    <button class="menu-button" onclick="toggleDropdown()">
        <i class="fa fa-utensils"></i> Menu
    </button>
    
     <!-- Dropdown Menu (Initially Hidden) -->
<ul id="menuDropdown" class="dropdown-menu">
    <li onclick="loadFoodDetails('pizza')">Pizza</li>
    <li onclick="loadFoodDetails('burger')">Burger</li>
    <li onclick="loadFoodDetails('pasta')">Pasta</li>
    <li onclick="loadFoodDetails('sushi')">Sushi</li>
    <li onclick="loadFoodDetails('salad')">Salad</li>
    <li onclick="loadFoodDetails('tacos')">Tacos</li>
    <li onclick="loadFoodDetails('steak')">Steak</li>
    <li onclick="loadFoodDetails('ramen')">Ramen</li>
    <li onclick="loadFoodDetails('sandwich')">Sandwich</li>
    <li onclick="loadFoodDetails('ice cream')">Ice Cream</li>
    <li onclick="loadFoodDetails('soup')">Soup</li>
</ul>

</div>



<!-- CSS -->
<style>
/* Dropdown Styles */
.dropdown-menu {
    list-style: none;
    padding: 10px;
    margin: 0;
    background: white;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
    position: absolute;
    top: 50px;
    left: 50%;
    transform: translateX(-50%);
    display: none; /* Hidden by default */
    width: 200px;
    text-align: center;
}

.dropdown-menu li {
    padding: 10px;
    cursor: pointer;
    transition: background 0.3s ease;
}

.dropdown-menu li:hover {
    background: #f0f0f0;
}

/* Positioning the dropdown */
.menu-container {
    position: relative;
    display: inline-block;
}
</style>

<!-- JavaScript -->
<script>
function toggleDropdown() {
    var dropdown = document.getElementById("menuDropdown");
    dropdown.style.display = dropdown.style.display === "block" ? "none" : "block";
}

// Close dropdown when clicking outside
document.addEventListener("click", function(event) {
    var menuContainer = document.querySelector(".menu-container");
    if (!menuContainer.contains(event.target)) {
        document.getElementById("menuDropdown").style.display = "none";
    }
});
</script>


</div>
   
    <!-- Top-right Buttons -->
    <div class="top-right-buttons">
        <a href="#" class="top-right-button">
            <i class="fas fa-user"></i> <!-- Profile Icon -->
        </a>
    </div>

    <!-- Bottom-right Buttons -->
    <div class="bottom-right-buttons">
        <a href="#" class="top-right-button">
            View Cart
        </a>
        <a href="#" class="top-right-button">
            Order History
        </a>
    </div>

    <% 
        // Array of restaurant details (with price added)
        String[][] restaurantDetails = {
            {"Italian Bistro", "Italian", "4.5", "30-40 min", "123 Pizza Lane", "true", "₹150"},
            {"Sushi Haven", "Japanese", "4.2", "20-30 min", "456 Sushi St.", "false", "₹120"},
            {"Burger Palace", "American", "4.8", "15-25 min", "789 Burger Blvd", "true", "₹300"},
            {"Taco Town", "Mexican", "3.9", "25-35 min", "321 Taco Rd", "false", "₹200"},
            {"Pizza Place", "Italian", "4.7", "30-40 min", "101 Pizza Ave", "true", "₹500"},
            {"Ramen Express", "Japanese", "4.3", "10-20 min", "202 Ramen St.", "true", "₹300"},
            {"Steakhouse Grill", "Steakhouse", "4.6", "40-50 min", "303 Steakhouse Ln", "true", "₹200"},
            {"Salad Bar", "Vegetarian", "4.1", "15-25 min", "404 Salad Dr", "true", "₹200"},
            {"Seafood Shack", "Seafood", "4.4", "30-40 min", "505 Seafood Blvd", "true", "₹120"},
            {"Café Delights", "Café", "4.0", "20-30 min", "606 Cafe Pl.", "false", "₹150"},
            {"Sandwich Stop", "Sandwiches", "4.2", "10-20 min", "707 Sandwich St.", "true", "₹200"},
            {"Dessert Haven", "Desserts", "4.3", "15-25 min", "808 Dessert Ln", "true", "₹100"}
        };

        // Retrieve the restaurant and food name from the URL
        
        
        String restaurantName = request.getParameter("restaurant");
        String food = request.getParameter("food");

        if (food != null) {
            food = URLDecoder.decode(food, StandardCharsets.UTF_8.name());
        }

        // Find the details of the selected restaurant
        String[] selectedRestaurant = null;
        for (String[] restaurant : restaurantDetails) {
            if (restaurantName.equals(restaurant[0].toLowerCase().replace(" ", "-"))) {
                selectedRestaurant = restaurant;
                break;
            }
        }

        // Set the food image URL based on the food name
        String foodImageUrl = "";
        if (food != null) {
            switch (food.toLowerCase()) {
                case "pizza":
                    foodImageUrl = "https://plus.unsplash.com/premium_photo-1661762555601-47d088a26b50?q=80&w=1492&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA";
                    break;
                case "burger":
                    foodImageUrl = "https://images.unsplash.com/photo-1571091718767-18b5b1457add?q=80&w=1472&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D";
                    break;
                case "pasta":
                    foodImageUrl = "https://images.unsplash.com/photo-1555949258-eb67b1ef0ceb?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D";
                    break;
                case "sushi":
                    foodImageUrl = "https://images.pexels.com/photos/1140845/pexels-photo-1140845.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1";
                    break;
                case "salad":
                    foodImageUrl = "https://media.istockphoto.com/id/2148849755/photo/real-food-low-carb-meal-ideas-balanced-breakfast-lunch-plates.webp?a=1&b=1&s=612x612&w=0&k=20&c=RyStvsVzf5FBI-10MnPMCdrjpwcBzGwXDCeLJINnsUA=";
                    break;
                case "tacos":
                    foodImageUrl = "https://media.istockphoto.com/id/185224373/photo/spread-of-mexican-tacos-with-all-the-fixings.jpg?s=1024x1024&w=is&k=20&c=389cIoA4Fd_ZUfRDg0KOg728-w5K5YEFWxKiQpMsbe0=";
                    break;
                case "steak":
                    foodImageUrl = "https://images.unsplash.com/photo-1600891964092-4316c288032e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8c3RlYWt8ZW58MHx8MHx8fDA%3D";
                    break;
                case "ramen":
                    foodImageUrl = "https://plus.unsplash.com/premium_photo-1664475934279-2631a25c42ce?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8cmFtZW58ZW58MHx8MHx8fDA%3D";
                    break;
                case "sandwich":
                    foodImageUrl = "https://media.istockphoto.com/id/148349643/photo/plate-of-delicious-looking-french-fries.webp?a=1&b=1&s=612x612&w=0&k=20&c=DH8nOkuLz5cVpehmgIxvNRadFcmRowrOzebPkAovgpY=";
                    break;
                case "ice cream":
                    foodImageUrl = "https://media.istockphoto.com/id/157472912/photo/ice-cream-composition-on-a-bowl.jpg?s=1024x1024&w=is&k=20&c=WRb5JZpe8si-1X8Vn_fGnIsUTvozKD-V5XqnAq5U4A0=";
                    break;
                case "soup":
                    foodImageUrl = "https://images.unsplash.com/photo-1604152135912-04a022e23696?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8c291cHxlbnwwfHwwfHx8MA%3D%3D";
                    break;
                default:
                    foodImageUrl = "https://images.unsplash.com/photo-1501594907357-d00c470a2a5d?w=800";
                    break;
            }
        }
    %>

    <!-- Restaurant Details Container -->
    <div class="container first-container">
        <div class="left-section">
            <img src="<%= foodImageUrl %>" alt="<%= food %>">
        </div>

        <div class="right-section">
            <div class="food-name"><%= food %></div>
            <div class="food-price">Price: <%= selectedRestaurant[6] %></div>
            
            <!-- Add quantity controls and add to cart button here -->
            <div class="quantity-controls">
    <button class="quantity-button decrement">-</button>
    <div class="quantity">1</div>
    <button class="quantity-button increment">+</button>
</div>

            
            <script>
    // JavaScript to handle quantity increase and decrease
    document.addEventListener('DOMContentLoaded', function() {
        const increaseButton = document.querySelector('.quantity-button.increment');
        const decreaseButton = document.querySelector('.quantity-button.decrement');
        const quantityDisplay = document.querySelector('.quantity');

        let quantity = 1;

        // Increase quantity
        increaseButton.addEventListener('click', function() {
            quantity++;
            quantityDisplay.textContent = quantity;
        });

        // Decrease quantity
        decreaseButton.addEventListener('click', function() {
            if (quantity > 1) {
                quantity--;
                quantityDisplay.textContent = quantity;
            }
        });
    });
</script>



<script>
function loadFoodDetails(food) {
    // Update food name and image dynamically
    const foodName = document.querySelector('.food-name');
    const foodImage = document.querySelector('.left-section img');
    const foodPrice = document.querySelector('.food-price');
    
    let foodImageUrl = "";
    let price = "";

    // Set the image URL and price based on selected food
    switch (food.toLowerCase()) {
        case "pizza":
            foodImageUrl = "https://plus.unsplash.com/premium_photo-1661762555601-47d088a26b50?q=80&w=1492&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA";
            price = "₹150";
            break;
        case "burger":
            foodImageUrl = "https://images.unsplash.com/photo-1571091718767-18b5b1457add?q=80&w=1472&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D";
            price = "₹200";
            break;
        case "pasta":
            foodImageUrl = "https://images.unsplash.com/photo-1555949258-eb67b1ef0ceb?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D";
            price = "₹250";
            break;
        case "sushi":
            foodImageUrl = "https://images.pexels.com/photos/1140845/pexels-photo-1140845.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1";
            price = "₹300";
            break;
        case "salad":
            foodImageUrl = "https://media.istockphoto.com/id/2148849755/photo/real-food-low-carb-meal-ideas-balanced-breakfast-lunch-plates.webp?a=1&b=1&s=612x612&w=0&k=20&c=RyStvsVzf5FBI-10MnPMCdrjpwcBzGwXDCeLJINnsUA=";
            price = "₹120";
            break;
        case "tacos":
            foodImageUrl = "https://media.istockphoto.com/id/185224373/photo/spread-of-mexican-tacos-with-all-the-fixings.jpg?s=1024x1024&w=is&k=20&c=389cIoA4Fd_ZUfRDg0KOg728-w5K5YEFWxKiQpMsbe0=";
            price = "₹180";
            break;
        case "steak":
            foodImageUrl = "https://images.unsplash.com/photo-1600891964092-4316c288032e?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8c3RlYWt8ZW58MHx8MHx8fDA%3D";
            price = "₹600";
            break;
        case "ramen":
            foodImageUrl = "https://plus.unsplash.com/premium_photo-1664475934279-2631a25c42ce?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MXx8cmFtZW58ZW58MHx8MHx8fDA%3D";
            price = "₹350";
            break;
        case "sandwich":
            foodImageUrl = "https://media.istockphoto.com/id/148349643/photo/plate-of-delicious-looking-french-fries.webp?a=1&b=1&s=612x612&w=0&k=20&c=DH8nOkuLz5cVpehmgIxvNRadFcmRowrOzebPkAovgpY=";
            price = "₹100";
            break;
        case "ice cream":
            foodImageUrl = "https://media.istockphoto.com/id/157472912/photo/ice-cream-composition-on-a-bowl.jpg?s=1024x1024&w=is&k=20&c=WRb5JZpe8si-1X8Vn_fGnIsUTvozKD-V5XqnAq5U4A0=";
            price = "₹50";
            break;
        case "soup":
            foodImageUrl = "https://images.unsplash.com/photo-1604152135912-04a022e23696?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8M3x8c291cHxlbnwwfHwwfHx8MA%3D%3D";
            price = "₹80";
            break;
        default:
            foodImageUrl = "https://images.unsplash.com/photo-1501594907357-d00c470a2a5d?w=800";
            price = "₹100";
            break;
    }

    // Update the content
    foodName.textContent = food.charAt(0).toUpperCase() + food.slice(1); // Capitalize the first letter of the food name
    foodImage.src = foodImageUrl;
    foodPrice.textContent = "Price: " + price;
}
</script>
            
            
            <button class="add-item-button">Add to Cart</button>
        </div>
    </div>

    <div class="restaurant-container">
        <div class="restaurant-details-title">Restaurant Details</div>
        <div class="restaurant-details">
            <div class="details-row">
                <div class="detail-label">Restaurant Name:</div>
                <div class="detail-value"><%= selectedRestaurant[0] %></div>
            </div>
            <div class="details-row">
                <div class="detail-label">Cuisine Type:</div>
                <div class="detail-value"><%= selectedRestaurant[1] %></div>
            </div>
            <div class="details-row">
                <div class="detail-label">Rating:</div>
                <div class="detail-value"><%= selectedRestaurant[2] %></div>
            </div>
            <div class="details-row">
                <div class="detail-label">Delivery Time:</div>
                <div class="detail-value"><%= selectedRestaurant[3] %></div>
            </div>
            <div class="details-row">
                <div class="detail-label">Location:</div>
                <div class="detail-value"><%= selectedRestaurant[4] %></div>
            </div>
            <div class="details-row">
                <div class="detail-label">Status:</div>
                <div class="detail-value">
                    <span class="<%= selectedRestaurant[5].equals("true") ? "status" : "status-inactive" %>">
                        <%= selectedRestaurant[5].equals("true") ? "Open" : "Closed" %>
                    </span>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
