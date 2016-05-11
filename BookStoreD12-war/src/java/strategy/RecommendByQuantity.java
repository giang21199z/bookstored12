/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

import entity.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import sessionbean.BookFacadeLocal;

/**
 *
 * @author GIANGND-SVMC
 */
public class RecommendByQuantity implements RecommendInterface {
    BookFacadeLocal bookFacade = lookupBookFacadeLocal();

    @Override
    public List suggest() {
        return bookFacade.recommendByQuantityDesc();
    }

    private BookFacadeLocal lookupBookFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (BookFacadeLocal) c.lookup("java:comp/env/BookFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
