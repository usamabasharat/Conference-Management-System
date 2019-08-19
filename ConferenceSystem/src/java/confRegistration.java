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
public class confRegistration extends HttpServlet {

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
                      
            //String name = request.getParameter("name");
            String username = request.getParameter("uname");
            //String mail = request.getParameter("email");
            String category = request.getParameter("category");
            String rating = request.getParameter("rating");
            String dob = request.getParameter("bday");
            String contact = request.getParameter("mbl");
            String ask = request.getParameter("ask");
            String add = request.getParameter("address");
            String city = request.getParameter("city");
            String country = request.getParameter("country");
            String status = "Registered";
            
            
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","");
                    st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    //rs = st.executeQuery("SELECT * FROM c_candidates where USERNAME='"+username+"'");
                    
                   String updt = "UPDATE candidate " +
                   "SET PAPERCATEGORY='"+category+"' WHERE USERNAME='"+username+"' ";
                   st.executeUpdate(updt);
                    
                  String updt1 = "UPDATE candidate " +
                   "SET PAPERRATING='"+rating+"' WHERE USERNAME='"+username+"' ";
                   st.executeUpdate(updt1);
                    
                  String updt2 = "UPDATE candidate " +
                   "SET DOB='"+dob+"' WHERE USERNAME='"+username+"' ";
                   st.executeUpdate(updt2);
                    
                  String updt3 = "UPDATE candidate " +
                   "SET MOBILE='"+contact+"' WHERE USERNAME='"+username+"' ";
                   st.executeUpdate(updt3);
                    
                  String updt4 = "UPDATE candidate " +
                   "SET ASK='"+ask+"' WHERE USERNAME='"+username+"' ";
                   st.executeUpdate(updt4);
                    
                  String updt5 = "UPDATE candidate " +
                   "SET ADDRESS='"+add+"' WHERE USERNAME='"+username+"' ";
                   st.executeUpdate(updt5);
                    
                  String updt6 = "UPDATE candidate " +
                   "SET CITY='"+city+"' WHERE USERNAME='"+username+"' ";
                   st.executeUpdate(updt6);
                    
                   String updt7 = "UPDATE candidate " +
                   "SET COUNTRY='"+country+"' WHERE USERNAME='"+username+"' ";
                   st.executeUpdate(updt7);
                   
                   
                   String updt8 = "UPDATE paper " +
                   "SET STATUS='"+status+"' WHERE PAPERCODE='"+username+"' ";
                   st.executeUpdate(updt8);
                   
                    
                   response.sendRedirect("rcprofile.jsp");
                  
                        
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