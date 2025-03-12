<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tapfoods.model.User" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <style>
        /* Global Styling */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            display: flex;
            flex-direction: column;
            height: 100vh;
            position: relative;
            background-color: #f8f9fa;
            justify-content: flex-start;
            align-items: center;
            overflow-x: hidden;
        }

        /* Full-Screen Welcome Modal */
        .welcome-modal {
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.7);
            color: white;
            display: flex;
            justify-content: center;
            align-items: center;
            z-index: 1000;
            opacity: 1;
            transition: opacity 1s ease;
        }

        .welcome-modal.hidden {
            opacity: 0;
            visibility: hidden;
        }

        .welcome-modal .message {
            font-size: 40px;
            font-weight: bold;
            text-align: center;
        }

        /* Top Container with Blurred Background */
        .top-container {
            position: relative;
            width: 100%;
            height: 200px;
            background-image: url('https://cdn.dribbble.com/userupload/11445462/file/original-f13200e3c9bc09236e239250d690556e.jpg?resize=1024x1434');
            background-size: cover;
            background-position: center;
            filter: blur(8px);
            z-index: -1;
        }

        .top-container-content {
            position: absolute;
            top: 20px;
            left: 50%;
            transform: translateX(-50%);
            color: white;
            text-align: center;
            font-size: 24px;
            font-weight: bold;
            z-index: 1;
        }

        /* Search Bar Container */
        .search-bar-container {
            position: fixed;
            top: 40px;
            left: 50%;
            transform: translateX(-50%);
            width: 350px;
            padding: 4px 10px;
            background: rgba(255, 255, 255, 0.5);
            backdrop-filter: blur(10px);
            border-radius: 20px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
            z-index: 5;
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

        /* Profile Icon at Top Right */
        .top-right {
            position: fixed;
            top: 40px;
            right: 10px;
            background: linear-gradient(90deg, #007BFF, #0056b3);
            color: white;
            border-radius: 50%;
            width: 40px;
            height: 40px;
            text-align: center;
            line-height: 40px;
            font-size: 20px;
            text-decoration: none;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            transition: background 0.3s;
            z-index: 10;
        }

        .top-right:hover {
            background: linear-gradient(90deg, #0056b3, #003f7f);
        }

        .top-right i {
            color: white;
        }

        /* Main Content Area with Boxes */
        .container {
            width: 90%;
            margin: auto;
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 30px;
            margin-top: 160px;
            transition: all 0.3s ease;
        }

        /* Colorful Content Box Styles */
        .box {
            width: 100%;
            height: 250px; /* Fixed height for uniform boxes */
            padding: 20px;
            text-align: center;
            font-size: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
            flex-direction: column;
            border-radius: 12px;
            color: white;
            background: linear-gradient(145deg, #FF6B6B, #FFD93D);
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.2);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            margin-bottom: 20px;
        }

        .box:nth-child(odd) {
            background: linear-gradient(145deg, #4ECDC4, #556270);
        }

        .box:hover {
            transform: translateY(-10px);
            box-shadow: 0 6px 25px rgba(0, 0, 0, 0.3);
        }

        .box h3 {
            font-size: 22px;
            color: white;
            margin-bottom: 10px;
            font-weight: 600;
        }

        .box .box-image {
            width: 80%; /* Responsive scaling */
            height: 120px; /* Consistent image height */
            border-radius: 8px;
            margin-bottom: 10px;
            object-fit: cover; /* Ensures images fill area */
        }

        .bottom-right {
            position: fixed;
            bottom: 20px;
            right: 20px;
            display: flex;
            gap: 10px;
            z-index: 10;
        }

        .bottom-right a {
            padding: 12px 24px;
            background: linear-gradient(90deg, #007BFF, #0056b3);
            color: white;
            border-radius: 8px;
            text-decoration: none;
            font-size: 16px;
            text-align: center;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            transition: background 0.3s, transform 0.3s;
        }

        .bottom-right a:hover {
            background: linear-gradient(90deg, #0056b3, #003f7f);
            transform: scale(1.05);
        }
    </style>
</head>
<% 
    User user = (User) session.getAttribute("user");
    Boolean isRegistered = (Boolean) session.getAttribute("registered");
%>

<% if (user != null) { %>
    <!-- Full-Screen Welcome Modal -->
    <div class="welcome-modal" id="welcomeModal">
        <div class="message">
            <%= isRegistered != null && isRegistered ? "Welcome, " + user.getUsername() + "! Your registration was successful!" : "Welcome Back, " + user.getUsername() + "!" %>
        </div>
    </div>

    <div class="top-container">
        <div class="top-container-content">
            <%= isRegistered != null && isRegistered ? "Thanks for registering, " + user.getUsername() + "!" : "Welcome Back, " + user.getUsername() + "!" %>
        </div>
    </div>

    <div class="top-right">
        <a href="profile">
            <i class="fa-solid fa-user"></i>
        </a>
    </div>

    <div class="search-bar-container">
        <input type="text" id="searchInput" placeholder="Search food...">
        <button id="clearSearch"><i class="fa-solid fa-times"></i></button>
    </div>

    <div class="bottom-right">
        <a href="cart">View Cart</a>
        <a href="OrderHistory">Order History</a>
    </div>

    <div class="container">
        <% 
            String[] foodNames = {"Pizza", "Burger", "Pasta", "Sushi", "Salad", 
                                  "Tacos", "Steak", "Ramen", "Sandwich", "Fries", 
                                  "Ice Cream", "Soup"};

            String[] foodImages = {
                "https://plus.unsplash.com/premium_photo-1661762555601-47d088a26b50?q=80&w=1492&auto=format&fit=crop",
                "https://images.unsplash.com/photo-1571091718767-18b5b1457add?q=80&w=1472&auto=format&fit=crop",
                "https://images.unsplash.com/photo-1555949258-eb67b1ef0ceb?q=80&w=1470&auto=format&fit=crop",
                "https://images.pexels.com/photos/1140845/pexels-photo-1140845.jpeg?auto=compress&cs=tinysrgb&w=1260",
                "https://media.istockphoto.com/id/2148849755/photo/real-food-low-carb-meal-ideas-balanced-breakfast-lunch-plates.webp",
                "https://media.istockphoto.com/id/185224373/photo/spread-of-mexican-tacos-with-all-the-fixings.jpg?s=1024x1024",
                "https://images.unsplash.com/photo-1600891964092-4316c288032e?w=500&auto=format&fit=crop&q=60",
                "https://plus.unsplash.com/premium_photo-1664475934279-2631a25c42ce?w=500&auto=format&fit=crop&q=60",
                "https://media.istockphoto.com/id/1328164559/photo/veg-grilled-sandwich.webp",
                "https://media.istockphoto.com/id/148349643/photo/plate-of-delicious-looking-french-fries.webp",
                "https://media.istockphoto.com/id/157472912/photo/ice-cream-composition-on-a-bowl.jpg?s=1024x1024",
                "https://images.unsplash.com/photo-1604152135912-04a022e23696?w=500&auto=format&fit=crop&q=60"
            };

            for (int i = 0; i < foodNames.length; i++) {
        %>
            <a href="Restaurant.jsp?food=<%= foodNames[i].toLowerCase() %>" class="box" data-food="<%= foodNames[i].toLowerCase() %>">
                <img src="<%= foodImages[i] %>" class="box-image" alt="<%= foodNames[i] %>" loading="lazy">
                <h3><%= foodNames[i] %></h3>
            </a>
        <% } %>
    </div>

    <script>
        // Hide the welcome modal after 3 seconds
        setTimeout(() => {
            document.getElementById('welcomeModal').classList.add('hidden');
        }, 3000);
    </script>

    <%-- Remove "registered" session attribute after showing the welcome message --%>
    <% session.removeAttribute("registered"); %>

<% } else { %>
    <script>
        window.location.href = "registration.jsp";
    </script>
<% } %>
</html>
