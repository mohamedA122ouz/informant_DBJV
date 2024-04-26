/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package informantdb;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Student
 */
@Entity
@Table(name = "statistics")
@NamedQueries({
    @NamedQuery(name = "Statistics.findAll", query = "SELECT s FROM Statistics s"),
    @NamedQuery(name = "Statistics.findById", query = "SELECT s FROM Statistics s WHERE s.id = :id"),
    @NamedQuery(name = "Statistics.findByAdId", query = "SELECT s FROM Statistics s WHERE s.adId = :adId")})
public class Statistics implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "adId")
    private long adId;
    @ManyToMany(mappedBy = "statisticsCollection")
    private Collection<User> userCollection;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Ads ads;

    public Statistics() {
    }

    public Statistics(Long id) {
        this.id = id;
    }

    public Statistics(Long id, long adId) {
        this.id = id;
        this.adId = adId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getAdId() {
        return adId;
    }

    public void setAdId(long adId) {
        this.adId = adId;
    }

    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    public Ads getAds() {
        return ads;
    }

    public void setAds(Ads ads) {
        this.ads = ads;
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
        if (!(object instanceof Statistics)) {
            return false;
        }
        Statistics other = (Statistics) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "informantdb.Statistics[ id=" + id + " ]";
    }
    
}
