/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.CustomerMember;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author GIANGND-SVMC
 */
@Stateless
public class CustomerMemberFacade extends AbstractFacade<CustomerMember> implements CustomerMemberFacadeLocal {

    @PersistenceContext(unitName = "BookStoreD12-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerMemberFacade() {
        super(CustomerMember.class);
    }

    @Override
    public CustomerMember login(Object username, Object password) {
        // mau chot van de o day nhe
        em = Persistence.createEntityManagerFactory("BookStoreD12-ejbPU").createEntityManager();
        // chua khoi tao em
        javax.persistence.Query qr = em.createNamedQuery(CustomerMember.class.getSimpleName() + ".login");
        qr.setParameter("username", username);
        qr.setParameter("password", password);
        return (CustomerMember) qr.getSingleResult();
    }
}
