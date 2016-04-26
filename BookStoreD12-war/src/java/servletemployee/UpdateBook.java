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
import sessionbean.BookFacadeLocal;
import sessionbean.BookSetFacadeLocal;
import sessionbean.CategoryFacadeLocal;

/**
 *
 * @author GIANGND-SVMC
 */
public class UpdateBook extends HttpServlet {
    
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
            String type = request.getParameter("type");
            if (type.equals("edit")) {
                Book book = bookFacade.find(Integer.parseInt(idbook));
                bookFacade.remove(book);
                request.setAttribute(GetId.EDIT_BOOK, book);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editbook.jsp");
                dispatcher.forward(request, response);
            }
            if (type.equals("del")) {
                Book book = bookFacade.find(Integer.parseInt(idbook));
                bookFacade.remove(book);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/GetAllBook");
                dispatcher.forward(request, response);
            }
            if(type.equals("updatebook")){
                String idcategory = request.getParameter("category");
                Category category = new Category(Integer.parseInt(idcategory));
                
                
                String idbookset = request.getParameter("bookset");
                BookSet bookset = new BookSet(Integer.parseInt(idbookset));
                
                String title = request.getParameter("title");
                String author = request.getParameter("author");
                String publisher = request.getParameter("publisher");
                Date publisheryear = new Date(Integer.parseInt(request.getParameter("publisheryear")),0,0);
                String description = request.getParameter("description");
                Float originalprice = Float.parseFloat(request.getParameter("originalprice"));
                Float saleprice = Float.parseFloat(request.getParameter("saleprice"));
                Integer quantity = Integer.parseInt(request.getParameter("quantity"));
                
                Book book = new Book();
                book.setAuthor(author);
                book.setDescription(description);
                book.setIdbook(Integer.parseInt(idbook));
                book.setIdbookset(bookset);
                book.setIdcategory(category);
                book.setOriginalPrice(originalprice);
                book.setSalePrice(saleprice);
                book.setQuantity(quantity);
                book.setPublisher(publisher);
                book.setPublisherYear(publisheryear);
                book.setTitle(title);
                bookFacade.edit(book);
                
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/GetAllBook");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();

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
