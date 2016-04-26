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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author GIANGND-SVMC
 */
@Entity
@Table(name = "bill")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bill.findAll", query = "SELECT b FROM Bill b"),
    @NamedQuery(name = "Bill.findByIdbill", query = "SELECT b FROM Bill b WHERE b.idbill = :idbill"),
    @NamedQuery(name = "Bill.findByDate", query = "SELECT b FROM Bill b WHERE b.date = :date")})
public class Bill implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idbill")
    private Integer idbill;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumn(name = "idperson", referencedColumnName = "idperson")
    @ManyToOne(optional = false)
    private Seller idperson;
    @JoinColumn(name = "idorders", referencedColumnName = "idorders")
    @ManyToOne(optional = false)
    private Orders idorders;

    public Bill() {
    }

    public Bill(Integer idbill) {
        this.idbill = idbill;
    }

    public Integer getIdbill() {
        return idbill;
    }

    public void setIdbill(Integer idbill) {
        this.idbill = idbill;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Seller getIdperson() {
        return idperson;
    }

    public void setIdperson(Seller idperson) {
        this.idperson = idperson;
    }

    public Orders getIdorders() {
        return idorders;
    }

    public void setIdorders(Orders idorders) {
        this.idorders = idorders;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbill != null ? idbill.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bill)) {
            return false;
        }
        Bill other = (Bill) object;
        if ((this.idbill == null && other.idbill != null) || (this.idbill != null && !this.idbill.equals(other.idbill))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Bill[ idbill=" + idbill + " ]";
    }
    
}
