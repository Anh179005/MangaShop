/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.cart;

import dal.DAO;
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
@WebServlet(name = "ProcessServlet", urlPatterns = {"/process"})
public class ProcessServlet extends HttpServlet {

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
            out.println("<title>Servlet ProcessServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProcessServlet at " + request.getContextPath() + "</h1>");
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
            
            Another_Cart a_cart = null;
            Object o = session.getAttribute("a_cart");
            if (o != null) {
                a_cart = (Another_Cart) o;
            } else {
                a_cart = new Another_Cart();
            }
            String id_raw= request.getParameter("id");
            int id = Integer.parseInt(request.getParameter("id"));
            int num = Integer.parseInt(request.getParameter("num").trim());
            if ((num == -1) && (a_cart.getSo_LuongById(id) <= 1)) {
                a_cart.removeItem(id);
            } else {
                DAO dao = new DAO();
                Manga m = dao.getMangaById(id_raw);
                double price = m.getPrice();
                Item t = new Item(m, num, price);
                a_cart.addItem(t);

            }
            ArrayList<Item> list = a_cart.getItems();
            session.setAttribute("a_cart", a_cart);
            session.setAttribute("size", list.size());
            response.sendRedirect("cart");

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
        HttpSession session = request.getSession();
        boolean loggedIn = session.getAttribute("loggedIn") != null && (boolean) session.getAttribute("loggedIn");
        if (!loggedIn) {
            // Nếu chưa đăng nhập, chuyển hướng đến trang "access denied"
            response.sendRedirect("login");
        } else {
            Another_Cart a_cart = null;
            Object o = session.getAttribute("a_cart");
            if (o != null) {
                a_cart = (Another_Cart) o;
            } else {
                a_cart = new Another_Cart();
            }
            int id = Integer.parseInt(request.getParameter("id"));
            a_cart.removeItem(id);
            ArrayList<Item> list = a_cart.getItems();
            session.setAttribute("a_cart", a_cart);
            session.setAttribute("size", list.size());
//            request.getRequestDispatcher("shopcart.jsp").forward(request, response);
            response.sendRedirect("cart");
        }
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
