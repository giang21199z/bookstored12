package common;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public static int getValueId() {
        int i = (int) new Date().getTime();
        return i > 0 ? i : i * -1;
    }
}
