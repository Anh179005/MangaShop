/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.cart;

import dal.DAO;
import dal.cartDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.Another_Cart;
import model.Item;
import model.Manga;

/**
 *
 * @author ACER
 */
@WebServlet(name = "AddNewCartServlet", urlPatterns = {"/addnewcart"})
public class AddNewCartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddNewCartServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddNewCartServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        HttpSession session = request.getSession();
        boolean loggedIn = session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn");
        if (!loggedIn) {
            // Nếu chưa đăng nhập, chuyển hướng đến trang "access denied"
            response.sendRedirect("login");
        } else {
            Another_Cart a_cart= null;
            Object o= session.getAttribute("a_cart");
            if(o!=null){
                a_cart=(Another_Cart) o;
            }else{
                a_cart=new Another_Cart();
            }
            
            
            String id_raw = request.getParameter("id");           
            int id = Integer.parseInt(id_raw);
            int num=1;
            
            cartDAO cart = new cartDAO();
            DAO dao=new DAO();
            Manga m= dao.getMangaById(id_raw);
            double price= m.getPrice();
            Item t=new Item(m,num,price);
            a_cart.addItem(t);
            ArrayList<Item> list=a_cart.getItems();
            session.setAttribute("a_cart", a_cart);
            session.setAttribute("size", list.size());
            
            
            
//            Account acc = (Account) request.getAttribute("acc");
//            Bill bill = cart.getNewestBill();
//            cart.addNewMangaIntoCart(bill.getBill_id(), id);
            
            
//        HttpSession session = request.getSession();
//        Account acc= (Account) session.getAttribute("acc");
//        session.setAttribute("loggedIn", true);
//        session.setAttribute("acc", acc);
            response.sendRedirect("home");
        }
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
