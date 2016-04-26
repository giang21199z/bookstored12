/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.Staffmanager;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author GIANGND-SVMC
 */
@Local
public interface StaffmanagerFacadeLocal {

    void create(Staffmanager staffmanager);

    void edit(Staffmanager staffmanager);

    void remove(Staffmanager staffmanager);

    Staffmanager find(Object id);

    List<Staffmanager> findAll();

    List<Staffmanager> findRange(int[] range);

    int count();
    
}
