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
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Student
 */
@Entity
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByCridetCard", query = "SELECT u FROM User u WHERE u.cridetCard = :cridetCard"),
    @NamedQuery(name = "User.findByToken", query = "SELECT u FROM User u WHERE u.token = :token")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Lob
    @Column(name = "Details")
    private String details;
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;
    @Column(name = "cridetCard")
    private String cridetCard;
    @Column(name = "token")
    private String token;
    @JoinTable(name = "showads", joinColumns = {
        @JoinColumn(name = "userId", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "staticsID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Statistics> statisticsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creatorID")
    private Collection<Ads> adsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Choosen> choosenCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private Collection<Payment> paymentCollection;

    public User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public User(Long id, String name, String password, String details, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.details = details;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCridetCard() {
        return cridetCard;
    }

    public void setCridetCard(String cridetCard) {
        this.cridetCard = cridetCard;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Collection<Statistics> getStatisticsCollection() {
        return statisticsCollection;
    }

    public void setStatisticsCollection(Collection<Statistics> statisticsCollection) {
        this.statisticsCollection = statisticsCollection;
    }

    public Collection<Ads> getAdsCollection() {
        return adsCollection;
    }

    public void setAdsCollection(Collection<Ads> adsCollection) {
        this.adsCollection = adsCollection;
    }

    public Collection<Choosen> getChoosenCollection() {
        return choosenCollection;
    }

    public void setChoosenCollection(Collection<Choosen> choosenCollection) {
        this.choosenCollection = choosenCollection;
    }

    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
//        return "informantdb.User[ id=" + id + " ]";
String details = "USER:";
details += "{\nname: "+this.getName();
details += "\nID: "+this.getId();
details += "\nEmail: "+this.getEmail();
details += "\nPassword: "+this.getPassword();
details += "\nDetails: "+this.getDetails();
details += "\nCridetCard: "+this.getCridetCard();
details += "\nToken: "+this.getToken();
details += "\n}: ";    
return details;
}
    
    
}
