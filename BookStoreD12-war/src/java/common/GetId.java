/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.util.Date;

/**
 *
 * @author GIANGND-SVMC
 */
public class GetId {

    public static String SESSION_USER = "CUSTOMERMEMBER";
    public static String SESSION_ADMIN = "ADMIN";
    public static String REQUEST_REGISTER = "REGISTER";
    public static String DETAIL_BOOK = "DETAILBOOK";
    public static String LOGIN = "LOGIN";
    public static String ADD_BOOK = "ADD_BOOK";
    public static String GET_ALL_BOOK = "GET_ALL_BOOK";
    public static String EDIT_BOOK = "EDIT_BOOK";
    public static String CART = "CART";
    public static String MESSAGE_ORDER = "MESSAGE_ORDER";
    public static String MESSAGE_PAYMENT_LOGIN = "MESSAGE_PAYMENT_LOGIN";
    public static int ID_BANK = 868686;
    public static String GET_ALL_ORDER = "GET_ALL_ORDER";
    public static String GET_DETAIL_CART = "GET_DETAIL_CART";
    public static String GET_DETAIL_PERSON = "GET_DETAIL_PERSON";
    public static String GET_DETAIL_ORDER = "GET_DETAIL_ORDER";
    public static String GET_LIST_ACCOUNT = "GET_LIST_ACCOUNT";
    public static String RESULT_SEARCH_BOOK = "RESULT_SEARCH_BOOK";
    public static String GET_EMPLOYEE = "GET_EMPLOYEE";
    public static int getValueId() {
        int i = (int) new Date().getTime();
        return i > 0 ? i : i * -1;
    }
}
