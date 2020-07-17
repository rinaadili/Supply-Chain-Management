/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cc.ks
 */
@Entity
@Table(name = "Offers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Offers.findAll", query = "SELECT o FROM Offers o")
    , @NamedQuery(name = "Offers.findByOfferID", query = "SELECT o FROM Offers o WHERE o.offerID = :offerID")
    , @NamedQuery(name = "Offers.findByDiscountPrs", query = "SELECT o FROM Offers o WHERE o.discountPrs = :discountPrs")
    , @NamedQuery(name = "Offers.findByStartDate", query = "SELECT o FROM Offers o WHERE o.startDate = :startDate")
    , @NamedQuery(name = "Offers.findByEndDate", query = "SELECT o FROM Offers o WHERE o.endDate = :endDate")
    , @NamedQuery(name = "Offers.findByValid", query = "SELECT o FROM Offers o WHERE o.valid = :valid")
    ,@NamedQuery(name = "Offers.findByObjectID", query = "SELECT o FROM Offers o WHERE o.objectID = :objectID")})
public class Offers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "OfferID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer offerID;
    @Basic(optional = false)
    @Column(name = "DiscountPrs")
    private int discountPrs;
    @Basic(optional = false)
    @Column(name = "StartDate")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "EndDate")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Basic(optional = false)
    @Column(name = "Valid")
    private boolean valid;
    @JoinColumn(name = "ObjectID", referencedColumnName = "ObjectID")
    @ManyToOne(optional = false)
    private Objects objectID;
    @JoinColumn(name = "ProductCategoryID", referencedColumnName = "CategoryID")
    @ManyToOne(optional = false)
    private ProductCategory productCategoryID;

    public Offers() {
    }

    public Offers(Integer offerID) {
        this.offerID = offerID;
    }

    public Offers(Integer offerID, int discountPrs, Date startDate, Date endDate, boolean valid) {
        this.offerID = offerID;
        this.discountPrs = discountPrs;
        this.startDate = startDate;
        this.endDate = endDate;
        this.valid = valid;
    }

    public Integer getOfferID() {
        return offerID;
    }

    public void setOfferID(Integer offerID) {
        this.offerID = offerID;
    }

    public int getDiscountPrs() {
        return discountPrs;
    }

    public void setDiscountPrs(int discountPrs) {
        this.discountPrs = discountPrs;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean getValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Objects getObjectID() {
        return objectID;
    }

    public void setObjectID(Objects objectID) {
        this.objectID = objectID;
    }

    public ProductCategory getProductCategoryID() {
        return productCategoryID;
    }

    public void setProductCategoryID(ProductCategory productCategoryID) {
        this.productCategoryID = productCategoryID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (offerID != null ? offerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Offers)) {
            return false;
        }
        Offers other = (Offers) object;
        if ((this.offerID == null && other.offerID != null) || (this.offerID != null && !this.offerID.equals(other.offerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BLL.Offers[ offerID=" + offerID + " ]";
    }
    
}
