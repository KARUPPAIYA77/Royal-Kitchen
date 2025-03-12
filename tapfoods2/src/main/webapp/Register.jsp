<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #f4f4f4;
            background-image: url('https://cdn.dribbble.com/userupload/11445462/file/original-f13200e3c9bc09236e239250d690556e.jpg?resize=1024x1434'); /* Background image */
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
        }
        .container {
            width: 100%;
            max-width: 500px;
            padding: 20px;
            background: linear-gradient(135deg, rgba(0, 0, 0, 0.7), rgba(0, 0, 64, 0.7)); /* Gradient with semi-transparent black and deep blue */
            backdrop-filter: blur(10px); /* Blur effect */
            color: #e0e0e0; /* Changed text color to a lighter shade */
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.3);
            box-sizing: border-box;
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
            font-weight: bold;
            color: #fff; /* White color for heading */
        }
        .form-group {
            margin-bottom: 15px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
            color: #ddd; /* Light color for labels */
        }
        .form-group input,
        .form-group textarea {
            width: 100%;
            padding: 10px;
            box-sizing: border-box;
            border: 1px solid #444;
            border-radius: 4px;
            background-color: #fff; /* Brighter white background for input fields */
            color: #000; /* Black text color in input fields */
            font-weight: 300; /* Reduced thickness for input text */
        }
        .form-group textarea {
            resize: vertical;
            min-height: 80px;
            padding: 10px; /* Improved padding for textarea */
        }
        .form-group button {
            width: 100%;
            padding: 10px;
            border: none;
            border-radius: 4px;
            background: linear-gradient(90deg, #007BFF, #0056b3); /* Blue gradient background */
            color: white;
            font-size: 16px;
            cursor: pointer;
            font-weight: bold;
            transition: background 0.3s, transform 0.3s;
        }
        .form-group button:hover {
            background: linear-gradient(90deg, #0056b3, #003f7f); /* Darker blue gradient on hover */
            transform: scale(1.1);
        }
        .sign-in-link {
            text-align: center;
            margin-top: 20px;
        }
        .sign-in-link p {
            font-weight: bold;
            margin: 0;
            color: #ddd; /* Light color for sign-in text */
        }
        .sign-in-link a {
            color: #007bff;
            text-decoration: none;
            font-size: 16px;
            font-weight: bold;
        }
        .sign-in-link a:hover {
            text-decoration: underline;
        }
        @media (max-width: 600px) {
            .container {
                padding: 10px;
                width: 90%;
                max-width: 100%;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Registration Form</h1>
        <form action="submit.jsp" method="post">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required aria-label="Username">
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required aria-label="Email">
            </div>
            <div class="form-group">
                <label for="phone">Phone Number:</label>
                <input type="tel" id="phone" name="phone" required aria-label="Phone Number">
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required aria-label="Password">
            </div>
            <div class="form-group">
                <label for="address">Address:</label>
                <textarea id="address" name="address" rows="4" required aria-label="Address"></textarea>
            </div>
            <div class="form-group">
                <button type="submit">Register</button>
            </div>
            <div class="sign-in-link">
                <p>Already have an account? <a href="login.jsp">Sign In</a></p>
            </div>
        </form>
    </div>
</body>
</html>
