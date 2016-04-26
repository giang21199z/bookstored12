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
@Table(name = "customer_member")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerMember.findAll", query = "SELECT c FROM CustomerMember c"),
    @NamedQuery(name = "CustomerMember.findByUsername", query = "SELECT c FROM CustomerMember c WHERE c.username = :username"),
    @NamedQuery(name = "CustomerMember.findByPassword", query = "SELECT c FROM CustomerMember c WHERE c.password = :password"),
    @NamedQuery(name = "CustomerMember.findByIdperson", query = "SELECT c FROM CustomerMember c WHERE c.idperson = :idperson"),
    @NamedQuery(name = "CustomerMember.login", query = "SELECT c FROM CustomerMember c WHERE c.username = :username AND c.password = :password")
})
public class CustomerMember implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;
    @Size(max = 45)
    @Column(name = "password")
    private String password;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idperson")
    private Integer idperson;
    @JoinColumn(name = "idbank", referencedColumnName = "idbank")
    @ManyToOne(optional = false)
    private KcoinBank idbank;
    @JoinColumn(name = "idperson", referencedColumnName = "idperson", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Customer customer;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idperson")
    private List<CartSaved> cartSavedList;

    public CustomerMember() {
    }

    public CustomerMember(Integer idperson) {
        this.idperson = idperson;
    }

    public CustomerMember(Integer idperson, String username) {
        this.idperson = idperson;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getIdperson() {
        return idperson;
    }

    public void setIdperson(Integer idperson) {
        this.idperson = idperson;
    }

    public KcoinBank getIdbank() {
        return idbank;
    }

    public void setIdbank(KcoinBank idbank) {
        this.idbank = idbank;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @XmlTransient
    public List<CartSaved> getCartSavedList() {
        return cartSavedList;
    }

    public void setCartSavedList(List<CartSaved> cartSavedList) {
        this.cartSavedList = cartSavedList;
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
        if (!(object instanceof CustomerMember)) {
            return false;
        }
        CustomerMember other = (CustomerMember) object;
        if ((this.idperson == null && other.idperson != null) || (this.idperson != null && !this.idperson.equals(other.idperson))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.CustomerMember[ idperson=" + idperson + " ]";
    }
    
}
