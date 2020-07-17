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
@Table(name = "Products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Products.findAll", query = "SELECT p FROM Products p")
    , @NamedQuery(name = "Products.findByProductID", query = "SELECT p FROM Products p WHERE p.productID = :productID")
    , @NamedQuery(name = "Products.findByBarcode", query = "SELECT p FROM Products p WHERE p.barcode = :barcode")
    , @NamedQuery(name = "Products.findByProductName", query = "SELECT p FROM Products p WHERE p.productName LIKE :productName")
    , @NamedQuery(name = "Products.findByBuyPrice", query = "SELECT p FROM Products p WHERE p.buyPrice = :buyPrice")
    , @NamedQuery(name = "Products.findBySellPrice", query = "SELECT p FROM Products p WHERE p.sellPrice = :sellPrice")})
public class Products implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productID")
    private Collection<OrderDetails> orderDetailsCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ProductID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer productID;
    @Basic(optional = false)
    @Column(name = "Barcode")
    private int barcode;
    @Basic(optional = false)
    @Column(name = "ProductName")
    private String productName;
    @Basic(optional = false)
    @Column(name = "BuyPrice")
    private double buyPrice;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SellPrice")
    private Double sellPrice;
    @JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID")
    @ManyToOne(optional = false)
    private ProductCategory categoryID;
    @JoinColumn(name = "SupplierID", referencedColumnName = "SupplierID")
    @ManyToOne
    private Suppliers supplierID;

    public Products() {
    }

    public Products(Integer productID) {
        this.productID = productID;
    }

    public Products(Integer productID, int barcode, String productName, double buyPrice) {
        this.productID = productID;
        this.barcode = barcode;
        this.productName = productName;
        this.buyPrice = buyPrice;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public ProductCategory getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(ProductCategory categoryID) {
        this.categoryID = categoryID;
    }

    public Suppliers getSupplierID() {
        return supplierID;
    }

    public void setSupplierID(Suppliers supplierID) {
        this.supplierID = supplierID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productID != null ? productID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Products)) {
            return false;
        }
        Products other = (Products) object;
        if ((this.productID == null && other.productID != null) || (this.productID != null && !this.productID.equals(other.productID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return productName;
    }

    @XmlTransient
    public Collection<OrderDetails> getOrderDetailsCollection() {
        return orderDetailsCollection;
    }

    public void setOrderDetailsCollection(Collection<OrderDetails> orderDetailsCollection) {
        this.orderDetailsCollection = orderDetailsCollection;
    }
    
}
