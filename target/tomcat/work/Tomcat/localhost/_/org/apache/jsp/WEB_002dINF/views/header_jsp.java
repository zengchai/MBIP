/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2024-01-31 16:52:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class header_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
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
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("  <meta charset=\"UTF-8\">\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"/static/css/headerCss.css\">\r\n");
      out.write(" \r\n");
      out.write("  <style>\r\n");
      out.write("    .dropdown {\r\n");
      out.write("      position: relative;\r\n");
      out.write("      display: inline-block;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .dropdown-content {\r\n");
      out.write("      display: none;\r\n");
      out.write("      position: absolute;\r\n");
      out.write("      background-color: #f9f9f9;\r\n");
      out.write("      min-width: 160px;\r\n");
      out.write("      box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);\r\n");
      out.write("      z-index: 1;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .dropdown-content a {\r\n");
      out.write("      color: black;\r\n");
      out.write("      padding: 12px 16px;\r\n");
      out.write("      text-decoration: none;\r\n");
      out.write("      display: block;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .dropdown-content a:hover {\r\n");
      out.write("      background-color: #f1f1f1;\r\n");
      out.write("    }\r\n");
      out.write("  </style>\r\n");
      out.write("  <title>Header</title>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("  <div class='header-container'>\r\n");
      out.write("    <img class=\"header-background-image\" src=\"/static/asset/headerIMG/upper bar image.png\" alt=\"upper bar image\">\r\n");
      out.write("    <img class=\"overlay-image\" src=\"/static/asset/headerIMG/image MBIP.png\" alt=\"image MBIP\">\r\n");
      out.write("\r\n");
      out.write("    <div class=\"login\">\r\n");
      out.write("      <div style=\"grid-column: 1/2; grid-row: 1/2;\">\r\n");
      out.write("        <h4><b>Account</b></h4>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div style=\"grid-column: 2/3; grid-row: 1/2;\" class=\"dropdown\">\r\n");
      out.write("        <img class=\"user-image\" src=\"/static/asset/headerIMG/userIcon.png\" alt=\"User Icon\" onclick=\"toggleDropdown()\">\r\n");
      out.write("        <div id=\"dropdown-menu\" class=\"dropdown-content\">\r\n");
      out.write("          <a href=\"/updateprofile?fullname=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.getFullname()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("          &nickname=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.getNickname()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("&email=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.getEmail()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("          &phonenum=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.getPhoneNum()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("&language=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.getPreferredLanguage()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("          &category=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.getCategory()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("&poscode=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.getPoscode()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("          &address=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.getAddress()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\">Profile</a>\r\n");
      out.write("          <a href=\"/logout\">Logout</a>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div style=\"grid-column: 3/4; grid-row: 1/2;\" class=\"dropdown\">\r\n");
      out.write("        <h4>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.user.getUsername()}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</h4>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <script>\r\n");
      out.write("      var dropdownVisible = false;\r\n");
      out.write("    \r\n");
      out.write("      function toggleDropdown() {\r\n");
      out.write("        var dropdown = document.getElementById(\"dropdown-menu\");\r\n");
      out.write("        dropdown.style.display = dropdownVisible ? 'none' : 'block';\r\n");
      out.write("        dropdownVisible = !dropdownVisible;\r\n");
      out.write("      }\r\n");
      out.write("    \r\n");
      out.write("      // Close the dropdown if the user clicks outside of it\r\n");
      out.write("      window.onclick = function(event) {\r\n");
      out.write("        if (!event.target.matches('.user-image')) {\r\n");
      out.write("          var dropdowns = document.getElementsByClassName(\"dropdown-content\");\r\n");
      out.write("          for (var i = 0; i < dropdowns.length; i++) {\r\n");
      out.write("            var openDropdown = dropdowns[i];\r\n");
      out.write("            if (openDropdown.style.display === 'block') {\r\n");
      out.write("              openDropdown.style.display = 'none';\r\n");
      out.write("              dropdownVisible = false;\r\n");
      out.write("            }\r\n");
      out.write("          }\r\n");
      out.write("        }\r\n");
      out.write("      }\r\n");
      out.write("    </script>\r\n");
      out.write("    \r\n");
      out.write("  </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
