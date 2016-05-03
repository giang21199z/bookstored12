/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adapter;

import entity.Orders;

/**
 *
 * @author GIANGND-SVMC
 */
public class DisplayStatusAdapter implements DisplayStatusTarget {

    @Override
    public String showStatusOrder(Orders orders) {
        String status = orders.getStatus();
        switch (status) {
            case "Unconfirm":
                return "<span class=\"label label-inverse\">Unconfirm</span>";
            case "Confirm":
                return "<span class=\"label label-warning\">Confirm</span>";
            case "Cancel":
                return "<span class=\"label label-important\">Cancel</span>";
            case "Delivering":
                return "<span class=\"label label-info\">Delivering</span>";
        }
        return "<span class=\"label label-success\">Paid</span>";
    }

}
