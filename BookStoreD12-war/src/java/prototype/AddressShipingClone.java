/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototype;

import entity.Address;

/**
 *
 * @author GIANGND-SVMC
 */
public class AddressShipingClone implements PrototypeObject {

    Address address;
    

    public AddressShipingClone(Address address) {
        this.address = address;
    }

    @Override
    public Object cloneObject() {
        return address;
    }

}
