package com.tapfoods.servlet;

import java.io.IOException;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tapfoods.DAO.UserDAO;
import com.tapfoods.DAOImpl.UserDAOImpl;
import com.tapfoods.model.User;

@WebServlet("/signUp")
public class SignUp extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String phonenumber = req.getParameter("phonenumber");
        String address = req.getParameter("address");
        String password = req.getParameter("password");
        String confirmpassword = req.getParameter("confirmpassword");

        UserDAO userDao = null;
        try {
            userDao = new UserDAOImpl();
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("message", "Database connection error.");
            req.setAttribute("redirectUrl", "signUp.jsp");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
            return;
        }

        // Validate input
        String errorMessage = null;
        if (!isValidEmail(email)) {
            errorMessage = "Invalid email format";
        } else if (username == null || username.isEmpty()) {
            errorMessage = "Username is required";
        } else if (phonenumber == null || phonenumber.isEmpty()) {
            errorMessage = "Phone number is required";
        } else if (address == null || address.isEmpty()) {
            errorMessage = "Address is required";
        } else if (password.length() < 8 || password.length() > 25) {
            errorMessage = "Password must be between 8 and 25 characters long";
        } else if (!password.equals(confirmpassword)) {
            errorMessage = "Passwords do not match";
        }

        // If there's an error, redirect to error page
        if (errorMessage != null) {
            req.setAttribute("message", errorMessage);
            req.setAttribute("redirectUrl", "signUp.jsp");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
            return;
        }

        // Check if email already exists
        try {
            if (userDao.emailExists(email)) {
                req.setAttribute("message", "Email already exists");
                req.setAttribute("redirectUrl", "signUp.jsp");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Create user and insert into database
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPhonenumber(phonenumber);
        user.setAddress(address);
        user.setPassword(password);

        try {
            int status = userDao.addUser(user);
            if (status > 0) {
                req.setAttribute("message", "User registered successfully.");
                req.setAttribute("redirectUrl", "signIn.jsp");
                req.getRequestDispatcher("success.jsp").forward(req, resp);
            } else {
                req.setAttribute("message", "User registration failed. Please try again.");
                req.setAttribute("redirectUrl", "signUp.jsp");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return email != null && pattern.matcher(email).matches();
    }
}
