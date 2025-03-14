
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<!--
    The character encoding for the HTML document
    <p>Sets the character encoding for the HTML document to UTF-8</p>
    -->
<meta charset="UTF-8">

<!--
    The viewport meta tag controls the layout on mobile browsers.
    <p>Ensures proper rendering and touch zooming for mobile devices</p>
    -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!--
    Favicon link
    <p>Specifies the icon to be used in the browser tab and bookmarks</p>
    -->
<link rel="icon" href="admin/styles/images/favicon.png" type="image/png">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
	rel="stylesheet">

<!--
    The title of the document
    <p>Displayed on the browser tab</p>
    -->
<title>Sign Up</title>

<!--
    Link to the Bootstrap CSS file
    <p>Includes Bootstrap for styling</p>
    -->
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet">

<!--
    Link to the custom stylesheet
    <p>Includes custom styles</p>
    -->
<link rel="stylesheet" href="admin/styles/style.css">
</head>
<body>
	<!--
    Background and container setup
    <p>Centers the sign-up form on the page with a background</p>
    -->
	<div class="bg">
		<div
			class="container d-flex justify-content-center align-items-center mt-5 mb-3">
			<div class="glass-effect col-10 col-md-8 col-lg-6 col-xl-4">
				<!--
                The heading of the sign-up form
                <p>Displayed as the form title</p>
                -->
				<h3 class="text-center mt-4">Sign Up</h3>

				<!--
                The sign-up form
                <p>Collects user details for signing up</p>
                -->
				<form action="signUp" method="post">
    <!-- Username -->
    <div class="form-group">
        <label for="username">Username</label>
        <input type="text" class="form-control" id="username" name="username" placeholder="Enter username" required>
    </div>

    <!-- Email -->
    <div class="form-group">
        <label for="email">Email address</label>
        <input type="email" class="form-control" id="email" name="email" placeholder="Enter email" required>
    </div>

    <!-- Phone Number -->
    <div class="form-group">
        <label for="phonenumber">Phone Number</label>
        <input type="text" class="form-control" id="phonenumber" name="phonenumber" placeholder="Enter phone number" required>
    </div>

    <!-- Address -->
    <div class="form-group">
        <label for="address">Address</label>
        <input type="text" class="form-control" id="address" name="address" placeholder="Enter address" required>
    </div>

    <!-- Password -->
    <div class="form-group">
        <label for="password">Password</label>
        <div class="input-group">
            <input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
            <div class="input-group-append">
                <span class="input-group-text form-control" id="toggle-password" data-toggle="password" data-target="password" style="cursor: pointer;"> 
                    <i class="fas fa-eye"></i>
                </span>
            </div>
        </div>
        <small class="form-text text-black">Password must be between 8-25 characters.</small>
    </div>

    <!-- Confirm Password -->
    <div class="form-group">
        <label for="confirm-password">Confirm Password</label>
        <div class="input-group">
            <input type="password" class="form-control" id="confirm-password" name="confirmpassword" placeholder="Confirm Password" required>
            <div class="input-group-append">
                <span class="input-group-text form-control" id="toggle-confirm-password" data-toggle="password" data-target="confirm-password" style="cursor: pointer;"> 
                    <i class="fas fa-eye"></i>
                </span>
            </div>
        </div>
        <small class="form-text text-black">Password and confirm password should match.</small>
    </div>

    <!-- Submit Button -->
    <button type="submit" class="btn btn-danger mt-2">Sign Up</button>
</form>


				<!--
                Link to the sign-in page
                <p>Provides an option for existing users to sign in</p>
                -->
				<p class="text-center mt-3">
					Already a user? <a href="signIn.jsp" class="sign-link">Sign In</a>
				</p>
			</div>
		</div>
	</div>

	<!--
    jQuery library
    <p>Includes the jQuery library for JavaScript functionality</p>
    -->
	<script type="text/javascript" src="admin/styles/password.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>

	<!--
    Popper.js library
    <p>Includes the Popper.js library for positioning tooltips and popovers</p>
    -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>

	<!--
    Bootstrap JavaScript library
    <p>Includes the Bootstrap JavaScript library for interactive components</p>
    -->
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
