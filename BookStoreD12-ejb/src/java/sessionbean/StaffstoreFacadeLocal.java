/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Staffstore;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author GIANGND-SVMC
 */
@Local
public interface StaffstoreFacadeLocal {

    void create(Staffstore staffstore);

    void edit(Staffstore staffstore);

    void remove(Staffstore staffstore);

    Staffstore find(Object id);

    List<Staffstore> findAll();

    List<Staffstore> findRange(int[] range);

    int count();
    
}
