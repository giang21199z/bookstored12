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
@Table(name = "cart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cart.findAll", query = "SELECT c FROM Cart c"),
    @NamedQuery(name = "Cart.findByIdcart", query = "SELECT c FROM Cart c WHERE c.idcart = :idcart")})
public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcart")
    private Integer idcart;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcart")
    private List<Payment> paymentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcart")
    private List<CartSaved> cartSavedList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcart")
    private List<BookOrder> bookOrderList;

    public Cart() {
    }

    public Cart(Integer idcart) {
        this.idcart = idcart;
    }

    public Integer getIdcart() {
        return idcart;
    }

    public void setIdcart(Integer idcart) {
        this.idcart = idcart;
    }

    @XmlTransient
    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    @XmlTransient
    public List<CartSaved> getCartSavedList() {
        return cartSavedList;
    }

    public void setCartSavedList(List<CartSaved> cartSavedList) {
        this.cartSavedList = cartSavedList;
    }

    @XmlTransient
    public List<BookOrder> getBookOrderList() {
        return bookOrderList;
    }

    public void setBookOrderList(List<BookOrder> bookOrderList) {
        this.bookOrderList = bookOrderList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcart != null ? idcart.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cart)) {
            return false;
        }
        Cart other = (Cart) object;
        if ((this.idcart == null && other.idcart != null) || (this.idcart != null && !this.idcart.equals(other.idcart))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Cart[ idcart=" + idcart + " ]";
    }
    
}
