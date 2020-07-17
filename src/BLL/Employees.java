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
@Table(name = "Employees")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employees.findAll", query = "SELECT e FROM Employees e")
    , @NamedQuery(name = "Employees.findByEmployeeID", query = "SELECT e FROM Employees e WHERE e.employeeID = :employeeID")
    , @NamedQuery(name = "Employees.findByEmployeeName", query = "SELECT e FROM Employees e WHERE e.employeeName = :employeeName")
    , @NamedQuery(name = "Employees.findByEmployeeLastname", query = "SELECT e FROM Employees e WHERE e.employeeLastname = :employeeLastname")
    , @NamedQuery(name = "Employees.findByBirthdate", query = "SELECT e FROM Employees e WHERE e.birthdate = :birthdate")
    , @NamedQuery(name = "Employees.findByHiredate", query = "SELECT e FROM Employees e WHERE e.hiredate = :hiredate")
    , @NamedQuery(name = "Employees.findByPhone", query = "SELECT e FROM Employees e WHERE e.phone = :phone")
    , @NamedQuery(name = "Employees.findByEmail", query = "SELECT e FROM Employees e WHERE e.email = :email")
    , @NamedQuery(name = "Employees.findBySex", query = "SELECT e FROM Employees e WHERE e.sex = :sex")
    , @NamedQuery(name = "Employees.findByObjectID", query = "SELECT e FROM Employees e WHERE e.objectID = :objectID")})
public class Employees implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeID")
    private Collection<Inputs> inputsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeID")
    private Collection<Request> requestCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeID")
    private Collection<Orders> ordersCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EmployeeID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer employeeID;
    @Basic(optional = false)
    @Column(name = "EmployeeName")
    private String employeeName;
    @Basic(optional = false)
    @Column(name = "EmployeeLastname")
    private String employeeLastname;
    @Basic(optional = false)
    @Column(name = "Birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthdate;
    @Basic(optional = false)
    @Column(name = "Hiredate")
    @Temporal(TemporalType.DATE)
    private Date hiredate;
    @Basic(optional = false)
    @Column(name = "Phone")
    private String phone;
    @Basic(optional = false)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @Column(name = "Sex")
    private boolean sex;
    @JoinColumn(name = "CityID", referencedColumnName = "CityID")
    @ManyToOne(optional = false)
    private City cityID;
    @OneToMany(mappedBy = "reportsTo")
    private Collection<Employees> employeesCollection;
    @JoinColumn(name = "ReportsTo", referencedColumnName = "EmployeeID")
    @ManyToOne
    private Employees reportsTo;
    @JoinColumn(name = "ObjectID", referencedColumnName = "ObjectID")
    @ManyToOne(optional = false)
    private Objects objectID;
    @JoinColumn(name = "TitleID", referencedColumnName = "TitleID")
    @ManyToOne(optional = false)
    private Title titleID;

    public Employees() {
    }

    public Employees(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public Employees(Integer employeeID, String employeeName, String employeeLastname, Date birthdate, Date hiredate, String phone, String email, boolean sex) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeLastname = employeeLastname;
        this.birthdate = birthdate;
        this.hiredate = hiredate;
        this.phone = phone;
        this.email = email;
        this.sex = sex;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeLastname() {
        return employeeLastname;
    }

    public void setEmployeeLastname(String employeeLastname) {
        this.employeeLastname = employeeLastname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
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

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public City getCityID() {
        return cityID;
    }

    public void setCityID(City cityID) {
        this.cityID = cityID;
    }

    @XmlTransient
    public Collection<Employees> getEmployeesCollection() {
        return employeesCollection;
    }

    public void setEmployeesCollection(Collection<Employees> employeesCollection) {
        this.employeesCollection = employeesCollection;
    }

    public Employees getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Employees reportsTo) {
        this.reportsTo = reportsTo;
    }

    public Objects getObjectID() {
        return objectID;
    }

    public void setObjectID(Objects objectID) {
        this.objectID = objectID;
    }

    public Title getTitleID() {
        return titleID;
    }

    public void setTitleID(Title titleID) {
        this.titleID = titleID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeID != null ? employeeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employees)) {
            return false;
        }
        Employees other = (Employees) object;
        if ((this.employeeID == null && other.employeeID != null) || (this.employeeID != null && !this.employeeID.equals(other.employeeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return employeeName + " " + employeeLastname;
    }

    @XmlTransient
    public Collection<Orders> getOrdersCollection() {
        return ordersCollection;
    }

    public void setOrdersCollection(Collection<Orders> ordersCollection) {
        this.ordersCollection = ordersCollection;
    }

    @XmlTransient
    public Collection<Request> getRequestCollection() {
        return requestCollection;
    }

    public void setRequestCollection(Collection<Request> requestCollection) {
        this.requestCollection = requestCollection;
    }

    @XmlTransient
    public Collection<Inputs> getInputsCollection() {
        return inputsCollection;
    }

    public void setInputsCollection(Collection<Inputs> inputsCollection) {
        this.inputsCollection = inputsCollection;
    }
    
}
