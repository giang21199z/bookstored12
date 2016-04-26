/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.CustomerNotMember;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author GIANGND-SVMC
 */
@Local
public interface CustomerNotMemberFacadeLocal {

    void create(CustomerNotMember customerNotMember);

    void edit(CustomerNotMember customerNotMember);

    void remove(CustomerNotMember customerNotMember);

    CustomerNotMember find(Object id);

    List<CustomerNotMember> findAll();

    List<CustomerNotMember> findRange(int[] range);

    int count();
    
}
