/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author EN
 */
@Entity
@Table(name = "City")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c")
    , @NamedQuery(name = "City.findByCityID", query = "SELECT c FROM City c WHERE c.cityID = :cityID")
    , @NamedQuery(name = "City.findByCityName", query = "SELECT c FROM City c WHERE c.cityName = :cityName")
    , @NamedQuery(name = "City.findByCountryID", query = "SELECT c FROM City c WHERE c.countryID = :countryID")})
public class City implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityID")
    private Collection<Suppliers> suppliersCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityID")
    private Collection<Customer> customerCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CityID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer cityID;
    @Basic(optional = false)
    @Column(name = "CityName")
    private String cityName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityID")
    private Collection<Objects> objectsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityID")
    private Collection<Employees> employeesCollection;
    @JoinColumn(name = "CountryID", referencedColumnName = "CountryID")
    @ManyToOne(optional = false)
    private Country countryID;

    public City() {
    }

    public City(Integer cityID) {
        this.cityID = cityID;
    }

    public City(Integer cityID, String cityName) {
        this.cityID = cityID;
        this.cityName = cityName;
    }

    public Integer getCityID() {
        return cityID;
    }

    public void setCityID(Integer cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @XmlTransient
    public Collection<Objects> getObjectsCollection() {
        return objectsCollection;
    }

    public void setObjectsCollection(Collection<Objects> objectsCollection) {
        this.objectsCollection = objectsCollection;
    }

    @XmlTransient
    public Collection<Employees> getEmployeesCollection() {
        return employeesCollection;
    }

    public void setEmployeesCollection(Collection<Employees> employeesCollection) {
        this.employeesCollection = employeesCollection;
    }

    public Country getCountryID() {
        return countryID;
    }

    public void setCountryID(Country countryID) {
        this.countryID = countryID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cityID != null ? cityID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof City)) {
            return false;
        }
        City other = (City) object;
        if ((this.cityID == null && other.cityID != null) || (this.cityID != null && !this.cityID.equals(other.cityID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return cityName;
    }

    @XmlTransient
    public Collection<Customer> getCustomerCollection() {
        return customerCollection;
    }

    public void setCustomerCollection(Collection<Customer> customerCollection) {
        this.customerCollection = customerCollection;
    }

    @XmlTransient
    public Collection<Suppliers> getSuppliersCollection() {
        return suppliersCollection;
    }

    public void setSuppliersCollection(Collection<Suppliers> suppliersCollection) {
        this.suppliersCollection = suppliersCollection;
    }
    
}
