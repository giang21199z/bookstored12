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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author GIANGND-SVMC
 */
@Entity
@Table(name = "bank")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bank.findAll", query = "SELECT b FROM Bank b"),
    @NamedQuery(name = "Bank.findByIdbank", query = "SELECT b FROM Bank b WHERE b.idbank = :idbank"),
    @NamedQuery(name = "Bank.findByBalance", query = "SELECT b FROM Bank b WHERE b.balance = :balance"),
    @NamedQuery(name = "Bank.findByPart", query = "SELECT b FROM Bank b WHERE b.part = :part")})
public class Bank implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idbank")
    private Integer idbank;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "balance")
    private Float balance;
    @Size(max = 45)
    @Column(name = "part")
    private String part;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idbank")
    private List<Payment> paymentList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bank")
    private CartBank cartBank;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "bank")
    private KcoinBank kcoinBank;

    public Bank() {
    }

    public Bank(Integer idbank) {
        this.idbank = idbank;
    }

    public Integer getIdbank() {
        return idbank;
    }

    public void setIdbank(Integer idbank) {
        this.idbank = idbank;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

    @XmlTransient
    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public CartBank getCartBank() {
        return cartBank;
    }

    public void setCartBank(CartBank cartBank) {
        this.cartBank = cartBank;
    }

    public KcoinBank getKcoinBank() {
        return kcoinBank;
    }

    public void setKcoinBank(KcoinBank kcoinBank) {
        this.kcoinBank = kcoinBank;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbank != null ? idbank.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bank)) {
            return false;
        }
        Bank other = (Bank) object;
        if ((this.idbank == null && other.idbank != null) || (this.idbank != null && !this.idbank.equals(other.idbank))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Bank[ idbank=" + idbank + " ]";
    }
    
}
