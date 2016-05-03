package singleton;

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

    private static GetId instance;

    private GetId() {
        super();
    }

    public static GetId getInstance() {
        if (instance == null) {
            instance = new GetId();
        }
        return instance;
    }

    public int getValueId() {
        int i = (int) new Date().getTime();
        return i > 0 ? i : i * -1;
    }
}
