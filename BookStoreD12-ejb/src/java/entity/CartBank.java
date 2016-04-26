/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author GIANGND-SVMC
 */
@Entity
@Table(name = "cart_bank")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CartBank.findAll", query = "SELECT c FROM CartBank c"),
    @NamedQuery(name = "CartBank.findByCarttype", query = "SELECT c FROM CartBank c WHERE c.carttype = :carttype"),
    @NamedQuery(name = "CartBank.findByNameowner", query = "SELECT c FROM CartBank c WHERE c.nameowner = :nameowner"),
    @NamedQuery(name = "CartBank.findByNumCart", query = "SELECT c FROM CartBank c WHERE c.numCart = :numCart"),
    @NamedQuery(name = "CartBank.findByIdbank", query = "SELECT c FROM CartBank c WHERE c.idbank = :idbank"),
    @NamedQuery(name = "CartBank.findByDatereissue", query = "SELECT c FROM CartBank c WHERE c.datereissue = :datereissue")})
public class CartBank implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "carttype")
    private Integer carttype;
    @Size(max = 45)
    @Column(name = "nameowner")
    private String nameowner;
    @Column(name = "num_cart")
    private Integer numCart;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idbank")
    private Integer idbank;
    @Column(name = "datereissue")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datereissue;
    @JoinColumn(name = "idbank", referencedColumnName = "idbank", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Bank bank;

    public CartBank() {
    }

    public CartBank(Integer idbank) {
        this.idbank = idbank;
    }

    public Integer getCarttype() {
        return carttype;
    }

    public void setCarttype(Integer carttype) {
        this.carttype = carttype;
    }

    public String getNameowner() {
        return nameowner;
    }

    public void setNameowner(String nameowner) {
        this.nameowner = nameowner;
    }

    public Integer getNumCart() {
        return numCart;
    }

    public void setNumCart(Integer numCart) {
        this.numCart = numCart;
    }

    public Integer getIdbank() {
        return idbank;
    }

    public void setIdbank(Integer idbank) {
        this.idbank = idbank;
    }

    public Date getDatereissue() {
        return datereissue;
    }

    public void setDatereissue(Date datereissue) {
        this.datereissue = datereissue;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
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
        if (!(object instanceof CartBank)) {
            return false;
        }
        CartBank other = (CartBank) object;
        if ((this.idbank == null && other.idbank != null) || (this.idbank != null && !this.idbank.equals(other.idbank))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CartBank[ idbank=" + idbank + " ]";
    }
    
}
