/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import entity.CustomerMember;
import entity.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import sessionbean.CustomerMemberFacadeLocal;
import sessionbean.PersonFacadeLocal;

/**
 *
 * @author GIANGND-SVMC
 */
public class SearchCustomer implements SearchInterface {

    PersonFacadeLocal personFacade = lookupPersonFacadeLocal();
    CustomerMemberFacadeLocal customerMemberFacade = lookupCustomerMemberFacadeLocal();

    @Override
    public List search(String keyword) {
        List<CustomerMember> arrCustomerMember = customerMemberFacade.findAll();
        List<CustomerMember> result = new ArrayList<CustomerMember>();
        for (CustomerMember cm : arrCustomerMember) {
            Integer idPerson = cm.getIdperson();
            Person p = personFacade.find(idPerson);
            if (p.getIdfullname().getFirstname().toLowerCase().contains(keyword) || p.getIdfullname().getMidname().toLowerCase().contains(keyword) || p.getIdfullname().getLastname().toLowerCase().contains(keyword)) {
                result.add(cm);
            }
        }
        return result;
    }

    private CustomerMemberFacadeLocal lookupCustomerMemberFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (CustomerMemberFacadeLocal) c.lookup("java:comp/env/CustomerMemberFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private PersonFacadeLocal lookupPersonFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (PersonFacadeLocal) c.lookup("java:comp/env/PersonFacade");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
