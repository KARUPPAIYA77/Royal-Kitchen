/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.91
 * Generated at: 2025-03-07 07:23:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class success_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<head>\r\n");
      out.write("<!--\r\n");
      out.write("    The character encoding for the HTML document\r\n");
      out.write("    <p>Sets the character encoding for the HTML document to UTF-8</p>\r\n");
      out.write("    -->\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("\r\n");
      out.write("<!--\r\n");
      out.write("    The viewport meta tag controls the layout on mobile browsers.\r\n");
      out.write("    <p>Ensures proper rendering and touch zooming for mobile devices</p>\r\n");
      out.write("    -->\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("\r\n");
      out.write("<!--\r\n");
      out.write("    Favicon link\r\n");
      out.write("    <p>Specifies the icon to be used in the browser tab and bookmarks</p>\r\n");
      out.write("    -->\r\n");
      out.write("<link rel=\"icon\" href=\"styles/images/favicon.png\" type=\"image/png\">\r\n");
      out.write("\r\n");
      out.write("<!--\r\n");
      out.write("    The title of the document\r\n");
      out.write("    <p>Displayed on the browser tab</p>\r\n");
      out.write("    -->\r\n");
      out.write("<title>Success</title>\r\n");
      out.write("\r\n");
      out.write("<!--\r\n");
      out.write("    Link to the Bootstrap CSS file\r\n");
      out.write("    <p>Includes Bootstrap for styling</p>\r\n");
      out.write("    -->\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\"\r\n");
      out.write("	rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!--\r\n");
      out.write("    Link to the custom stylesheet\r\n");
      out.write("    <p>Includes custom styles</p>\r\n");
      out.write("    -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"styles/style.css\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<!--\r\n");
      out.write("    Background and container setup\r\n");
      out.write("    <p>Centers the success message on the page with a background</p>\r\n");
      out.write("    -->\r\n");
      out.write("	<div class=\"bg\">\r\n");
      out.write("		<div\r\n");
      out.write("			class=\"container d-flex justify-content-center align-items-center my-5\">\r\n");
      out.write("			<div class=\"glass-effect col-10 col-md-8 col-lg-6 col-xl-4\">\r\n");
      out.write("				<!--\r\n");
      out.write("                Success message heading\r\n");
      out.write("                <p>Displays the title of the success page</p>\r\n");
      out.write("                -->\r\n");
      out.write("				<h3 class=\"text-center mt-4\">Success</h3>\r\n");
      out.write("\r\n");
      out.write("				<!--\r\n");
      out.write("                Success message display\r\n");
      out.write("                <p>Shows the success message passed from the server</p>\r\n");
      out.write("                -->\r\n");
      out.write("				<div class=\"alert alert-success text-center\"\r\n");
      out.write("					style=\"max-width: 100%; word-wrap: break-word; overflow-wrap: break-word;\">\r\n");
      out.write("					");

					String message = (String) request.getAttribute("message");
					if (message != null && !message.isEmpty()) {
						out.print(message);
					} else {
						out.print("Something went wrong, please try again later!");
					}
					
      out.write("\r\n");
      out.write("				</div>\r\n");
      out.write("\r\n");
      out.write("				<!--\r\n");
      out.write("                Back button\r\n");
      out.write("                <p>Provides a link to redirect the user to the specified URL</p>\r\n");
      out.write("                -->\r\n");
      out.write("				<p class=\"text-center mt-3\">\r\n");
      out.write("					");

					String redirectUrl = (String) request.getAttribute("redirectUrl");
					
      out.write("\r\n");
      out.write("					<a\r\n");
      out.write("						href=\"");
      out.print(request.getAttribute("redirectUrl") != null ? request.getAttribute("redirectUrl")
		: request.getContextPath() + "/index.jsp");
      out.write("\"\r\n");
      out.write("						class=\"btn btn-danger\">Back</a>\r\n");
      out.write("				</p>\r\n");
      out.write("			</div>\r\n");
      out.write("		</div>\r\n");
      out.write("	</div>\r\n");
      out.write("\r\n");
      out.write("	<!--\r\n");
      out.write("    jQuery library\r\n");
      out.write("    <p>Includes the jQuery library for JavaScript functionality</p>\r\n");
      out.write("    -->\r\n");
      out.write("	<script src=\"https://code.jquery.com/jquery-3.5.1.slim.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("	<!--\r\n");
      out.write("    Popper.js library\r\n");
      out.write("    <p>Includes the Popper.js library for positioning tooltips and popovers</p>\r\n");
      out.write("    -->\r\n");
      out.write("	<script\r\n");
      out.write("		src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("	<!--\r\n");
      out.write("    Bootstrap JavaScript library\r\n");
      out.write("    <p>Includes the Bootstrap JavaScript library for interactive components</p>\r\n");
      out.write("    -->\r\n");
      out.write("	<script\r\n");
      out.write("		src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>\r\n");
      out.write("</body>\r\n");
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
