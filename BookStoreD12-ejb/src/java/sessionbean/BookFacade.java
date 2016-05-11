/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author GIANGND-SVMC
 */
@Stateless
public class BookFacade extends AbstractFacade<Book> implements BookFacadeLocal {

    @PersistenceContext(unitName = "BookStoreD12-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BookFacade() {
        super(Book.class);
    }

    @Override
    public List<Book> search(Object keyword) {
        // mau chot van de o day nhe
        em = Persistence.createEntityManagerFactory("BookStoreD12-ejbPU").createEntityManager();
        // chua khoi tao em
        javax.persistence.Query qr = em.createNamedQuery(Book.class.getSimpleName() + ".search");
        qr.setParameter("title", "%" + keyword + "%");
        return (List<Book>) qr.getResultList();
    }

    @Override
    public List<Book> recommendBySalePriceAsc() {
        // mau chot van de o day nhe
        em = Persistence.createEntityManagerFactory("BookStoreD12-ejbPU").createEntityManager();
        // chua khoi tao em
        javax.persistence.Query qr = em.createNamedQuery(Book.class.getSimpleName() + ".recommendBySalePriceAsc");
        return (List<Book>) qr.getResultList();
    }

    @Override
    public List<Book> recommendBySalePriceDesc() {
        // mau chot van de o day nhe
        em = Persistence.createEntityManagerFactory("BookStoreD12-ejbPU").createEntityManager();
        // chua khoi tao em
        javax.persistence.Query qr = em.createNamedQuery(Book.class.getSimpleName() + ".recommendBySalePriceDesc");
        return (List<Book>) qr.getResultList();
    }

    @Override
    public List<Book> recommendByQuantityAsc() {
        // mau chot van de o day nhe
        em = Persistence.createEntityManagerFactory("BookStoreD12-ejbPU").createEntityManager();
        // chua khoi tao em
        javax.persistence.Query qr = em.createNamedQuery(Book.class.getSimpleName() + ".recommendByQuantityAsc");
        return (List<Book>) qr.getResultList();
    }

    @Override
    public List<Book> recommendByQuantityDesc() {
        // mau chot van de o day nhe
        em = Persistence.createEntityManagerFactory("BookStoreD12-ejbPU").createEntityManager();
        // chua khoi tao em
        javax.persistence.Query qr = em.createNamedQuery(Book.class.getSimpleName() + ".recommendByQuantityDesc");
        return (List<Book>) qr.getResultList();
    }

    
}
