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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author GIANGND-SVMC
 */
@Entity
@Table(name = "fullname")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fullname.findAll", query = "SELECT f FROM Fullname f"),
    @NamedQuery(name = "Fullname.findByIdfullname", query = "SELECT f FROM Fullname f WHERE f.idfullname = :idfullname"),
    @NamedQuery(name = "Fullname.findByFirstname", query = "SELECT f FROM Fullname f WHERE f.firstname = :firstname"),
    @NamedQuery(name = "Fullname.findByMidname", query = "SELECT f FROM Fullname f WHERE f.midname = :midname"),
    @NamedQuery(name = "Fullname.findByLastname", query = "SELECT f FROM Fullname f WHERE f.lastname = :lastname")})
public class Fullname implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfullname")
    private Integer idfullname;
    @Size(max = 45)
    @Column(name = "firstname")
    private String firstname;
    @Size(max = 45)
    @Column(name = "midname")
    private String midname;
    @Size(max = 45)
    @Column(name = "lastname")
    private String lastname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfullname")
    private List<Person> personList;

    public Fullname() {
    }

    public Fullname(Integer idfullname) {
        this.idfullname = idfullname;
    }

    public Integer getIdfullname() {
        return idfullname;
    }

    public void setIdfullname(Integer idfullname) {
        this.idfullname = idfullname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMidname() {
        return midname;
    }

    public void setMidname(String midname) {
        this.midname = midname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @XmlTransient
    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfullname != null ? idfullname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fullname)) {
            return false;
        }
        Fullname other = (Fullname) object;
        if ((this.idfullname == null && other.idfullname != null) || (this.idfullname != null && !this.idfullname.equals(other.idfullname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Fullname[ idfullname=" + idfullname + " ]";
    }
    
}
