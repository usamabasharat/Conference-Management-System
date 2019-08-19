/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author miana
 */
public class conf extends HttpServlet {

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
    ResultSet rs2;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String user = request.getParameter("user");
            String s = "Accepted";
            String s1 = "Pending";
            String s2 = "Rejected";
            String s3 = "Revise"; 
            String s4 = "Registered";
            //out.print(email + "   " + pass );
            try{
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                st = con.createStatement();
                rs = st.executeQuery("SELECT * FROM paper");
               while(rs.next()) {

                if(user.equals(rs.getString("PAPERCODE")) && s.equals(rs.getString("STATUS"))){
                  
                    response.sendRedirect("confRegistration.jsp");
                }else if(user.equals(rs.getString("PAPERCODE")) && s1.equals(rs.getString("STATUS"))){
                 
                response.sendRedirect("ncprofile.jsp");
                }
                
                else if (user.equals(rs.getString("PAPERCODE")) && (s2.equals(rs.getString("STATUS")) || s3.equals(rs.getString("STATUS")) )){
                    try{
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                st = con.createStatement();
                     String sql = "DELETE FROM paper WHERE PAPERCODE='" + user + "'";
                     st.executeUpdate(sql);
                     response.sendRedirect("ncprofile1.jsp");
                     
                    }catch(Exception e){out.println(e);}
                }
                else if (user.equals(rs.getString("PAPERCODE")) && s4.equals(rs.getString("STATUS"))){
                
                response.sendRedirect("rcprofile.jsp");
                
                
                }
                
               }
            }catch(Exception e){
                out.println(e);
            }    
 //           out.println("Bahirrr main ahi");
//            response.sendRedirect("signup.html");  
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
