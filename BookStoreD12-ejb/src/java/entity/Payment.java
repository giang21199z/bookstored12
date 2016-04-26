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
@Table(name = "payment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p"),
    @NamedQuery(name = "Payment.findByIdpayment", query = "SELECT p FROM Payment p WHERE p.idpayment = :idpayment"),
    @NamedQuery(name = "Payment.findByType", query = "SELECT p FROM Payment p WHERE p.type = :type")})
public class Payment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpayment")
    private Integer idpayment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "type")
    private int type;
    @JoinColumn(name = "idcart", referencedColumnName = "idcart")
    @ManyToOne(optional = false)
    private Cart idcart;
    @JoinColumn(name = "idbank", referencedColumnName = "idbank")
    @ManyToOne(optional = false)
    private Bank idbank;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpayment")
    private List<Orders> ordersList;

    public Payment() {
    }

    public Payment(Integer idpayment) {
        this.idpayment = idpayment;
    }

    public Payment(Integer idpayment, int type) {
        this.idpayment = idpayment;
        this.type = type;
    }

    public Integer getIdpayment() {
        return idpayment;
    }

    public void setIdpayment(Integer idpayment) {
        this.idpayment = idpayment;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Cart getIdcart() {
        return idcart;
    }

    public void setIdcart(Cart idcart) {
        this.idcart = idcart;
    }

    public Bank getIdbank() {
        return idbank;
    }

    public void setIdbank(Bank idbank) {
        this.idbank = idbank;
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
        hash += (idpayment != null ? idpayment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.idpayment == null && other.idpayment != null) || (this.idpayment != null && !this.idpayment.equals(other.idpayment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Payment[ idpayment=" + idpayment + " ]";
    }
    
}
