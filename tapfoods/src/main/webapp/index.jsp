<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Index Page</title>
    
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;700&display=swap" rel="stylesheet">
    <style>
        body {
            background-image: url('https://cdn.dribbble.com/userupload/11445462/file/original-f13200e3c9bc09236e239250d690556e.jpg?resize=1024x1434');
            background-size: cover;
            background-position: center;
            margin: 0;
            font-family: 'Montserrat', sans-serif;
        }
        .top-bar {
            display: flex;
            justify-content: flex-end;
            background-color: rgba(0, 0, 0, 0.6);
            padding: 15px 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
        }
        .top-bar a {
            margin-left: 15px;
            padding: 10px 20px;
            font-size: 16px;
            color: white;
            background: linear-gradient(90deg, #007BFF, #0056b3);
            border: none;
            border-radius: 25px;
            text-decoration: none;
            cursor: pointer;
            transition: background 0.3s, transform 0.3s;
        }
        .top-bar a:hover {
            background: linear-gradient(90deg, #0056b3, #003f7f);
            transform: scale(1.1);
        }
        .top-bar .thicker-font {
            font-weight: bold;
        }
        .center-content {
            display: flex;
            justify-content: center;
            align-items: center;
            height: calc(100vh - 70px); /* Adjusted to account for the top bar height */
            text-align: center;
        }
        .center-content .content-wrapper {
            background: linear-gradient(135deg, rgba(0, 0, 0, 0.7), rgba(0, 0, 64, 0.7)); /* Gradient with semi-transparent black and deep blue */
            backdrop-filter: blur(10px); /* 50% blur effect */
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.3);
            max-width: 90%;
            width: 500px; /* Set max width for larger screens */
        }
        .center-content h1 {
            font-size: 2.5em; /* Adjusted for better readability on various screen sizes */
            color: white;
            margin-bottom: 20px;
        }
        .center-content .button {
            display: inline-block;
            padding: 15px 30px;
            font-size: 18px;
            color: white;
            background: linear-gradient(90deg, #007BFF, #0056b3);
            border: none;
            border-radius: 25px;
            text-decoration: none;
            cursor: pointer;
            transition: background 0.3s, transform 0.3s;
        }
        .center-content .button:hover {
            background: linear-gradient(90deg, #0056b3, #003f7f);
            transform: scale(1.1);
        }
        .center-content .thicker-font {
            font-weight: bold;
        }
        @media (max-width: 768px) {
            .center-content .content-wrapper {
                padding: 20px;
                width: 90%;
            }
            .center-content h1 {
                font-size: 2em; /* Slightly smaller font size on smaller screens */
            }
            .center-content .button {
                font-size: 16px; /* Adjust button font size */
                padding: 12px 25px; /* Adjust button padding */
            }
        }
    </style>
</head>
<body>
    <div class="top-bar">
        <a href="Login.jsp" class="thicker-font">Sign In</a>
        <a href="registration.jsp" class="thicker-font">Sign Up</a>
    </div>
    <div class="center-content">
        <div class="content-wrapper">
            <h1>Welcome to Our Restaurant</h1>
            <a href="startOrdering.jsp" class="button thicker-font">Start Ordering</a>
        </div>
    </div>
</body>
</html>
