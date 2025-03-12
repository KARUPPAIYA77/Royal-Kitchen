<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tapfoods.model.User" %>
<%@ page import="java.util.Arrays" %>
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

        /* Main Content Area with Boxes */
        .container {
            width: 90%;
            margin: auto;
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
            gap: 20px;
            margin-top: 80px;
        }

        /* Colorful Content Box Styles */
        .box {
            padding: 20px;
            text-align: center;
            font-size: 16px;
            display: flex;
            justify-content: center;
            align-items: flex-start;
            flex-direction: column;
            border-radius: 12px;
            color: white;
            background: linear-gradient(145deg, #FF6B6B, #FFD93D);
            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.2);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
            min-height: 300px;
            margin-bottom: 20px;
            cursor: pointer;
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
            margin-bottom: 15px;
            font-weight: 600;
        }

        .box .box-image {
            width: 100%;
            height: auto;
            border-radius: 8px;
            margin-bottom: 15px;
            object-fit: cover;
        }

        .details-row {
            display: flex;
            justify-content: space-between;
            margin-bottom: 10px;
            width: 100%;
        }

        .details-row span {
            font-size: 14px;
            color: #f1f1f1;
        }

        .rating {
            background-color: #28a745;
            color: white;
            font-weight: bold;
            padding: 5px 10px;
            border-radius: 20px;
            font-size: 16px;
        }

        /* Gray Box Styling */
        .gray-box {
            background: linear-gradient(145deg, #D3D3D3, #A9A9A9);
            filter: grayscale(100%);
            cursor: pointer;
            opacity: 0.6;
        }

        .gray-box:hover {
            transform: none;
            box-shadow: none;
        }

        a {
            text-decoration: none;
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

        /* Bottom Right Buttons */
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

        /* Food Name Container Styling */
        .food-name-container {
            margin-top: 130px; /* Moves food name below search bar */
            font-size: 28px;
            font-weight: 600;
            text-align: center;
            color: #333;
            margin-bottom: 20px;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.8); /* Light background */
            border-radius: 12px; /* Rounded corners */
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1); /* Soft shadow */
        }

        /* Price in the top right of image */
        .price-top-right {
            position: absolute;
            top: 10px;
            right: 10px;
            background-color: rgba(0, 0, 0, 0.7);
            color: white;
            padding: 5px 10px;
            font-size: 14px;
            font-weight: bold;
            border-radius: 5px;
        }

    </style>
</head>
<body>
    <% User user = (User) session.getAttribute("user"); %>
    <% if (user != null) { %>

        <div class="top-container">
            <div class="top-container-content">Welcome Back, <%= user.getUsername() %>!</div>
        </div>

        <div class="top-right">
            <a href="profile">
                <i class="fa-solid fa-user"></i>
            </a>
        </div>

        <div class="search-bar-container">
            <input type="text" id="searchInput" placeholder="Search restaurant...">
            <button id="clearSearch"><i class="fa-solid fa-times"></i></button>
        </div>

        <div class="bottom-right">
            <a href="cart">View Cart</a>
            <a href="OrderHistory">Order History</a>
        </div>

        <%@ page import="java.net.URLDecoder" %>
        <%@ page import="java.nio.charset.StandardCharsets" %>

        <%
            String food = request.getParameter("food");
            if (food != null) {
                food = URLDecoder.decode(food, StandardCharsets.UTF_8.name());
            }
        %>

        <!-- Display Food Name Below Search Bar -->
        <div class="food-name-container">
            <%= food %>
        </div>

        <div class="container">
            <% 
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

                String[] inactiveRestaurants = {"Sushi Haven", "Taco Town", "Café Delights"};

                for (String[] restaurant : restaurantDetails) {
                    String restaurantName = restaurant[0];
                    String cuisineType = restaurant[1];
                    String rating = restaurant[2];
                    String deliveryTime = restaurant[3];
                    String address = restaurant[4];
                    String isActive = restaurant[5];
                    String price = restaurant[6];
                    boolean isInactive = Arrays.asList(inactiveRestaurants).contains(restaurantName);
            %>
                <a href="RestaurantDetails.jsp?restaurant=<%= restaurantName.toLowerCase().replace(" ", "-") %>&food=<%= food %>" 
                   class="box <%= isInactive ? "gray-box" : "" %>" 
                   data-restaurant="<%= restaurantName.toLowerCase().replace(" ", "-") %>">
                    <div style="position: relative;">
                        <!-- Price in Top Right Corner -->
                        <div class="price-top-right">
                            <%= price %>
                        </div>
                        <img src="https://images.pexels.com/photos/262978/pexels-photo-262978.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1" 
                             class="box-image" alt="<%= restaurantName %>">
                    </div>
                    <h3><%= restaurantName %></h3>
                    <div class="details-row">
                        <span>Cuisine: <%= cuisineType %></span>
                        <span>Delivery: <%= deliveryTime %></span>
                    </div>
                    <div class="details-row">
                        <span>Address: <%= address %></span>
                        <span class="rating"><%= rating %> ★</span>
                    </div>
                   
                    <div class="details-row">
                        <span>Status: <%= isActive.equals("true") ? "Active" : "Inactive" %></span>
                    </div>

                    <% if (isInactive) { %>
                        <div class="details-row">
                            <span style="color: red; font-weight: bold;">Restaurant is not available</span>
                        </div>
                    <% } %>
                </a>
            <% } %>
        </div>

    <% } %>
</body>
</html>
