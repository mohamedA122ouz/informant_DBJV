/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package informantdb;

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

/**
 *
 * @author Student
 */
@Entity
@Table(name = "choosen")
@NamedQueries({
    @NamedQuery(name = "Choosen.findAll", query = "SELECT c FROM Choosen c"),
    @NamedQuery(name = "Choosen.findById", query = "SELECT c FROM Choosen c WHERE c.id = :id"),
    @NamedQuery(name = "Choosen.findByProfit", query = "SELECT c FROM Choosen c WHERE c.profit = :profit")})
public class Choosen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "profit")
    private float profit;
    @JoinColumn(name = "userId", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private User userId;
    @JoinColumn(name = "adId", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Ads adId;

    public Choosen() {
    }

    public Choosen(Long id) {
        this.id = id;
    }

    public Choosen(Long id, float profit) {
        this.id = id;
        this.profit = profit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Ads getAdId() {
        return adId;
    }

    public void setAdId(Ads adId) {
        this.adId = adId;
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
        if (!(object instanceof Choosen)) {
            return false;
        }
        Choosen other = (Choosen) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "informantdb.Choosen[ id=" + id + " ]";
    }
    
}
