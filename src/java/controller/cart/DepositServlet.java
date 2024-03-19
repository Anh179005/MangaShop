/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.cart;

import dal.AccountDAO;
import dal.cartDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
import model.Another_Cart;

/**
 *
 * @author ACER
 */
@WebServlet(name="DepositServlet", urlPatterns={"/deposit"})
public class DepositServlet extends HttpServlet {
   
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
            out.println("<title>Servlet DepositServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DepositServlet at " + request.getContextPath () + "</h1>");
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
            processRequest(request, response);
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
        HttpSession session = request.getSession();
        boolean loggedIn = session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn");
        if (!loggedIn) {
            // Nếu chưa đăng nhập, chuyển hướng đến trang "access denied"
            response.sendRedirect("login");
        } else {  
            String incAmount_raw=request.getParameter("incAmount");
            double incAmount=Double.parseDouble(incAmount_raw);
            if(incAmount <0 ){
                request.setAttribute("error", "Bạn cần nạp nhiều hơn ");
                request.getRequestDispatcher("deposit.jsp").forward(request, response);
            } else if(incAmount % 5000 != 0 ){
                request.setAttribute("error", "Vui lòng nhập số là bội số của 5,000.");
                request.getRequestDispatcher("deposit.jsp").forward(request, response);                 
            }else{
                Account acc = (Account) session.getAttribute("acc");
                AccountDAO A= new AccountDAO();
            
                A.updateBudgetById(incAmount, acc.getId());
            session.setAttribute("budget", acc.getBudget());
//            request.getRequestDispatcher("shopcart.jsp").forward(request, response);
            response.sendRedirect("cart");
            }
            

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
