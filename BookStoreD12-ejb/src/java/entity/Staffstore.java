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
@Table(name = "staffstore")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Staffstore.findAll", query = "SELECT s FROM Staffstore s"),
    @NamedQuery(name = "Staffstore.findByIdperson", query = "SELECT s FROM Staffstore s WHERE s.idperson = :idperson")})
public class Staffstore implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idperson")
    private Integer idperson;
    @JoinColumn(name = "idperson", referencedColumnName = "idperson", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Employee employee;

    public Staffstore() {
    }

    public Staffstore(Integer idperson) {
        this.idperson = idperson;
    }

    public Integer getIdperson() {
        return idperson;
    }

    public void setIdperson(Integer idperson) {
        this.idperson = idperson;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
        if (!(object instanceof Staffstore)) {
            return false;
        }
        Staffstore other = (Staffstore) object;
        if ((this.idperson == null && other.idperson != null) || (this.idperson != null && !this.idperson.equals(other.idperson))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Staffstore[ idperson=" + idperson + " ]";
    }
    
}
