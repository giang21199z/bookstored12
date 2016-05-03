/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionbean;

import entity.CustomerMember;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author GIANGND-SVMC
 */
@Local
public interface CustomerMemberFacadeLocal {

    void create(CustomerMember customerMember);

    void edit(CustomerMember customerMember);

    void remove(CustomerMember customerMember);

    CustomerMember find(Object id);

    List<CustomerMember> findAll();

    List<CustomerMember> findRange(int[] range);

    int count();

    CustomerMember login(Object username, Object password);
}
