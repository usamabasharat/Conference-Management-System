<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.servlet.jsp.jstl.sql.Result"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   <!DOCTYPE html>
<html lang="en">
  <head>
      <%
     if(session.getAttribute("user")==null)
     {
       response.sendRedirect("index.html");
     }
    %>
    
     <%
                 try{
                     Class.forName("com.mysql.jdbc.Driver");
                     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                     Statement st = con.createStatement();
                     String q = (String)session.getAttribute("user");
                     String status = "Pending";
                     ResultSet rs = st.executeQuery("SELECT * FROM reviewer WHERE USERNAME='" + q + "' ");
                     if(rs.next())
                     { %>
    
                     <title><% out.println(rs.getString("NAME")); %> &mdash; Profile</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Roboto+Mono" rel="stylesheet">
    <link rel="stylesheet" href="fonts/icomoon/style.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/jquery-ui.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">
    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/style.css">
      
    
    <style>
.button11 {
   /* Green */
  border: none;
  background-color: #232531;
  padding: 8px 16px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  -webkit-transition-duration: 0.4s; /* Safari */
  transition-duration: 0.4s;
  cursor: pointer;
}
.button1 {
   
  color: #C64332; 
  border: 2px solid #3F4046;
}
.button1:hover {
  background-color: #C64332;
  border: 2px solid #C64332;
  color: white;
}

</style>
    
    
    
    
    
      
  </head>
  <body>
      
      
       
      
     
  
  <div class="site-wrap">

    <div class="site-mobile-menu">
      <div class="site-mobile-menu-header">
        <div class="site-mobile-menu-close mt-3">
          <span class="icon-close2 js-menu-toggle"></span>
        </div>
      </div>
      <div class="site-mobile-menu-body"></div>
    </div>
    
    <header class="site-navbar py-3" role="banner">
      <div class="container-fluid">
        <div class="row align-items-center">
          <div class="col-11 col-xl-2">
            <h1 class="mb-0"><a href="index.html" class="text-white h2 mb-0">CM<span class="text-primary">S</span> </a></h1>
          </div>
          <div class="col-12 col-md-10 d-none d-xl-block">
            <nav class="site-navigation position-relative text-right" role="navigation">
              <ul class="site-menu js-clone-nav mx-auto d-none d-lg-block">
                <li><a href="rprofile.jsp"><% out.println(rs.getString("NAME")); %></a></li>
                <li class="cta"><a href="logout">Logout</a></li>

                
              </ul>
            </nav>
          </div>
          <div class="d-inline-block d-xl-none ml-md-0 mr-auto py-3" style="position: relative; top: 3px;"><a href="#" class="site-menu-toggle js-menu-toggle text-white"><span class="icon-menu h3"></span></a></div>
          </div>
        </div>
      </div>
    </header>

      
    

    <div class="site-section">
      <div class="container">
        <div class="row">
          <div class="col-md-10" data-aos="fade-up">
            

              <div class="row form-group">
                
                <div class="col-md-10">
                  
                    
                    <div style="margin-left: 50px">Hi, Mr. <% out.println(rs.getString("NAME")); %>, Following requests are pending for review.</div><p></p><p></p>
                    
                    <TABLE cellpadding="15" border="3" style="background-color: #232531;">
                        <TR>
                          <TH style="width: 180px; color: yellow; text-align: center"">Paper Code</TH>  
                          <TH style="width: 180px; color: yellow; text-align: center"">Candidate Name</TH>
                          <TH style="width: 180px; color: yellow; text-align: center"">Paper Category</TH>
                        <TH style="width: 110px; color: yellow; text-align: center"">Review</TH>
                        </TR>
                     <% 
                         ResultSet rs1 = st.executeQuery("SELECT * FROM paper WHERE STATUS='" + status + "' ");
                         
                
                 while(rs1.next()){
                      %>
                      
                      <TR>
                          
                      
                          <TD style="width: 180px"><% out.println(rs1.getString("PAPERCODE"));%></TD>
                          <TD style="width: 180px"><% out.println(rs1.getString("NAME"));%></TD>
                          <TD style="width: 180px"><% out.println(rs1.getString("CATEGORY"));%></TD>
                          <TD style="width: 110px"><a  href="<%= rs1.getString("PAPERNAME") %>" download style="height:50px" >
              <span>Download</span></a></TR>
                    
              
                       <%  } %>
                    </table>
               <%
              

}
                 }
                 catch(Exception e){
                 
                 }   
              %>

              <p> </p><p> </p>
              <form action="feedback.jsp">
                  <button type="submit" class="button11 button1" style="font-size: 15px; cursor: pointer ">Feedback</button></form> 

          </div>
        </div>
      </div>
    </div>
    
      </div>
    
    
      
    <footer class="site-footer">
      <div class="container">
        <div class="row mb-5">
          <div class="col-md-4">
            <h2 class="footer-heading text-uppercase mb-4">About Event</h2>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit aliquid quibusdam fugit architecto.</p>
          </div>
          <div class="col-md-3 ml-auto">
            <h2 class="footer-heading text-uppercase mb-4">Quick Links</h2>
            <ul class="list-unstyled">
              <li><a href="#">About Us</a></li>
              <li><a href="#">Speakers</a></li>
              <li><a href="#">Gallery</a></li>
              <li><a href="#">Contact Us</a></li>
            </ul>
          </div>
          <div class="col-md-4">
            <h2 class="footer-heading text-uppercase mb-4">Connect with Us</h2>
            <p>
              <a href="#" class="p-2 pl-0"><span class="icon-facebook"></span></a>
              <a href="#" class="p-2"><span class="icon-twitter"></span></a>
              <a href="#" class="p-2"><span class="icon-youtube"></span></a>
              <a href="#" class="p-2"><span class="icon-instagram"></span></a>
            </p>
          </div>
        </div>
        
      </div>
    </footer>
    
  </div>

  <script src="js/jquery-3.3.1.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/jquery.countdown.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/bootstrap-datepicker.min.js"></script>
  <script src="js/aos.js"></script>

  <script src="js/main.js"></script>
    
  </body>
</html>