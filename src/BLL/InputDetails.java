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
@Table(name = "InputDetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InputDetails.findAll", query = "SELECT i FROM InputDetails i")
    , @NamedQuery(name = "InputDetails.findByInputDetailsID", query = "SELECT i FROM InputDetails i WHERE i.inputDetailsID = :inputDetailsID")
    , @NamedQuery(name = "InputDetails.findByUnitPrice", query = "SELECT i FROM InputDetails i WHERE i.unitPrice = :unitPrice")
    , @NamedQuery(name = "InputDetails.findByQuantity", query = "SELECT i FROM InputDetails i WHERE i.quantity = :quantity")
    , @NamedQuery(name = "InputDetails.findByInputDetails", query = "SELECT i FROM InputDetails i WHERE i.inputID = :inputID AND i.productID = :productID")
    , @NamedQuery(name = "InputDetails.findByInputID", query = "SELECT i FROM InputDetails i WHERE i.inputID = :inputID")})
public class InputDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "InputDetailsID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer inputDetailsID;
    @Basic(optional = false)
    @Column(name = "UnitPrice")
    private double unitPrice;
    @Basic(optional = false)
    @Column(name = "Quantity")
    private int quantity;
    @JoinColumn(name = "InputID", referencedColumnName = "InputID")
    @ManyToOne(optional = false)
    private Inputs inputID;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
    @ManyToOne(optional = false)
    private Products productID;

    public InputDetails() {
    }

    public InputDetails(Integer inputDetailsID) {
        this.inputDetailsID = inputDetailsID;
    }

    public InputDetails(Integer inputDetailsID, double unitPrice, int quantity) {
        this.inputDetailsID = inputDetailsID;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }
    public InputDetails(Inputs inputID, Products productID, double unitPrice, int quantity) {
        this.inputID = inputID;
        this.productID = productID;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public Integer getInputDetailsID() {
        return inputDetailsID;
    }

    public void setInputDetailsID(Integer inputDetailsID) {
        this.inputDetailsID = inputDetailsID;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Inputs getInputID() {
        return inputID;
    }

    public void setInputID(Inputs inputID) {
        this.inputID = inputID;
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
        hash += (inputDetailsID != null ? inputDetailsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InputDetails)) {
            return false;
        }
        InputDetails other = (InputDetails) object;
        if ((this.inputDetailsID == null && other.inputDetailsID != null) || (this.inputDetailsID != null && !this.inputDetailsID.equals(other.inputDetailsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.InputDetails[ inputDetailsID=" + inputDetailsID + " ]";
    }
    
}
