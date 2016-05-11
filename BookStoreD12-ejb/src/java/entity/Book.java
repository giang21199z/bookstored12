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
@Table(name = "book")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b"),
    @NamedQuery(name = "Book.recommendBySalePriceAsc", query = "SELECT b FROM Book b ORDER BY b.salePrice ASC"),
    @NamedQuery(name = "Book.recommendBySalePriceDesc", query = "SELECT b FROM Book b ORDER BY b.salePrice DESC"),
    @NamedQuery(name = "Book.recommendByQuantityAsc", query = "SELECT b FROM Book b ORDER BY b.quantity ASC"),
    @NamedQuery(name = "Book.recommendByQuantityDesc", query = "SELECT b FROM Book b ORDER BY b.quantity DESC"),
    @NamedQuery(name = "Book.findByIdbook", query = "SELECT b FROM Book b WHERE b.idbook = :idbook"),
    @NamedQuery(name = "Book.findByImage", query = "SELECT b FROM Book b WHERE b.image = :image"),
    @NamedQuery(name = "Book.findByTitle", query = "SELECT b FROM Book b WHERE b.title = :title"),
    @NamedQuery(name = "Book.search", query = "SELECT b FROM Book b WHERE b.title LIKE :title"),
    @NamedQuery(name = "Book.findByAuthor", query = "SELECT b FROM Book b WHERE b.author = :author"),
    @NamedQuery(name = "Book.findByPublisher", query = "SELECT b FROM Book b WHERE b.publisher = :publisher"),
    @NamedQuery(name = "Book.findByPublisherYear", query = "SELECT b FROM Book b WHERE b.publisherYear = :publisherYear"),
    @NamedQuery(name = "Book.findByDescription", query = "SELECT b FROM Book b WHERE b.description = :description"),
    @NamedQuery(name = "Book.findByOriginalPrice", query = "SELECT b FROM Book b WHERE b.originalPrice = :originalPrice"),
    @NamedQuery(name = "Book.findBySalePrice", query = "SELECT b FROM Book b WHERE b.salePrice = :salePrice"),
    @NamedQuery(name = "Book.findByQuantity", query = "SELECT b FROM Book b WHERE b.quantity = :quantity")})
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idbook")
    private Integer idbook;
    @Size(max = 45)
    @Column(name = "image")
    private String image;
    @Size(max = 45)
    @Column(name = "title")
    private String title;
    @Size(max = 45)
    @Column(name = "author")
    private String author;
    @Size(max = 45)
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "publisherYear")
    @Temporal(TemporalType.DATE)
    private Date publisherYear;
    @Size(max = 1000)
    @Column(name = "description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "originalPrice")
    private Float originalPrice;
    @Column(name = "salePrice")
    private Float salePrice;
    @Column(name = "quantity")
    private Integer quantity;
    @JoinColumn(name = "idcategory", referencedColumnName = "idcategory")
    @ManyToOne(optional = false)
    private Category idcategory;
    @JoinColumn(name = "idbookset", referencedColumnName = "idbook_set")
    @ManyToOne(optional = false)
    private BookSet idbookset;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idbook")
    private List<BookOrder> bookOrderList;

    public Book() {
    }

    public Book(Integer idbook) {
        this.idbook = idbook;
    }

    public Integer getIdbook() {
        return idbook;
    }

    public void setIdbook(Integer idbook) {
        this.idbook = idbook;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublisherYear() {
        return publisherYear;
    }

    public void setPublisherYear(Date publisherYear) {
        this.publisherYear = publisherYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Float originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Float salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Category getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(Category idcategory) {
        this.idcategory = idcategory;
    }

    public BookSet getIdbookset() {
        return idbookset;
    }

    public void setIdbookset(BookSet idbookset) {
        this.idbookset = idbookset;
    }

    @XmlTransient
    public List<BookOrder> getBookOrderList() {
        return bookOrderList;
    }

    public void setBookOrderList(List<BookOrder> bookOrderList) {
        this.bookOrderList = bookOrderList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbook != null ? idbook.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.idbook == null && other.idbook != null) || (this.idbook != null && !this.idbook.equals(other.idbook))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Book[ idbook=" + idbook + " ]";
    }
    
}
