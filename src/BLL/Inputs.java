/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author EN
 */
@Entity
@Table(name = "Inputs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inputs.findAll", query = "SELECT i FROM Inputs i")
    , @NamedQuery(name = "Inputs.findByInputID", query = "SELECT i FROM Inputs i WHERE i.inputID = :inputID")
    , @NamedQuery(name = "Inputs.findByInputDate", query = "SELECT i FROM Inputs i WHERE i.inputDate = :inputDate")
    , @NamedQuery(name = "Inputs.findByObjectID", query = "SELECT i FROM Inputs i WHERE i.objectID = :objectID")})
public class Inputs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "InputID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer inputID;
    @Basic(optional = false)
    @Column(name = "InputDate")
    @Temporal(TemporalType.DATE)
    private Date inputDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inputID")
    private Collection<InputDetails> inputDetailsCollection;
    @JoinColumn(name = "EmployeeID", referencedColumnName = "EmployeeID")
    @ManyToOne(optional = false)
    private Employees employeeID;
    @JoinColumn(name = "ObjectID", referencedColumnName = "ObjectID")
    @ManyToOne(optional = false)
    private Objects objectID;
    @JoinColumn(name = "ShipperID", referencedColumnName = "ShipperID")
    @ManyToOne(optional = false)
    private Shippers shipperID;

    public Inputs() {
    }

    public Inputs(Integer inputID) {
        this.inputID = inputID;
    }

    public Inputs(Integer inputID, Date inputDate) {
        this.inputID = inputID;
        this.inputDate = inputDate;
    }

    public Integer getInputID() {
        return inputID;
    }

    public void setInputID(Integer inputID) {
        this.inputID = inputID;
    }

    public Date getInputDate() {
        return inputDate;
    }

    public void setInputDate(Date inputDate) {
        this.inputDate = inputDate;
    }

    @XmlTransient
    public Collection<InputDetails> getInputDetailsCollection() {
        return inputDetailsCollection;
    }

    public void setInputDetailsCollection(Collection<InputDetails> inputDetailsCollection) {
        this.inputDetailsCollection = inputDetailsCollection;
    }

    public Employees getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Employees employeeID) {
        this.employeeID = employeeID;
    }

    public Objects getObjectID() {
        return objectID;
    }

    public void setObjectID(Objects objectID) {
        this.objectID = objectID;
    }

    public Shippers getShipperID() {
        return shipperID;
    }

    public void setShipperID(Shippers shipperID) {
        this.shipperID = shipperID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inputID != null ? inputID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inputs)) {
            return false;
        }
        Inputs other = (Inputs) object;
        if ((this.inputID == null && other.inputID != null) || (this.inputID != null && !this.inputID.equals(other.inputID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Inputs[ inputID=" + inputID + " ]";
    }
    
}
