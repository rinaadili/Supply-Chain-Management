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
 * @author RA
 */
@Entity
@Table(name = "RequestDetails")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequestDetails.findAll", query = "SELECT r FROM RequestDetails r")
    , @NamedQuery(name = "RequestDetails.findByRequestDetailsID", query = "SELECT r FROM RequestDetails r WHERE r.requestDetailsID = :requestDetailsID")
    , @NamedQuery(name = "RequestDetails.findByQuantity", query = "SELECT r FROM RequestDetails r WHERE r.quantity = :quantity")
    , @NamedQuery(name = "RequestDetails.findByRequestID", query = "SELECT r FROM RequestDetails r WHERE r.requestID = :requestID")
    , @NamedQuery(name = "RequestDetails.findByProductID", query = "SELECT r FROM RequestDetails r WHERE r.productID = :productID")})
public class RequestDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "RequestDetailsID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer requestDetailsID;
    @Basic(optional = false)
    @Column(name = "Quantity")
    private int quantity;
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
    @ManyToOne(optional = false)
    private Products productID;
    @JoinColumn(name = "RequestID", referencedColumnName = "RequestID")
    @ManyToOne(optional = false)
    private Request requestID;

    public RequestDetails() {
    }

    public RequestDetails(Integer requestDetailsID) {
        this.requestDetailsID = requestDetailsID;
    }

    public RequestDetails(Integer requestDetailsID, int quantity) {
        this.requestDetailsID = requestDetailsID;
        this.quantity = quantity;
    }

    public RequestDetails(int quantity, Products productID, Request requestID) {
        this.quantity = quantity;
        this.productID = productID;
        this.requestID = requestID;
    }

    public Integer getRequestDetailsID() {
        return requestDetailsID;
    }

    public void setRequestDetailsID(Integer requestDetailsID) {
        this.requestDetailsID = requestDetailsID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Products getProductID() {
        return productID;
    }

    public void setProductID(Products productID) {
        this.productID = productID;
    }

    public Request getRequestID() {
        return requestID;
    }

    public void setRequestID(Request requestID) {
        this.requestID = requestID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requestDetailsID != null ? requestDetailsID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequestDetails)) {
            return false;
        }
        RequestDetails other = (RequestDetails) object;
        if ((this.requestDetailsID == null && other.requestDetailsID != null) || (this.requestDetailsID != null && !this.requestDetailsID.equals(other.requestDetailsID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.RequestDetails[ requestDetailsID=" + requestDetailsID + " ]";
    }
    
}
