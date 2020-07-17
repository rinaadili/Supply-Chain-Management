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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author RA
 */
@Entity
@Table(name = "Title")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Title.findAll", query = "SELECT t FROM Title t")
    , @NamedQuery(name = "Title.findByTitleID", query = "SELECT t FROM Title t WHERE t.titleID = :titleID")
    , @NamedQuery(name = "Title.findByTitleName", query = "SELECT t FROM Title t WHERE t.titleName = :titleName")
    , @NamedQuery(name = "Title.findByDescription", query = "SELECT t FROM Title t WHERE t.description = :description")})
public class Title implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TitleID")
    @GeneratedValue(generator = "InvSeq")
    @SequenceGenerator(name = "InvSeq", sequenceName = "INV_SEQ", allocationSize = 1)
    private Integer titleID;
    @Basic(optional = false)
    @Column(name = "TitleName")
    private String titleName;
    @Column(name = "Description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "titleID")
    private Collection<Employees> employeesCollection;

    public Title() {
    }

    public Title(Integer titleID) {
        this.titleID = titleID;
    }

    public Title(Integer titleID, String titleName) {
        this.titleID = titleID;
        this.titleName = titleName;
    }

    public Integer getTitleID() {
        return titleID;
    }

    public void setTitleID(Integer titleID) {
        this.titleID = titleID;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlTransient
    public Collection<Employees> getEmployeesCollection() {
        return employeesCollection;
    }

    public void setEmployeesCollection(Collection<Employees> employeesCollection) {
        this.employeesCollection = employeesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (titleID != null ? titleID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Title)) {
            return false;
        }
        Title other = (Title) object;
        if ((this.titleID == null && other.titleID != null) || (this.titleID != null && !this.titleID.equals(other.titleID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return titleName;
    }
    
}
