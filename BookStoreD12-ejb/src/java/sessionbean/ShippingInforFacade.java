/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.ShippingInfor;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author GIANGND-SVMC
 */
@Stateless
public class ShippingInforFacade extends AbstractFacade<ShippingInfor> implements ShippingInforFacadeLocal {
    @PersistenceContext(unitName = "BookStoreD12-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ShippingInforFacade() {
        super(ShippingInfor.class);
    }
    
}
