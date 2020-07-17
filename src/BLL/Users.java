/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EN
 */
@Entity
@Table(name = "Users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u")
    , @NamedQuery(name = "Users.findByUsername", query = "SELECT u FROM Users u WHERE u.username = :username")
    , @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password")
    , @NamedQuery(name = "Users.findByEmployeeID", query = "SELECT u FROM Users u WHERE u.employeeID = :employeeID")
    , @NamedQuery(name = "Users.findByObID", query = "SELECT u FROM Users u JOIN Employees e ON e.employeeID = u.employeeID WHERE e.objectID = :objectID")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Username")
    private String username;
    @Basic(optional = false)
    @Column(name = "Password")
    private String password;
    @Id
    @Basic(optional = false)
    @Column(name = "EmployeeID")
    private Integer employeeID;
    @JoinColumn(name = "EmployeeID", referencedColumnName = "EmployeeID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Employees employees;
    @JoinColumn(name = "PermissionID", referencedColumnName = "PermissionID")
    @ManyToOne(optional = false)
    private Permission permissionID;

    public Users() {
    }

    public Users(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public Users(Integer employeeID, String username, String password) {
        this.employeeID = employeeID;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public Permission getPermissionID() {
        return permissionID;
    }

    public void setPermissionID(Permission permissionID) {
        this.permissionID = permissionID;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.employeeID == null && other.employeeID != null) || (this.employeeID != null && !this.employeeID.equals(other.employeeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Users[ employeeID=" + employeeID + " ]";
    }
    
}
