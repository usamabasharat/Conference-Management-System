package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.Connection;
import javax.servlet.jsp.jstl.sql.Result;
import java.sql.DriverManager;
import java.sql.Statement;

public final class cprofile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   <!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("  <head>\n");
      out.write("      ");

     if(session.getAttribute("user")==null)
     {
       response.sendRedirect("index.html");
     }
    
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("        ");

                 try{
                     Class.forName("com.mysql.jdbc.Driver");
                     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                     Statement st = con.createStatement();
                     String q = (String)session.getAttribute("user");
                     
                     ResultSet rs = st.executeQuery("SELECT * FROM candidate WHERE USERNAME='" + q + "' ");
                     if(rs.next())
                     { 
      out.write("\n");
      out.write("    \n");
      out.write("    <title>");
 out.println(rs.getString("NAME")); 
      out.write(" &mdash; Profile</title>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n");
      out.write("\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Roboto+Mono\" rel=\"stylesheet\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"fonts/icomoon/style.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/magnific-popup.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/jquery-ui.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/owl.carousel.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/owl.theme.default.min.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/bootstrap-datepicker.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"fonts/flaticon/font/flaticon.css\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/aos.css\">\n");
      out.write("\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("      \n");
      out.write("      \n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("      \n");
      out.write("      \n");
      out.write("      \n");
      out.write("     \n");
      out.write("  \n");
      out.write("  <div class=\"site-wrap\">\n");
      out.write("\n");
      out.write("    <div class=\"site-mobile-menu\">\n");
      out.write("      <div class=\"site-mobile-menu-header\">\n");
      out.write("        <div class=\"site-mobile-menu-close mt-3\">\n");
      out.write("          <span class=\"icon-close2 js-menu-toggle\"></span>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("      <div class=\"site-mobile-menu-body\"></div>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    <header class=\"site-navbar py-3\" role=\"banner\">\n");
      out.write("      <div class=\"container-fluid\">\n");
      out.write("        <div class=\"row align-items-center\">\n");
      out.write("          <div class=\"col-11 col-xl-2\">\n");
      out.write("            <h1 class=\"mb-0\"><a href=\"index.html\" class=\"text-white h2 mb-0\">Confe<span class=\"text-primary\">rence</span> </a></h1>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"col-12 col-md-10 d-none d-xl-block\">\n");
      out.write("            <nav class=\"site-navigation position-relative text-right\" role=\"navigation\">\n");
      out.write("              <ul class=\"site-menu js-clone-nav mx-auto d-none d-lg-block\">\n");
      out.write("                <li><a href=\"index.html\">Home</a></li>\n");
      out.write("                <li><a href=\"index.html\">");
 out.println(rs.getString("NAME")); 
      out.write("</a></li>\n");
      out.write("                <li class=\"cta\"><a href=\"logout\">Logout</a></li>\n");
      out.write("\n");
      out.write("                \n");
      out.write("              </ul>\n");
      out.write("            </nav>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"d-inline-block d-xl-none ml-md-0 mr-auto py-3\" style=\"position: relative; top: 3px;\"><a href=\"#\" class=\"site-menu-toggle js-menu-toggle text-white\"><span class=\"icon-menu h3\"></span></a></div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </header>\n");
      out.write("\n");
      out.write("      \n");
      out.write("    \n");
      out.write("\n");
      out.write("    <div class=\"site-section\" style=\"text-align: center\">\n");
      out.write("      <div class=\"container\">\n");
      out.write("        <div class=\"row\">\n");
      out.write("          <div class=\"col-md-10\" data-aos=\"fade-up\">\n");
      out.write("            \n");
      out.write("\n");
      out.write("              \n");
      out.write("                  \n");
      out.write("                    \n");
      out.write("                     Full Name  :");
 out.println(rs.getString("NAME")); 
      out.write("\n");
      out.write("             \n");
      out.write("              </div>\n");
      out.write("\n");
      out.write("              <div class=\"row form-group\">\n");
      out.write("                \n");
      out.write("                <div class=\"col-md-10\">\n");
      out.write("                   Email   : ");
 out.println(rs.getString("EMAIL")); 
      out.write(" \n");
      out.write("                </div>\n");
      out.write("              </div>\n");
      out.write("\n");
      out.write("                       ");
 }
                 }
                 catch(Exception e){
                 
                 }   
              
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("          </div>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("          \n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("\n");
      out.write("    \n");
      out.write("    \n");
      out.write("      \n");
      out.write("    <footer class=\"site-footer\">\n");
      out.write("      <div class=\"container\">\n");
      out.write("        <div class=\"row mb-5\">\n");
      out.write("          <div class=\"col-md-4\">\n");
      out.write("            <h2 class=\"footer-heading text-uppercase mb-4\">About Event</h2>\n");
      out.write("            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit aliquid quibusdam fugit architecto.</p>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"col-md-3 ml-auto\">\n");
      out.write("            <h2 class=\"footer-heading text-uppercase mb-4\">Quick Links</h2>\n");
      out.write("            <ul class=\"list-unstyled\">\n");
      out.write("              <li><a href=\"#\">About Us</a></li>\n");
      out.write("              <li><a href=\"#\">Speakers</a></li>\n");
      out.write("              <li><a href=\"#\">Gallery</a></li>\n");
      out.write("              <li><a href=\"#\">Contact Us</a></li>\n");
      out.write("            </ul>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"col-md-4\">\n");
      out.write("            <h2 class=\"footer-heading text-uppercase mb-4\">Connect with Us</h2>\n");
      out.write("            <p>\n");
      out.write("              <a href=\"#\" class=\"p-2 pl-0\"><span class=\"icon-facebook\"></span></a>\n");
      out.write("              <a href=\"#\" class=\"p-2\"><span class=\"icon-twitter\"></span></a>\n");
      out.write("              <a href=\"#\" class=\"p-2\"><span class=\"icon-youtube\"></span></a>\n");
      out.write("              <a href=\"#\" class=\"p-2\"><span class=\"icon-instagram\"></span></a>\n");
      out.write("            </p>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("      </div>\n");
      out.write("    </footer>\n");
      out.write("    \n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("  <script src=\"js/jquery-3.3.1.min.js\"></script>\n");
      out.write("  <script src=\"js/jquery-migrate-3.0.1.min.js\"></script>\n");
      out.write("  <script src=\"js/jquery-ui.js\"></script>\n");
      out.write("  <script src=\"js/popper.min.js\"></script>\n");
      out.write("  <script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("  <script src=\"js/owl.carousel.min.js\"></script>\n");
      out.write("  <script src=\"js/jquery.stellar.min.js\"></script>\n");
      out.write("  <script src=\"js/jquery.countdown.min.js\"></script>\n");
      out.write("  <script src=\"js/jquery.magnific-popup.min.js\"></script>\n");
      out.write("  <script src=\"js/bootstrap-datepicker.min.js\"></script>\n");
      out.write("  <script src=\"js/aos.js\"></script>\n");
      out.write("\n");
      out.write("  <script src=\"js/main.js\"></script>\n");
      out.write("    \n");
      out.write("  </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
