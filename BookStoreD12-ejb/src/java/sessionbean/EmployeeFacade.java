/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Employee;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author GIANGND-SVMC
 */
@Stateless
public class EmployeeFacade extends AbstractFacade<Employee> implements EmployeeFacadeLocal {

    @PersistenceContext(unitName = "BookStoreD12-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmployeeFacade() {
        super(Employee.class);
    }

    @Override
    public boolean login(Object username, Object password) {
        // mau chot van de o day nhe
        em = Persistence.createEntityManagerFactory("BookStoreDemo-ejbPU").createEntityManager();
        // chua khoi tao em
        javax.persistence.Query qr = em.createNamedQuery(Employee.class.getSimpleName() + ".login");
        qr.setParameter("username", username);
        qr.setParameter("password", password);
        return qr.getResultList().size() > 0;
    }

}
