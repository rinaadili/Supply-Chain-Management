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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RA
 */
@Entity
@Table(name = "Shippers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Shippers.findAll", query = "SELECT s FROM Shippers s")
    , @NamedQuery(name = "Shippers.findByShipperID", query = "SELECT s FROM Shippers s WHERE s.shipperID = :shipperID")
    , @NamedQuery(name = "Shippers.findByCompanyName", query = "SELECT s FROM Shippers s WHERE s.companyName = :companyName")
    , @NamedQuery(name = "Shippers.findByPhone", query = "SELECT s FROM Shippers s WHERE s.phone = :phone")
    , @NamedQuery(name = "Shippers.findByEmail", query = "SELECT s FROM Shippers s WHERE s.email = :email")})
public class Shippers implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shipperID")
    private Collection<Inputs> inputsCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ShipperID")
    private Integer shipperID;
    @Basic(optional = false)
    @Column(name = "CompanyName")
    private String companyName;
    @Basic(optional = false)
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Email")
    private String email;
    @OneToMany(mappedBy = "shipperID")
    private Collection<Orders> ordersCollection;

    public Shippers() {
    }

    public Shippers(Integer shipperID) {
        this.shipperID = shipperID;
    }

    public Shippers(Integer shipperID, String companyName, String phone) {
        this.shipperID = shipperID;
        this.companyName = companyName;
        this.phone = phone;
    }

    public Integer getShipperID() {
        return shipperID;
    }

    public void setShipperID(Integer shipperID) {
        this.shipperID = shipperID;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shipperID != null ? shipperID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Shippers)) {
            return false;
        }
        Shippers other = (Shippers) object;
        if ((this.shipperID == null && other.shipperID != null) || (this.shipperID != null && !this.shipperID.equals(other.shipperID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return companyName;
    }

    @XmlTransient
    public Collection<Inputs> getInputsCollection() {
        return inputsCollection;
    }

    public void setInputsCollection(Collection<Inputs> inputsCollection) {
        this.inputsCollection = inputsCollection;
    }
    
}
