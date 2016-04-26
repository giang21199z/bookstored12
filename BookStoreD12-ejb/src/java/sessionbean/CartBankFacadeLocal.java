/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.CartBank;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author GIANGND-SVMC
 */
@Local
public interface CartBankFacadeLocal {

    void create(CartBank cartBank);

    void edit(CartBank cartBank);

    void remove(CartBank cartBank);

    CartBank find(Object id);

    List<CartBank> findAll();

    List<CartBank> findRange(int[] range);

    int count();
    
}
