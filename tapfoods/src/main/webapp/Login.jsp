<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-image: url('https://cdn.dribbble.com/userupload/11445462/file/original-f13200e3c9bc09236e239250d690556e.jpg?resize=1024x1434'); /* Background image */
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background: linear-gradient(135deg, rgba(0, 0, 0, 0.7), rgba(0, 0, 64, 0.7)); /* Gradient with semi-transparent black and deep blue */
            backdrop-filter: blur(10px); /* Blur effect */
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.3);
            width: 400px; /* Increased width for the container */
            color: #fff; /* White text color for better contrast */
            box-sizing: border-box;
        }
        h2 {
            margin-top: 0;
            font-weight: 900; /* Extra thick font for heading */
            text-align: center; /* Centered heading */
        }
        .form-group {
            margin-bottom: 20px; /* Increased margin for extra spacing between form elements */
        }
        .form-group label {
            display: block;
            margin-bottom: 10px; /* Added space between label and input */
            font-weight: bold; /* Bold labels */
        }
        .form-group input {
            width: 100%; /* Full width of the container */
            padding: 12px; /* Increased padding for more white space inside input fields */
            box-sizing: border-box;
            font-size: 16px; /* Font size for input text */
            font-weight: 400; /* Normal weight for input text */
            background: #fff; /* White background for input fields */
            border: 1px solid #ddd; /* Light border for inputs */
            border-radius: 4px; /* Slightly rounded corners */
            color: #000; /* Black text color for input fields */
        }
        .btn {
            background: linear-gradient(90deg, #007BFF, #0056b3); /* Blue gradient background */
            color: #fff;
            border: none;
            padding: 10px 15px;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
            font-weight: bold; /* Bold button text */
            transition: background 0.3s, transform 0.3s;
        }
        .btn:hover {
            background: linear-gradient(90deg, #0056b3, #003f7f); /* Darker blue on hover */
            transform: scale(1.1);
        }
        .register-link {
            display: block;
            margin-top: 15px; /* Increased margin for more space between button and link */
            text-align: center;
            color: #007bff; /* Blue color for register link */
            font-weight: bold; /* Bold register link text */
            text-decoration: none; /* Remove underline from link */
            padding: 10px 15px; /* Button-like padding */
            border: 1px solid #007bff; /* Border matching the link color */
            border-radius: 5px; /* Rounded corners */
            background: rgba(0, 0, 0, 0.3); /* Slightly dark background */
            transition: background 0.3s, color 0.3s; /* Smooth transition */
        }
        .register-link:hover {
            color: #fff; /* White text on hover */
            background: #007bff; /* Blue background on hover */
            border-color: #007bff; /* Matching border color on hover */
        }
        .sign-in-text {
            text-align: center;
            margin-top: 10px;
            color: #fff; /* White color for sign-in text */
            font-weight: bold; /* Bold text */
        }
        .sign-in-text a {
            color: #007bff; /* Blue color for the link */
            text-decoration: none; /* Remove underline from link */
            font-weight: bold; /* Bold link text */
        }
        .sign-in-text a:hover {
            color: #0056b3; /* Darker blue on hover */
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Login</h2>
        <form action="Login" method="post">
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <button type="submit" class="btn">Login</button>
        </form>
        <div class="sign-in-text">
            <p>Don't have an account? <a href="registration.jsp">Register here</a></p>
        </div>
    </div>
</body>
</html>
