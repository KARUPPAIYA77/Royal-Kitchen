
package com.tapfoods.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Servlet for handling admin access validation.
 * <p>
 * This servlet processes POST requests to validate the private key entered by the admin. 
 * It checks whether the key matches the expected value and redirects to the appropriate 
 * page based on the validation result. If the key is valid, a session variable is set with 
 * a timeout of 5 minutes, after which it will be automatically removed.
 * </p>
 * 
 * @see HttpServlet
 */
@WebServlet("/AdminAccessServlet")
public class AdminAccessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String ORIGINAL_KEY = "paiya121";

	/**
	 * Handles HTTP POST requests for validating the admin's private key.
	 * <p>
	 * This method retrieves the private key entered by the admin, compares it with 
	 * the original key, and redirects to the admin sign-in page if the validation 
	 * is successful. If the validation fails, it redirects to an error page with 
	 * an appropriate message.
	 * </p>
	 * 
	 * @param request  The {@link HttpServletRequest} object that contains the request from the client.
	 * @param response The {@link HttpServletResponse} object used to send a response to the client.
	 * @throws ServletException If the request cannot be handled.
	 * @throws IOException      If an I/O error occurs while handling the request or response.
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {

	    // Retrieve the key entered by the user
	    String enteredKey = request.getParameter("privateKey");
	    System.out.println("Entered Key: " + enteredKey); // Debugging line

	    // Debugging the stored key
	    System.out.println("Stored Key: " + ORIGINAL_KEY);

	    // Validate the key
	    if (ORIGINAL_KEY.equals(enteredKey)) {
	        HttpSession session = request.getSession();
	        session.setAttribute("isLoggedIn", true);
	        session.setMaxInactiveInterval(300); // 5 minutes
	        response.sendRedirect("admin/adminSignIn.jsp");
	    } else {
	        request.setAttribute("message", "Invalid private key. Please contact the administrator.");
	        request.setAttribute("redirectUrl", "searchRestaurants"); 
	        request.getRequestDispatcher("error.jsp").forward(request, response);
	    }
	}
}
