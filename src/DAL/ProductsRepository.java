/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Inputs;
import BLL.Objects;
import BLL.Products;
import java.util.List;

/**
 *
 * @author cc.ks
 */
public class ProductsRepository extends EntMngClass implements ProductsInterface{

    @Override
    public void create(Products p) throws SCHMException {
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception es) {
            if(es.getMessage().contains("2627")){
                throw new SCHMException("Kjo e dhene ekziton!");
            }
            else{
                throw new SCHMException(es.getMessage());
            }
            
        }
    }

    @Override
    public void edit(Products p) throws SCHMException {
          try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception es) {
            throw new SCHMException(es.getMessage());
        }
    }

    @Override
    public void delete(Products p) throws SCHMException {
         try {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        } catch (Exception es) {
            if(es.getMessage().contains("547")){
                throw new SCHMException("Kjo e dhene nuk mund te fshihet!");
            }
            else{
                throw new SCHMException(es.getMessage());
            }
        }
    }

    @Override
    public List<Products> findAll() throws SCHMException {
        try {
            return (List<Products>) em.createNamedQuery("Products.findAll").getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }

    @Override
    public Products findById(Integer id) throws SCHMException {
        try {
            return (Products)em.createNamedQuery("Products.findByProductID").setParameter("productID", id).getSingleResult();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }  

    @Override
    public List<Products> findByName(String name) throws SCHMException {
        try {
            return (List<Products>) em.createNamedQuery("Products.findByProductName").setParameter("productName", name).getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }

    @Override
    public Products findByPOId(Integer pID, Integer oID) throws SCHMException {
        try {
            return (Products)em.createNamedQuery("Products.findByObjectIDBarcodeID").setParameter("objectID", new Objects(oID)).setParameter("barcode", pID).getSingleResult();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }

    @Override
    public List<Products> findByObjectID(Object id) throws SCHMException {
        try {
            return (List<Products>) em.createNamedQuery("Products.findByObjectID").setParameter("objectID", id).getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }

    @Override
    public List<Products> findByProductName(String name) throws SCHMException {
        try {
            return (List<Products>) em.createNamedQuery("Products.findByProductName").setParameter("productName", "%" + name + "%").getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }

    @Override
    public Products findByObjectIDproductID(Object id, int pid) throws SCHMException {
        try {
            return (Products) em.createNamedQuery("Products.findByObjectIDProductID").setParameter("objectID", id).setParameter("productID", pid).getSingleResult();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }
}
