/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author miana
 */
@WebServlet(urlPatterns = {"/RegistrationMethod"})
public class signup extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Connection con;
    Statement st;
    ResultSet rs;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //response.sendRedirect("index.jsp");
                      
            String name = request.getParameter("name");
            String username = request.getParameter("uname");
            String mail = request.getParameter("email");
            String gender = request.getParameter("gen");
            String pass = request.getParameter("password");
            String cpass = request.getParameter("cpassword");
          
            
            if(pass.equals(cpass)){
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                    st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    rs = st.executeQuery("SELECT * FROM candidate where USERNAME='"+username+"'");
                    
                    if(!rs.next()){
                    
                        
                    rs.moveToInsertRow();                    
                    rs.updateString("USERNAME", username);                
                    rs.updateString("NAME", name);
                    rs.updateString("EMAIL", mail);
                    rs.updateString("GENDER", gender);
                    rs.updateString("PASSWORD", pass);
                    
                    
                    rs.insertRow();
                    
                    
                    
                    response.sendRedirect("ssignup.html");
                        
                    
                    }
                    else{
                        response.sendRedirect("nsignup.html");
                        //out.print("else1");
                    }
                    
                    
                        
                }catch(Exception e){
                   // response.sendRedirect("nsignup.html");
                    out.print("exception");

                }
            }
            else{
                out.print("else2");
               // response.sendRedirect("signup.html");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}