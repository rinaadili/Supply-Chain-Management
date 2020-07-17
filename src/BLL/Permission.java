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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EN
 */
@Entity
@Table(name = "Permission")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permission.findAll", query = "SELECT p FROM Permission p")
    , @NamedQuery(name = "Permission.findByPermissionID", query = "SELECT p FROM Permission p WHERE p.permissionID = :permissionID")
    , @NamedQuery(name = "Permission.findByName", query = "SELECT p FROM Permission p WHERE p.name = :name")
    , @NamedQuery(name = "Permission.findByDescription", query = "SELECT p FROM Permission p WHERE p.description = :description")
    , @NamedQuery(name = "Permission.findByEmployeesRead", query = "SELECT p FROM Permission p WHERE p.employeesRead = :employeesRead")
    , @NamedQuery(name = "Permission.findByEmployeesManage", query = "SELECT p FROM Permission p WHERE p.employeesManage = :employeesManage")
    , @NamedQuery(name = "Permission.findByUsersRead", query = "SELECT p FROM Permission p WHERE p.usersRead = :usersRead")
    , @NamedQuery(name = "Permission.findByUsersManage", query = "SELECT p FROM Permission p WHERE p.usersManage = :usersManage")
    , @NamedQuery(name = "Permission.findByObjectsRead", query = "SELECT p FROM Permission p WHERE p.objectsRead = :objectsRead")
    , @NamedQuery(name = "Permission.findByObjectsManage", query = "SELECT p FROM Permission p WHERE p.objectsManage = :objectsManage")
    , @NamedQuery(name = "Permission.findByCustomersRead", query = "SELECT p FROM Permission p WHERE p.customersRead = :customersRead")
    , @NamedQuery(name = "Permission.findByCustomersManage", query = "SELECT p FROM Permission p WHERE p.customersManage = :customersManage")
    , @NamedQuery(name = "Permission.findBySuppliersRead", query = "SELECT p FROM Permission p WHERE p.suppliersRead = :suppliersRead")
    , @NamedQuery(name = "Permission.findBySuppliersManage", query = "SELECT p FROM Permission p WHERE p.suppliersManage = :suppliersManage")
    , @NamedQuery(name = "Permission.findByProductsRead", query = "SELECT p FROM Permission p WHERE p.productsRead = :productsRead")
    , @NamedQuery(name = "Permission.findByProductsManage", query = "SELECT p FROM Permission p WHERE p.productsManage = :productsManage")
    , @NamedQuery(name = "Permission.findByRequestRead", query = "SELECT p FROM Permission p WHERE p.requestRead = :requestRead")
    , @NamedQuery(name = "Permission.findByRequestMake", query = "SELECT p FROM Permission p WHERE p.requestMake = :requestMake")
    , @NamedQuery(name = "Permission.findByOrdersRead", query = "SELECT p FROM Permission p WHERE p.ordersRead = :ordersRead")
    , @NamedQuery(name = "Permission.findBySalesMake", query = "SELECT p FROM Permission p WHERE p.salesMake = :salesMake")
    , @NamedQuery(name = "Permission.findByCountryRead", query = "SELECT p FROM Permission p WHERE p.countryRead = :countryRead")
    , @NamedQuery(name = "Permission.findByCountryManage", query = "SELECT p FROM Permission p WHERE p.countryManage = :countryManage")
    , @NamedQuery(name = "Permission.findByCityRead", query = "SELECT p FROM Permission p WHERE p.cityRead = :cityRead")
    , @NamedQuery(name = "Permission.findByCityManage", query = "SELECT p FROM Permission p WHERE p.cityManage = :cityManage")
    , @NamedQuery(name = "Permission.findByTitleRead", query = "SELECT p FROM Permission p WHERE p.titleRead = :titleRead")
    , @NamedQuery(name = "Permission.findByTitleManage", query = "SELECT p FROM Permission p WHERE p.titleManage = :titleManage")})
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PermissionID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer permissionID;
    @Basic(optional = false)
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @Column(name = "EmployeesRead")
    private boolean employeesRead;
    @Basic(optional = false)
    @Column(name = "EmployeesManage")
    private boolean employeesManage;
    @Basic(optional = false)
    @Column(name = "UsersRead")
    private boolean usersRead;
    @Basic(optional = false)
    @Column(name = "UsersManage")
    private boolean usersManage;
    @Basic(optional = false)
    @Column(name = "ObjectsRead")
    private boolean objectsRead;
    @Basic(optional = false)
    @Column(name = "ObjectsManage")
    private boolean objectsManage;
    @Basic(optional = false)
    @Column(name = "CustomersRead")
    private boolean customersRead;
    @Basic(optional = false)
    @Column(name = "CustomersManage")
    private boolean customersManage;
    @Basic(optional = false)
    @Column(name = "SuppliersRead")
    private boolean suppliersRead;
    @Basic(optional = false)
    @Column(name = "SuppliersManage")
    private boolean suppliersManage;
    @Basic(optional = false)
    @Column(name = "ProductsRead")
    private boolean productsRead;
    @Basic(optional = false)
    @Column(name = "ProductsManage")
    private boolean productsManage;
    @Basic(optional = false)
    @Column(name = "RequestRead")
    private boolean requestRead;
    @Basic(optional = false)
    @Column(name = "RequestMake")
    private boolean requestMake;
    @Basic(optional = false)
    @Column(name = "OrdersRead")
    private boolean ordersRead;
    @Basic(optional = false)
    @Column(name = "SalesMake")
    private boolean salesMake;
    @Basic(optional = false)
    @Column(name = "CountryRead")
    private boolean countryRead;
    @Basic(optional = false)
    @Column(name = "CountryManage")
    private boolean countryManage;
    @Basic(optional = false)
    @Column(name = "CityRead")
    private boolean cityRead;
    @Basic(optional = false)
    @Column(name = "CityManage")
    private boolean cityManage;
    @Basic(optional = false)
    @Column(name = "TitleRead")
    private boolean titleRead;
    @Basic(optional = false)
    @Column(name = "TitleManage")
    private boolean titleManage;

    public Permission() {
    }

    public Permission(Integer permissionID) {
        this.permissionID = permissionID;
    }

    public Permission(Integer permissionID, String name, boolean employeesRead, boolean employeesManage, boolean usersRead, boolean usersManage, boolean objectsRead, boolean objectsManage, boolean customersRead, boolean customersManage, boolean suppliersRead, boolean suppliersManage, boolean productsRead, boolean productsManage, boolean requestRead, boolean requestMake, boolean ordersRead, boolean salesMake, boolean countryRead, boolean countryManage, boolean cityRead, boolean cityManage, boolean titleRead, boolean titleManage) {
        this.permissionID = permissionID;
        this.name = name;
        this.employeesRead = employeesRead;
        this.employeesManage = employeesManage;
        this.usersRead = usersRead;
        this.usersManage = usersManage;
        this.objectsRead = objectsRead;
        this.objectsManage = objectsManage;
        this.customersRead = customersRead;
        this.customersManage = customersManage;
        this.suppliersRead = suppliersRead;
        this.suppliersManage = suppliersManage;
        this.productsRead = productsRead;
        this.productsManage = productsManage;
        this.requestRead = requestRead;
        this.requestMake = requestMake;
        this.ordersRead = ordersRead;
        this.salesMake = salesMake;
        this.countryRead = countryRead;
        this.countryManage = countryManage;
        this.cityRead = cityRead;
        this.cityManage = cityManage;
        this.titleRead = titleRead;
        this.titleManage = titleManage;
    }

    public Integer getPermissionID() {
        return permissionID;
    }

    public void setPermissionID(Integer permissionID) {
        this.permissionID = permissionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getEmployeesRead() {
        return employeesRead;
    }

    public void setEmployeesRead(boolean employeesRead) {
        this.employeesRead = employeesRead;
    }

    public boolean getEmployeesManage() {
        return employeesManage;
    }

    public void setEmployeesManage(boolean employeesManage) {
        this.employeesManage = employeesManage;
    }

    public boolean getUsersRead() {
        return usersRead;
    }

    public void setUsersRead(boolean usersRead) {
        this.usersRead = usersRead;
    }

    public boolean getUsersManage() {
        return usersManage;
    }

    public void setUsersManage(boolean usersManage) {
        this.usersManage = usersManage;
    }

    public boolean getObjectsRead() {
        return objectsRead;
    }

    public void setObjectsRead(boolean objectsRead) {
        this.objectsRead = objectsRead;
    }

    public boolean getObjectsManage() {
        return objectsManage;
    }

    public void setObjectsManage(boolean objectsManage) {
        this.objectsManage = objectsManage;
    }

    public boolean getCustomersRead() {
        return customersRead;
    }

    public void setCustomersRead(boolean customersRead) {
        this.customersRead = customersRead;
    }

    public boolean getCustomersManage() {
        return customersManage;
    }

    public void setCustomersManage(boolean customersManage) {
        this.customersManage = customersManage;
    }

    public boolean getSuppliersRead() {
        return suppliersRead;
    }

    public void setSuppliersRead(boolean suppliersRead) {
        this.suppliersRead = suppliersRead;
    }

    public boolean getSuppliersManage() {
        return suppliersManage;
    }

    public void setSuppliersManage(boolean suppliersManage) {
        this.suppliersManage = suppliersManage;
    }

    public boolean getProductsRead() {
        return productsRead;
    }

    public void setProductsRead(boolean productsRead) {
        this.productsRead = productsRead;
    }

    public boolean getProductsManage() {
        return productsManage;
    }

    public void setProductsManage(boolean productsManage) {
        this.productsManage = productsManage;
    }

    public boolean getRequestRead() {
        return requestRead;
    }

    public void setRequestRead(boolean requestRead) {
        this.requestRead = requestRead;
    }

    public boolean getRequestMake() {
        return requestMake;
    }

    public void setRequestMake(boolean requestMake) {
        this.requestMake = requestMake;
    }

    public boolean getOrdersRead() {
        return ordersRead;
    }

    public void setOrdersRead(boolean ordersRead) {
        this.ordersRead = ordersRead;
    }

    public boolean getSalesMake() {
        return salesMake;
    }

    public void setSalesMake(boolean salesMake) {
        this.salesMake = salesMake;
    }

    public boolean getCountryRead() {
        return countryRead;
    }

    public void setCountryRead(boolean countryRead) {
        this.countryRead = countryRead;
    }

    public boolean getCountryManage() {
        return countryManage;
    }

    public void setCountryManage(boolean countryManage) {
        this.countryManage = countryManage;
    }

    public boolean getCityRead() {
        return cityRead;
    }

    public void setCityRead(boolean cityRead) {
        this.cityRead = cityRead;
    }

    public boolean getCityManage() {
        return cityManage;
    }

    public void setCityManage(boolean cityManage) {
        this.cityManage = cityManage;
    }

    public boolean getTitleRead() {
        return titleRead;
    }

    public void setTitleRead(boolean titleRead) {
        this.titleRead = titleRead;
    }

    public boolean getTitleManage() {
        return titleManage;
    }

    public void setTitleManage(boolean titleManage) {
        this.titleManage = titleManage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (permissionID != null ? permissionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permission)) {
            return false;
        }
        Permission other = (Permission) object;
        if ((this.permissionID == null && other.permissionID != null) || (this.permissionID != null && !this.permissionID.equals(other.permissionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
