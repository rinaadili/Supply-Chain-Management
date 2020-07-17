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
@Table(name = "Objects")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Objects.findAll", query = "SELECT o FROM Objects o")
    , @NamedQuery(name = "Objects.findByObjectID", query = "SELECT o FROM Objects o WHERE o.objectID = :objectID")
    , @NamedQuery(name = "Objects.findByCompanyName", query = "SELECT o FROM Objects o WHERE o.companyName = :companyName")
    , @NamedQuery(name = "Objects.findByAddress", query = "SELECT o FROM Objects o WHERE o.address = :address")
    , @NamedQuery(name = "Objects.findByPhone", query = "SELECT o FROM Objects o WHERE o.phone = :phone")
    , @NamedQuery(name = "Objects.findByEmail", query = "SELECT o FROM Objects o WHERE o.email = :email")})
public class Objects implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "objectID")
    private Collection<Orders> ordersCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "objectID")
    private Collection<Employees> employeesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "objectID")
    private Collection<Inputs> inputsCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ObjectID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer objectID;
    @Basic(optional = false)
    @Column(name = "CompanyName")
    private String companyName;
    @Basic(optional = false)
    @Column(name = "Address")
    private String address;
    @Basic(optional = false)
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Email")
    private String email;
    @JoinColumn(name = "CityID", referencedColumnName = "CityID")
    @ManyToOne(optional = false)
    private City cityID;

    public Objects() {
    }

    public Objects(Integer objectID) {
        this.objectID = objectID;
    }

    public Objects(Integer objectID, String companyName, String address, String phone) {
        this.objectID = objectID;
        this.companyName = companyName;
        this.address = address;
        this.phone = phone;
    }

    public Integer getObjectID() {
        return objectID;
    }

    public void setObjectID(Integer objectID) {
        this.objectID = objectID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public City getCityID() {
        return cityID;
    }

    public void setCityID(City cityID) {
        this.cityID = cityID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (objectID != null ? objectID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Objects)) {
            return false;
        }
        Objects other = (Objects) object;
        if ((this.objectID == null && other.objectID != null) || (this.objectID != null && !this.objectID.equals(other.objectID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return companyName;
    }

    @XmlTransient
    public Collection<Employees> getEmployeesCollection() {
        return employeesCollection;
    }

    public void setEmployeesCollection(Collection<Employees> employeesCollection) {
        this.employeesCollection = employeesCollection;
    }

    @XmlTransient
    public Collection<Inputs> getInputsCollection() {
        return inputsCollection;
    }

    public void setInputsCollection(Collection<Inputs> inputsCollection) {
        this.inputsCollection = inputsCollection;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }
    
}
