/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletemployee;

import common.GetId;
import entity.Book;
import entity.BookSet;
import entity.Category;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sessionbean.BookFacade;
import sessionbean.BookFacadeLocal;

/**
 *
 * @author GIANGND-SVMC
 */
public class AddBook extends HttpServlet {

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
            String category = request.getParameter("category");
            String bookset = request.getParameter("bookset");
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            String publisher = request.getParameter("publisher");
            String publisheryear = request.getParameter("publisheryear");
            String description = request.getParameter("description");
            String originalprice = request.getParameter("originalprice");
            String saleprice = request.getParameter("saleprice");
            String quantity = request.getParameter("quantity");

            Book book = new Book();
            Category idCategory = new Category(Integer.parseInt(category));
            book.setIdcategory(idCategory);
            book.setAuthor(author);

            BookSet bookSet = new BookSet(Integer.parseInt(bookset));
            book.setIdbookset(bookSet);
            book.setIdbook(GetId.getValueId());
            book.setTitle(title);
            book.setAuthor(author);
            book.setPublisher(publisher);
            book.setImage("default.jpg");
            book.setPublisherYear(new Date(Integer.parseInt(publisheryear), 0, 0));
            book.setDescription(description);

            book.setOriginalPrice(Float.parseFloat(originalprice));
            book.setSalePrice(Float.parseFloat(saleprice));
            book.setQuantity(Integer.parseInt(quantity));

            bookFacade.create(book);
            request.setAttribute(GetId.ADD_BOOK, true);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addbook.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute(GetId.ADD_BOOK, false);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/addbook.jsp");
            dispatcher.forward(request, response);
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
