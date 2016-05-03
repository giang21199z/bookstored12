/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.payment;

import common.GetId;
import entity.Address;
import entity.Bank;
import entity.Cart;
import entity.Customer;
import entity.CustomerMember;
import entity.Orders;
import entity.Payment;
import entity.Person;
import entity.ShippingInfor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sessionbean.OrdersFacadeLocal;
import sessionbean.PaymentFacadeLocal;
import sessionbean.PersonFacadeLocal;
import sessionbean.ShippingInforFacadeLocal;

/**
 *
 * @author GIANGND-SVMC
 */
public class ServletPayment extends HttpServlet {
    @EJB
    private OrdersFacadeLocal ordersFacade;
    @EJB
    private ShippingInforFacadeLocal shippingInforFacade;
    @EJB
    private PaymentFacadeLocal paymentFacade;

    @EJB
    private PersonFacadeLocal personFacade;

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
            HttpSession session = request.getSession();
            CustomerMember cm = (CustomerMember) session.getAttribute(GetId.SESSION_USER);
            if (cm == null) {
                request.setAttribute(GetId.MESSAGE_PAYMENT_LOGIN, "Trước khi thanh toán bạn phải đăng nhập");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
                dispatcher.forward(request, response);
            } else {
                //Da login kiem tra xem tai khoan da co so tai khoan ngan hang chua
                Payment payment = new Payment(GetId.getValueId());
                payment.setIdbank(new Bank(GetId.ID_BANK));
                Cart cart = (Cart) session.getAttribute(GetId.CART);
                payment.setIdcart(cart);
                payment.setType(1);
                //them payment
                paymentFacade.create(payment);

                Person person = personFacade.find(cm.getIdperson());
                Address address = person.getIdaddress();
                //tao shippinginfor
                int idShipping = GetId.getValueId();
                ShippingInfor shippingInfor = new ShippingInfor(idShipping);
                shippingInfor.setIdshippingInfor(GetId.getValueId());
                Customer customer = cm.getCustomer();
                shippingInfor.setCustomerIdperson(customer);
                shippingInfor.setIdaddressShipping(address);
                //them shipinginfor
                shippingInforFacade.create(shippingInfor);

                //end get thong tin dia diem chuyen hang
                Orders orders = new Orders(idShipping);
                java.util.Date utilDate = new java.util.Date();
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                orders.setDate(utilDate);
                orders.setIdpayment(payment);
                orders.setIdshippingInfor(shippingInfor);

                Context context = new Context();
                UnconfirmOrder unconfirmOrder = new UnconfirmOrder();
                String status = unconfirmOrder.doUpdateState(context);
                orders.setStatus(status);
                //them order
                ordersFacade.create(orders);
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ordersuccess.jsp");
                dispatcher.forward(request, response);
            }
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
