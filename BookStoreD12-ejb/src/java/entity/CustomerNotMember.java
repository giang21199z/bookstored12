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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author GIANGND-SVMC
 */
@Entity
@Table(name = "customer_not_member")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerNotMember.findAll", query = "SELECT c FROM CustomerNotMember c"),
    @NamedQuery(name = "CustomerNotMember.findByIdperson", query = "SELECT c FROM CustomerNotMember c WHERE c.idperson = :idperson")})
public class CustomerNotMember implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idperson")
    private Integer idperson;
    @JoinColumn(name = "idperson", referencedColumnName = "idperson", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Customer customer;

    public CustomerNotMember() {
    }

    public CustomerNotMember(Integer idperson) {
        this.idperson = idperson;
    }

    public Integer getIdperson() {
        return idperson;
    }

    public void setIdperson(Integer idperson) {
        this.idperson = idperson;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idperson != null ? idperson.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerNotMember)) {
            return false;
        }
        CustomerNotMember other = (CustomerNotMember) object;
        if ((this.idperson == null && other.idperson != null) || (this.idperson != null && !this.idperson.equals(other.idperson))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CustomerNotMember[ idperson=" + idperson + " ]";
    }
    
}
