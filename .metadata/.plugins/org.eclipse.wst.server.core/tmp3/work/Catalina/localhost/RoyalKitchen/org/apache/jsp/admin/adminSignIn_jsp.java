/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.91
 * Generated at: 2025-03-07 06:50:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminSignIn_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("\r\n");
      out.write("<!--\r\n");
      out.write("    Favicon\r\n");
      out.write("    <p>Sets the favicon for the admin sign-in page</p>\r\n");
      out.write("    -->\r\n");
      out.write("<link rel=\"icon\" href=\"styles/images/favicon.png\" type=\"image/png\">\r\n");
      out.write("\r\n");
      out.write("<!--\r\n");
      out.write("    Font Awesome CSS\r\n");
      out.write("    <p>Includes the Font Awesome library for using icon fonts</p>\r\n");
      out.write("    -->\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\"\r\n");
      out.write("	rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<title>Admin Sign In</title>\r\n");
      out.write("\r\n");
      out.write("<!--\r\n");
      out.write("    Bootstrap CSS\r\n");
      out.write("    <p>Includes the Bootstrap 4.5.2 CSS for responsive layout and design</p>\r\n");
      out.write("    -->\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\"\r\n");
      out.write("	rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!--\r\n");
      out.write("    Custom Stylesheet\r\n");
      out.write("    <p>Includes custom CSS for additional styling</p>\r\n");
      out.write("    -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"styles/style.css\">\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("	");

	session = request.getSession(false);

	// Check if the user is logged in
	if (session == null || session.getAttribute("isLoggedIn") == null) {
		// Redirect to the sign-in page if the user is not logged in
		response.sendRedirect(request.getContextPath() + "/index.jsp");
		return;
	}

	// Check if the logout request is made
	if ("POST".equalsIgnoreCase(request.getMethod()) && "true".equals(request.getParameter("logout"))) {
		session.invalidate(); // Invalidate the session
		response.sendRedirect(request.getContextPath() + "/index.jsp"); // Redirect to sign-in page
		return;
	}

	// Prevent caching to ensure that the logout is effective
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0
	response.setDateHeader("Expires", 0); // Proxies
	
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<!-- Logout button positioned at the top right -->\r\n");
      out.write("	<form method=\"post\" style=\"display: inline;\">\r\n");
      out.write("		<input type=\"hidden\" name=\"logout\" value=\"true\">\r\n");
      out.write("		<button type=\"submit\" class=\"btn btn-danger logout-btn\">Logout</button>\r\n");
      out.write("	</form>\r\n");
      out.write("\r\n");
      out.write("	<!--\r\n");
      out.write("    Admin Sign In Container\r\n");
      out.write("    <p>Main container for the admin sign-in form, centered and padded for a clean look</p>\r\n");
      out.write("    -->\r\n");
      out.write("	<div class=\"admin py-5\">\r\n");
      out.write("		<div\r\n");
      out.write("			class=\"container d-flex justify-content-start align-items-center my-5\">\r\n");
      out.write("			<div\r\n");
      out.write("				class=\"card shadow-lg col-12 col-md-6 col-lg-4 col-xl-4 custom-styles\">\r\n");
      out.write("				<div class=\"card-body py-4\">\r\n");
      out.write("\r\n");
      out.write("					<!--\r\n");
      out.write("                    Sign-In Instructions\r\n");
      out.write("                    <p>Provides instructions for signing in</p>\r\n");
      out.write("                    -->\r\n");
      out.write("					<p class=\"text-danger pb-1\" style=\"font-size: 16px;\">\r\n");
      out.write("						Follow the steps below to Sign In <i class=\"fas fa-user-shield\"\r\n");
      out.write("							style=\"font-size: 14px;\"></i>\r\n");
      out.write("					</p>\r\n");
      out.write("\r\n");
      out.write("					<!--\r\n");
      out.write("                    Sign-In Form\r\n");
      out.write("                    <p>Form for admin sign-in, containing fields for the admin key and password</p>\r\n");
      out.write("                    -->\r\n");
      out.write("					<form action=\"adminSignIn\" method=\"post\">\r\n");
      out.write("						<div class=\"form-group\">\r\n");
      out.write("							<label for=\"adminKey\" style=\"font-size: 14px;\">Secret\r\n");
      out.write("								Admin Key</label>\r\n");
      out.write("							<div class=\"input-group\">\r\n");
      out.write("								<input type=\"password\" class=\"form-control\" id=\"adminKey\"\r\n");
      out.write("									name=\"adminkey\" placeholder=\"Enter key\" required\r\n");
      out.write("									style=\"border: solid 1px lightgray\">\r\n");
      out.write("\r\n");
      out.write("								<!--\r\n");
      out.write("                                Toggle Admin Key Visibility\r\n");
      out.write("                                <p>Icon to toggle visibility of the admin key input</p>\r\n");
      out.write("                                -->\r\n");
      out.write("								<div class=\"input-group-append\">\r\n");
      out.write("									<span class=\"input-group-text\" id=\"toggle-admin-key\"\r\n");
      out.write("										data-toggle=\"password\" data-target=\"adminKey\" style=\"cursor: pointer;\"> <i\r\n");
      out.write("										class=\"fas fa-eye\"></i>\r\n");
      out.write("									</span>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("							<small class=\"form-text text-danger\">Format:\r\n");
      out.write("								admin.username@restaurantname_address</small>\r\n");
      out.write("						</div>\r\n");
      out.write("\r\n");
      out.write("						<div class=\"form-group\">\r\n");
      out.write("							<label for=\"password\" style=\"font-size: 14px;\">Password</label>\r\n");
      out.write("							<div class=\"input-group\">\r\n");
      out.write("								<input type=\"password\" class=\"form-control\" id=\"password\"\r\n");
      out.write("									name=\"password\" placeholder=\"Enter password\" required\r\n");
      out.write("									style=\"border: solid 1px lightgray\">\r\n");
      out.write("\r\n");
      out.write("								<!--\r\n");
      out.write("                                Toggle Password Visibility\r\n");
      out.write("                                <p>Icon to toggle visibility of the password input</p>\r\n");
      out.write("                                -->\r\n");
      out.write("								<div class=\"input-group-append\">\r\n");
      out.write("									<span class=\"input-group-text\" id=\"toggle-password\"\r\n");
      out.write("										data-toggle=\"password\" data-target=\"password\" style=\"cursor: pointer;\"> <i\r\n");
      out.write("										class=\"fas fa-eye\"></i>\r\n");
      out.write("									</span>\r\n");
      out.write("								</div>\r\n");
      out.write("							</div>\r\n");
      out.write("						</div>\r\n");
      out.write("\r\n");
      out.write("						<!--\r\n");
      out.write("                        Submit Button\r\n");
      out.write("                        <p>Button to submit the sign-in form</p>\r\n");
      out.write("                        -->\r\n");
      out.write("						<button type=\"submit\" class=\"btn btn-success mt-2\">Sign\r\n");
      out.write("							In</button>\r\n");
      out.write("					</form>\r\n");
      out.write("\r\n");
      out.write("					<!--\r\n");
      out.write("                    Sign-Up Link\r\n");
      out.write("                    <p>Link to the admin sign-up page for those who are not yet admins</p>\r\n");
      out.write("                    -->\r\n");
      out.write("					<p class=\"text-center mt-3\" style=\"font-size: 14px;\">\r\n");
      out.write("						Not an admin? <a href=\"adminSignUp.jsp\" class=\"text-success\"\r\n");
      out.write("							style=\"color: green; text-decoration: none;\"\r\n");
      out.write("							onmouseover=\"this.style.color='darkgreen'; this.style.textDecoration='underline';\"\r\n");
      out.write("							onmouseout=\"this.style.color='green'; this.style.textDecoration='none';\">Sign\r\n");
      out.write("							Up</a>\r\n");
      out.write("					</p>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("	<!--\r\n");
      out.write("    Custom JavaScript for Password Visibility Toggle\r\n");
      out.write("    <p>Includes a custom script to handle password visibility toggle</p>\r\n");
      out.write("    -->\r\n");
      out.write("	<script type=\"text/javascript\" src=\"styles/password.js\"></script>\r\n");
      out.write("\r\n");
      out.write("	<!--\r\n");
      out.write("    jQuery Library\r\n");
      out.write("    <p>Includes the jQuery library for handling JavaScript actions</p>\r\n");
      out.write("    -->\r\n");
      out.write("	<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("	<!--\r\n");
      out.write("    Popper.js Library\r\n");
      out.write("    <p>Includes the Popper.js library for positioning tooltips and popovers</p>\r\n");
      out.write("    -->\r\n");
      out.write("	<script\r\n");
      out.write("		src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("	<!--\r\n");
      out.write("    Bootstrap JavaScript Library\r\n");
      out.write("    <p>Includes the Bootstrap JavaScript library for interactive components</p>\r\n");
      out.write("    -->\r\n");
      out.write("	<script\r\n");
      out.write("		src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
