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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "OrderDetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderDetails.findAll", query = "SELECT o FROM OrderDetails o")
    , @NamedQuery(name = "OrderDetails.findById", query = "SELECT o FROM OrderDetails o WHERE o.id = :id")
    , @NamedQuery(name = "OrderDetails.findByUnitPrice", query = "SELECT o FROM OrderDetails o WHERE o.unitPrice = :unitPrice")
    , @NamedQuery(name = "OrderDetails.findByQuantityOrdered", query = "SELECT o FROM OrderDetails o WHERE o.quantityOrdered = :quantityOrdered")
    , @NamedQuery(name = "OrderDetails.findByTotalPrice", query = "SELECT o FROM OrderDetails o WHERE o.totalPrice = :totalPrice")
    , @NamedQuery(name = "OrderDetails.findByTotalPriceDsc", query = "SELECT o FROM OrderDetails o WHERE o.totalPriceDsc = :totalPriceDsc")
    , @NamedQuery(name = "OrderDetails.findByDiscount", query = "SELECT o FROM OrderDetails o WHERE o.discount = :discount")
    , @NamedQuery(name = "OrderDetails.findByOrderID", query = "SELECT o FROM OrderDetails o  WHERE o.orderID = :orderID")
    , @NamedQuery(name = "OrderDetails.findByOrderIDProductID", query = "SELECT o FROM OrderDetails o  WHERE o.orderID = :orderID AND o.productID = :productID")})
public class OrderDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "UnitPrice")
    private Double unitPrice;
    @Basic(optional = false)
    @Column(name = "QuantityOrdered")
    private int quantityOrdered;
    @Column(name = "TotalPrice")
    private Double totalPrice;
    @Basic(optional = false)
    @Column(name = "TotalPriceDsc")
    private double totalPriceDsc;
    @Column(name = "Discount")
    private Double discount;
    @JoinColumn(name = "OrderID", referencedColumnName = "OrderID")
    @ManyToOne(optional = false)
    private Orders orderID;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
    @ManyToOne(optional = false)
    private Products productID;

    public OrderDetails() {
    }

    public OrderDetails(Integer id) {
        this.id = id;
    }

    public OrderDetails(Integer id, int quantityOrdered, double totalPriceDsc) {
        this.id = id;
        this.quantityOrdered = quantityOrdered;
        this.totalPriceDsc = totalPriceDsc;
    }

       public OrderDetails(Orders orderId,Products productID,int quantity,double discount,double totalAmount,double pay) {
        this.orderID = orderId;
        this.productID = productID;
        this.quantityOrdered = quantity;
        this.discount = discount;
        this.totalPrice = totalAmount; 
        this.totalPriceDsc = pay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalPriceDsc() {
        return totalPriceDsc;
    }

    public void setTotalPriceDsc(double totalPriceDsc) {
        this.totalPriceDsc = totalPriceDsc;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Orders getOrderID() {
        return orderID;
    }

    public void setOrderID(Orders orderID) {
        this.orderID = orderID;
    }

    public Products getProductID() {
        return productID;
    }

    public void setProductID(Products productID) {
        this.productID = productID;
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
        if (!(object instanceof OrderDetails)) {
            return false;
        }
        OrderDetails other = (OrderDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.OrderDetails[ id=" + id + " ]";
    }
    
}
