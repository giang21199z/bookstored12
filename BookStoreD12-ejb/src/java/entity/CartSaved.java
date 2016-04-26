/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author GIANGND-SVMC
 */
@Entity
@Table(name = "cart_saved")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CartSaved.findAll", query = "SELECT c FROM CartSaved c"),
    @NamedQuery(name = "CartSaved.findByIdcartSaved", query = "SELECT c FROM CartSaved c WHERE c.idcartSaved = :idcartSaved")})
public class CartSaved implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcart_saved")
    private Integer idcartSaved;
    @JoinColumn(name = "idperson", referencedColumnName = "idperson")
    @ManyToOne(optional = false)
    private CustomerMember idperson;
    @JoinColumn(name = "idcart", referencedColumnName = "idcart")
    @ManyToOne(optional = false)
    private Cart idcart;

    public CartSaved() {
    }

    public CartSaved(Integer idcartSaved) {
        this.idcartSaved = idcartSaved;
    }

    public Integer getIdcartSaved() {
        return idcartSaved;
    }

    public void setIdcartSaved(Integer idcartSaved) {
        this.idcartSaved = idcartSaved;
    }

    public CustomerMember getIdperson() {
        return idperson;
    }

    public void setIdperson(CustomerMember idperson) {
        this.idperson = idperson;
    }

    public Cart getIdcart() {
        return idcart;
    }

    public void setIdcart(Cart idcart) {
        this.idcart = idcart;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcartSaved != null ? idcartSaved.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartSaved)) {
            return false;
        }
        CartSaved other = (CartSaved) object;
        if ((this.idcartSaved == null && other.idcartSaved != null) || (this.idcartSaved != null && !this.idcartSaved.equals(other.idcartSaved))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CartSaved[ idcartSaved=" + idcartSaved + " ]";
    }
    
}
