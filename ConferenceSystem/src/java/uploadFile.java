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
public class uploadFile extends HttpServlet {

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
                      
            String pin = request.getParameter("paperpin");
            String category = request.getParameter("category");
            String name = request.getParameter("name");
            String fname = request.getParameter("fileupload");
            String status = "Pending";
            
            //out.print(pin);
       
            
          
            
            
            try{
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                    st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    String status1 = "Pending";
                    
                    
                    rs = st.executeQuery("SELECT * FROM paper where PAPERCODE='"+pin+"'");
                    
                    if(!rs.next()){
                    
                        
                    rs.moveToInsertRow();                    
                    rs.updateString("PAPERCODE", pin); 
                    
                    rs.updateString("CATEGORY", category);
                    rs.updateString("PAPERNAME", fname);
                    rs.updateString("STATUS", status);
                    rs.updateString("NAME", name);
                    
                    
                    rs.insertRow();
                    
                    
                    response.sendRedirect("scprofile.jsp");
                   
                   
                   
                      
                     
                     
                     
                     
                     
                    
                    }
                    else{
                        
                       
                    }
                    
                    
                        
                }catch(Exception e){
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet loginServlet</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Data Base not working" + e + "</h1>");
                out.println("</body>");
                out.println("</html>");
            
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