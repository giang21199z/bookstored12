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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author GIANGND-SVMC
 */
@Entity
@Table(name = "book_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BookOrder.findAll", query = "SELECT b FROM BookOrder b"),
    @NamedQuery(name = "BookOrder.findByIdbookOrder", query = "SELECT b FROM BookOrder b WHERE b.idbookOrder = :idbookOrder"),
    @NamedQuery(name = "BookOrder.findByQuantity", query = "SELECT b FROM BookOrder b WHERE b.quantity = :quantity")})
public class BookOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idbook_order")
    private Integer idbookOrder;
    @Column(name = "quantity")
    private Integer quantity;
    @JoinColumn(name = "idcart", referencedColumnName = "idcart")
    @ManyToOne(optional = false)
    private Cart idcart;
    @JoinColumn(name = "idbook", referencedColumnName = "idbook")
    @ManyToOne(optional = false)
    private Book idbook;

    public BookOrder() {
    }

    public BookOrder(Integer idbookOrder) {
        this.idbookOrder = idbookOrder;
    }

    public Integer getIdbookOrder() {
        return idbookOrder;
    }

    public void setIdbookOrder(Integer idbookOrder) {
        this.idbookOrder = idbookOrder;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Cart getIdcart() {
        return idcart;
    }

    public void setIdcart(Cart idcart) {
        this.idcart = idcart;
    }

    public Book getIdbook() {
        return idbook;
    }

    public void setIdbook(Book idbook) {
        this.idbook = idbook;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbookOrder != null ? idbookOrder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BookOrder)) {
            return false;
        }
        BookOrder other = (BookOrder) object;
        if ((this.idbookOrder == null && other.idbookOrder != null) || (this.idbookOrder != null && !this.idbookOrder.equals(other.idbookOrder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.BookOrder[ idbookOrder=" + idbookOrder + " ]";
    }
    
}
