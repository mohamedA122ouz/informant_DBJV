/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package informantdb;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Student
 */
@Entity
@Table(name = "ads")
@NamedQueries({
    @NamedQuery(name = "Ads.findAll", query = "SELECT a FROM Ads a"),
    @NamedQuery(name = "Ads.findByStars", query = "SELECT a FROM Ads a WHERE a.stars = :stars"),
    @NamedQuery(name = "Ads.findByPrice", query = "SELECT a FROM Ads a WHERE a.price = :price"),
    @NamedQuery(name = "Ads.findById", query = "SELECT a FROM Ads a WHERE a.id = :id")})
public class Ads implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Lob
    @Column(name = "details")
    private String details;
    @Basic(optional = false)
    @Column(name = "stars")
    private short stars;
    @Column(name = "price")
    private Float price;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @JoinColumn(name = "CreatorID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private User creatorID;
    @JoinColumn(name = "imageId", referencedColumnName = "ID")
    @ManyToOne
    private Images imageId;
    @JoinColumn(name = "paymentId", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Payment paymentId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adId")
    private Collection<Images> imagesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "adId")
    private Collection<Choosen> choosenCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ads")
    private Statistics statistics;

    public Ads() {
    }

    public Ads(Long id) {
        this.id = id;
    }

    public Ads(Long id, String details, short stars) {
        this.id = id;
        this.details = details;
        this.stars = stars;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public short getStars() {
        return stars;
    }

    public void setStars(short stars) {
        this.stars = stars;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(User creatorID) {
        this.creatorID = creatorID;
    }

    public Images getImageId() {
        return imageId;
    }

    public void setImageId(Images imageId) {
        this.imageId = imageId;
    }

    public Payment getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Payment paymentId) {
        this.paymentId = paymentId;
    }

    public Collection<Images> getImagesCollection() {
        return imagesCollection;
    }

    public void setImagesCollection(Collection<Images> imagesCollection) {
        this.imagesCollection = imagesCollection;
    }

    public Collection<Choosen> getChoosenCollection() {
        return choosenCollection;
    }

    public void setChoosenCollection(Collection<Choosen> choosenCollection) {
        this.choosenCollection = choosenCollection;
    }

    public Statistics getStatistics() {
        return statistics;
    }

    public void setStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ads)) {
            return false;
        }
        Ads other = (Ads) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "informantdb.Ads[ id=" + id + " ]";
    }
    
}
