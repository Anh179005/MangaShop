/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.AccountDAO;
import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Account;

/**
 *
 * @author ACER
 */
@WebServlet(name="RegisterServlet", urlPatterns={"/register"})
public class RegisterServlet extends HttpServlet {
    public boolean EmailChecker(String email){
        // Mẫu regex kiểm tra
        String regex = ".*@gmail\\.com$";

        // Tạo một đối tượng Pattern
        Pattern pattern = Pattern.compile(regex);

        // Sử dụng Matcher để so khớp địa chỉ email với regex
        Matcher matcher = pattern.matcher(email);
        
        if(matcher.matches()){
            return true;
        }
        
        return false;
    }
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String r_username=request.getParameter("r_username");
        String r_email=request.getParameter("r_email");
        String r_password=request.getParameter("r_password");
        String r_confirm_password=request.getParameter("r_confirm_password");
        String r_check=request.getParameter("r_check");
        AccountDAO dao=new AccountDAO();
        
        HttpSession session = request.getSession();
        
        if(dao.checkAccountByUsername(r_username) != null){
            request.setAttribute("error", "Username has existed !");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else if(dao.checkAccountByEmail(r_email) != null || EmailChecker(r_email) == false){
            request.setAttribute("error", "Email has existed or must have the format 'abc@gmail.com' !");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else if(!r_password.equals(r_confirm_password)){
            request.setAttribute("error", "Password and Confirm Password are different !");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else if(r_check==null || r_check.isEmpty()){
            request.setAttribute("error", "You must accept the Terms of Use & Privacy Policy !");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else {
            session.setAttribute("loggedIn", true);
            
//            session.setAttribute("acc", acc);
            dao.RegisterNewAccount(r_username, r_password, r_email);
            Account acc=dao.checkAccount(r_username, r_password);
            session.setAttribute("acc", acc);
            session.setAttribute("username", r_username);
            double budget= acc.getBudget();
            session.setAttribute("budget", budget);
            request.setAttribute("error", "Register Successful");
            response.sendRedirect("home");
        }
        
   
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
