/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Orders;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author GIANGND-SVMC
 */
@Stateless
public class OrdersFacade extends AbstractFacade<Orders> implements OrdersFacadeLocal {
    @PersistenceContext(unitName = "BookStoreD12-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public OrdersFacade() {
        super(Orders.class);
    }

    @Override
    public void updateStatusById(Object idorder, Object status) {
        // mau chot van de o day nhe
        em = Persistence.createEntityManagerFactory("BookStoreD12-ejbPU").createEntityManager();
        // chua khoi tao em
        javax.persistence.Query qr = em.createNamedQuery(Orders.class.getSimpleName() + ".updateStatusById");
        qr.setParameter("idorders", idorder);
        qr.setParameter("status", status);
        qr.executeUpdate();
    }
    
}
