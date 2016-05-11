/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import entity.Employee;
import entity.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import sessionbean.EmployeeFacadeLocal;
import sessionbean.PersonFacadeLocal;

/**
 *
 * @author GIANGND-SVMC
 */
public class SearchEmployee implements SearchInterface {

    PersonFacadeLocal personFacade = lookupPersonFacadeLocal();
    EmployeeFacadeLocal employeeFacade = lookupEmployeeFacadeLocal();

    @Override
    public List search(String keyword) {
        List<Employee> arrEmployee = employeeFacade.findAll();
        List<Employee> result = new ArrayList<Employee>();
        for (Employee e : arrEmployee) {
            Integer idPerson = e.getIdperson();
            Person p = personFacade.find(idPerson);
            if (p.getIdfullname().getFirstname().toLowerCase().contains(keyword) || p.getIdfullname().getMidname().toLowerCase().contains(keyword) || p.getIdfullname().getLastname().toLowerCase().contains(keyword)) {
                result.add(e);
            }
        }
        return result;
    }

    private EmployeeFacadeLocal lookupEmployeeFacadeLocal() {
        try {
            InitialContext ctx = new InitialContext();
            return (EmployeeFacadeLocal) ctx.lookup("java:comp/env/EmployeeFacade");
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
