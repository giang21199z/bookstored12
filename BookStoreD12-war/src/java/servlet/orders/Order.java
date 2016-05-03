/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.orders;

import common.GetId;
import entity.Book;
import entity.BookOrder;
import entity.Cart;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbean.BookFacadeLocal;
import sessionbean.BookOrderFacadeLocal;
import sessionbean.CartFacadeLocal;

/**
 *
 * @author GIANGND-SVMC
 */
public class Order extends HttpServlet {
    @EJB
    private CartFacadeLocal cartFacade;
    @EJB
    private BookOrderFacadeLocal bookOrderFacade;
    @EJB
    private BookFacadeLocal bookFacade;

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String idbook = request.getParameter("idbook");
            String quantity = request.getParameter("quantity");
            String title = request.getParameter("titlebook");
            HttpSession session = request.getSession(true);
            Cart cart = (Cart) session.getAttribute(GetId.CART);
            
            if (cart == null) {
                //create cart
                //tao session luu trang thai gio hang
                int idCart = GetId.getValueId();
                cart = new Cart();
                cart.setIdcart(idCart);
                //add cart
                cartFacade.create(cart);
            }
            int idBookOrder = GetId.getValueId();
            Book book = (Book) bookFacade.find(Integer.parseInt(idbook));
            BookOrder bookOrder = new BookOrder();
            bookOrder.setIdbookOrder(idBookOrder);
            bookOrder.setQuantity(Integer.parseInt(quantity));
            bookOrder.setIdbook(book);
            bookOrder.setIdcart(cart);
            //them book order vao csdl
            bookOrderFacade.create(bookOrder);
            if(cart.getBookOrderList() == null){
                cart.setBookOrderList(new ArrayList<BookOrder>());
            }
            
            cart.getBookOrderList().add(bookOrder);
//            //end set session
            session.setAttribute("CART", cart);
            
            RequestDispatcher dis = getServletContext().getRequestDispatcher("/DetailBook?id="+idbook+"&quantity="+quantity);
            dis.forward(request, response);
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
