/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.payment;

/**
 *
 * @author GIANGND-SVMC
 */
public class PaidOrder implements OrderState{

    @Override
    public String doUpdateState(Context context) {
        return "Paid";
    }
    
}
