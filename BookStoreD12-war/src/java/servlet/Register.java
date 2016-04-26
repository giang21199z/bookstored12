/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import common.GetId;
import entity.Address;
import entity.Bank;
import entity.Customer;
import entity.CustomerMember;
import entity.Fullname;
import entity.KcoinBank;
import entity.Person;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbean.AddressFacadeLocal;
import sessionbean.BankFacadeLocal;
import sessionbean.CustomerFacade;
import sessionbean.CustomerFacadeLocal;
import sessionbean.CustomerMemberFacadeLocal;
import sessionbean.FullnameFacadeLocal;
import sessionbean.KcoinBankFacadeLocal;
import sessionbean.PersonFacadeLocal;

/**
 *
 * @author GIANGND-SVMC
 */
public class Register extends HttpServlet {

    @EJB
    private CustomerMemberFacadeLocal customerMemberFacade;
    @EJB
    private CustomerFacadeLocal customerFacade;
    @EJB
    private PersonFacadeLocal personFacade;
    @EJB
    private KcoinBankFacadeLocal kcoinBankFacade;
    @EJB
    private BankFacadeLocal bankFacade;
    @EJB
    private AddressFacadeLocal addressFacade;
    @EJB
    private FullnameFacadeLocal fullnameFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String fullname = request.getParameter("fullname");
            String fname = null;
            String mname = null;
            String lname = null;
            String num = request.getParameter("num");
            String ward = request.getParameter("ward");
            String dictrict = request.getParameter("dictric");
            String city = request.getParameter("city");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");

            int i = fullname.indexOf(" ");
            fname = fullname.substring(0, i);
            int k = fullname.lastIndexOf(" ");
            lname = fullname.substring(k + 1);
            mname = fullname.substring(i + 1, k);

            int id = GetId.getValueId();
            Fullname fn = new Fullname();
            //1
            fullnameFacade.create(fn);

            Address address = new Address();
            address.setIdaddress(id);
            address.setCity(city);
            address.setDictric(dictrict);
            address.setNum(num);
            address.setWard(ward);
            //2
            addressFacade.create(address);

            Person person = new Person();
            person.setIdaddress(address);
            person.setIdfullname(fn);
            person.setIdperson(id);
            person.setPart("Customer");
            //3
            personFacade.create(person);

            Customer customer = new Customer();
            customer.setEmail(email);
            customer.setIdperson(id);
            customer.setIdperson(id);
            //4
            customerFacade.create(customer);

            Bank bank = new Bank();
            bank.setIdbank(id);
            bank.setBalance(new Float(0));
            bank.setPart("Store");
            //5
            bankFacade.create(bank);

            KcoinBank kcoinBank = new KcoinBank();
            kcoinBank.setIdbank(id);
            kcoinBank.setBank(bank);
            //5
            kcoinBankFacade.create(kcoinBank);

            CustomerMember cm = new CustomerMember();
            cm.setIdperson(id);
            cm.setUsername(username);
            cm.setPassword(password);
            cm.setIdbank(kcoinBank);
            //6
            customerMemberFacade.create(cm);

            request.setAttribute(GetId.REQUEST_REGISTER, true);
            HttpSession sessson = request.getSession();
            sessson.setAttribute(GetId.SESSION_USER, cm);
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/success.jsp");
            dispatcher.forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
