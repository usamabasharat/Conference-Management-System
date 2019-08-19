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

public class feedback extends HttpServlet {

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
                      
            String uname = request.getParameter("papercode");
            String ack = request.getParameter("ackg");
            String rating = request.getParameter("rating");
            String msg = request.getParameter("message");
            
            
           
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                    st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    String s = "usama.basharat";
                    
                    String updt = "UPDATE paper " +
                   "SET STATUS='"+ack+"' WHERE PAPERCODE='"+uname+"' ";
                   
                    
                    st.executeUpdate(updt);
                 String updt1 = "UPDATE paper " +
                   "SET RATING='"+rating+"' WHERE PAPERCODE='"+uname+"' ";
                   
                    
                    st.executeUpdate(updt1);
                     String updt2 = "UPDATE paper " +
                   "SET MESSAGE='"+msg+"' WHERE PAPERCODE='"+uname+"' ";
                   
                    
                    st.executeUpdate(updt2);
                    
                   
                    
                    
                  // String sql = "DELETE FROM paper WHERE STATUS='" + s + "'";
                    // st.executeUpdate(sql);
                  
                    response.sendRedirect("rprofile.jsp");
                   /*
                    rs = st.executeQuery("SELECT * FROM paper where PAPERCODE='"+username+"'");
                    
                    if(!rs.next()){
                   out.println(name);
                      
                    rs.moveToInsertRow();                    
                    rs.updateString("PAPERCODE", username);                
                    rs.updateString("STATUS", ack);
                    rs.updateString("RATING", rating);
                    rs.updateString("MESSAGE", msg);
                    rs.updateString("NAME", name);
                    rs.updateString("PAPERNAME", pname);
                    rs.updateString("CATEGORY", cat);
                    rs.insertRow();
                    
                    
                  
                   
                    
                    
                   
                   
                   
                    response.sendRedirect("rprofile.jsp");
                        
                    
                    }
                    else{
                        //response.sendRedirect("rprofile.jsp");
                        out.print("else1");
                    }
                    
                     */
                        
                }catch(Exception e){
                   // response.sendRedirect("nsignup.html");
                    out.print(e);

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