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
@Table(name = "book_set")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookSet.findAll", query = "SELECT b FROM BookSet b"),
    @NamedQuery(name = "BookSet.findByIdbookSet", query = "SELECT b FROM BookSet b WHERE b.idbookSet = :idbookSet"),
    @NamedQuery(name = "BookSet.findByDescription", query = "SELECT b FROM BookSet b WHERE b.description = :description")})
public class BookSet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idbook_set")
    private Integer idbookSet;
    @Size(max = 45)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idbookset")
    private List<Book> bookList;

    public BookSet() {
    }

    public BookSet(Integer idbookSet) {
        this.idbookSet = idbookSet;
    }

    public Integer getIdbookSet() {
        return idbookSet;
    }

    public void setIdbookSet(Integer idbookSet) {
        this.idbookSet = idbookSet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbookSet != null ? idbookSet.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookSet)) {
            return false;
        }
        BookSet other = (BookSet) object;
        if ((this.idbookSet == null && other.idbookSet != null) || (this.idbookSet != null && !this.idbookSet.equals(other.idbookSet))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.BookSet[ idbookSet=" + idbookSet + " ]";
    }
    
}
