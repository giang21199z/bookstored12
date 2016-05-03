/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author GIANGND-SVMC
 */
@Entity
@Table(name = "orders")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orders.findAll", query = "SELECT o FROM Orders o"),
    @NamedQuery(name = "Orders.updateStatusById", query = "UPDATE Orders o SET o.status = :status WHERE o.idorders = :idorders"),
    @NamedQuery(name = "Orders.findByIdorders", query = "SELECT o FROM Orders o WHERE o.idorders = :idorders"),
    @NamedQuery(name = "Orders.findByDate", query = "SELECT o FROM Orders o WHERE o.date = :date"),
    @NamedQuery(name = "Orders.findByStatus", query = "SELECT o FROM Orders o WHERE o.status = :status")})
public class Orders implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idorders")
    private Integer idorders;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idorders")
    private List<Bill> billList;
    @JoinColumn(name = "idshipping_infor", referencedColumnName = "idshipping_infor")
    @ManyToOne(optional = false)
    private ShippingInfor idshippingInfor;
    @JoinColumn(name = "idpayment", referencedColumnName = "idpayment")
    @ManyToOne(optional = false)
    private Payment idpayment;

    public Orders() {
    }

    public Orders(Integer idorders) {
        this.idorders = idorders;
    }

    public Orders(Integer idorders, String status) {
        this.idorders = idorders;
        this.status = status;
    }

    public Integer getIdorders() {
        return idorders;
    }

    public void setIdorders(Integer idorders) {
        this.idorders = idorders;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }

    public ShippingInfor getIdshippingInfor() {
        return idshippingInfor;
    }

    public void setIdshippingInfor(ShippingInfor idshippingInfor) {
        this.idshippingInfor = idshippingInfor;
    }

    public Payment getIdpayment() {
        return idpayment;
    }

    public void setIdpayment(Payment idpayment) {
        this.idpayment = idpayment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idorders != null ? idorders.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Orders)) {
            return false;
        }
        Orders other = (Orders) object;
        if ((this.idorders == null && other.idorders != null) || (this.idorders != null && !this.idorders.equals(other.idorders))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Orders[ idorders=" + idorders + " ]";
    }
    
}
