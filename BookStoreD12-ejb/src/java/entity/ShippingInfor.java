/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author GIANGND-SVMC
 */
@Entity
@Table(name = "shipping_infor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShippingInfor.findAll", query = "SELECT s FROM ShippingInfor s"),
    @NamedQuery(name = "ShippingInfor.findByIdshippingInfor", query = "SELECT s FROM ShippingInfor s WHERE s.idshippingInfor = :idshippingInfor")})
public class ShippingInfor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idshipping_infor")
    private Integer idshippingInfor;
    @JoinColumn(name = "idaddress_shipping", referencedColumnName = "idaddress")
    @ManyToOne(optional = false)
    private Address idaddressShipping;
    @JoinColumn(name = "customer_idperson", referencedColumnName = "idperson")
    @ManyToOne(optional = false)
    private Customer customerIdperson;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idshippingInfor")
    private List<Orders> ordersList;

    public ShippingInfor() {
    }

    public ShippingInfor(Integer idshippingInfor) {
        this.idshippingInfor = idshippingInfor;
    }

    public Integer getIdshippingInfor() {
        return idshippingInfor;
    }

    public void setIdshippingInfor(Integer idshippingInfor) {
        this.idshippingInfor = idshippingInfor;
    }

    public Address getIdaddressShipping() {
        return idaddressShipping;
    }

    public void setIdaddressShipping(Address idaddressShipping) {
        this.idaddressShipping = idaddressShipping;
    }

    public Customer getCustomerIdperson() {
        return customerIdperson;
    }

    public void setCustomerIdperson(Customer customerIdperson) {
        this.customerIdperson = customerIdperson;
    }

    @XmlTransient
    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idshippingInfor != null ? idshippingInfor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShippingInfor)) {
            return false;
        }
        ShippingInfor other = (ShippingInfor) object;
        if ((this.idshippingInfor == null && other.idshippingInfor != null) || (this.idshippingInfor != null && !this.idshippingInfor.equals(other.idshippingInfor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ShippingInfor[ idshippingInfor=" + idshippingInfor + " ]";
    }
    
}
