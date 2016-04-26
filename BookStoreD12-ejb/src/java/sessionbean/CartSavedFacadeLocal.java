/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.CartSaved;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author GIANGND-SVMC
 */
@Local
public interface CartSavedFacadeLocal {

    void create(CartSaved cartSaved);

    void edit(CartSaved cartSaved);

    void remove(CartSaved cartSaved);

    CartSaved find(Object id);

    List<CartSaved> findAll();

    List<CartSaved> findRange(int[] range);

    int count();
    
}
