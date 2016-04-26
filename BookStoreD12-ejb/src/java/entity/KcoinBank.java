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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author GIANGND-SVMC
 */
@Entity
@Table(name = "kcoin_bank")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KcoinBank.findAll", query = "SELECT k FROM KcoinBank k"),
    @NamedQuery(name = "KcoinBank.findByIdbank", query = "SELECT k FROM KcoinBank k WHERE k.idbank = :idbank")})
public class KcoinBank implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idbank")
    private Integer idbank;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idbank")
    private List<CustomerMember> customerMemberList;
    @JoinColumn(name = "idbank", referencedColumnName = "idbank", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Bank bank;

    public KcoinBank() {
    }

    public KcoinBank(Integer idbank) {
        this.idbank = idbank;
    }

    public Integer getIdbank() {
        return idbank;
    }

    public void setIdbank(Integer idbank) {
        this.idbank = idbank;
    }

    @XmlTransient
    public List<CustomerMember> getCustomerMemberList() {
        return customerMemberList;
    }

    public void setCustomerMemberList(List<CustomerMember> customerMemberList) {
        this.customerMemberList = customerMemberList;
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
        if (!(object instanceof KcoinBank)) {
            return false;
        }
        KcoinBank other = (KcoinBank) object;
        if ((this.idbank == null && other.idbank != null) || (this.idbank != null && !this.idbank.equals(other.idbank))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.KcoinBank[ idbank=" + idbank + " ]";
    }
    
}
