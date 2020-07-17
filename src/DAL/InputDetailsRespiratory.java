/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.InputDetails;
import BLL.Inputs;
import BLL.Orders;
import BLL.Products;
import java.util.List;

/**
 *
 * @author cc.ks
 */
public class InputDetailsRespiratory extends EntMngClass implements InputDetailsInterface{

    @Override
    public void create(InputDetails o) throws SCHMException {
      try {
            em.getTransaction().begin();
            em.persist(o);
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
    public void edit(InputDetails o) throws SCHMException {
           try {
            em.getTransaction().begin();
            em.merge(o);
            em.getTransaction().commit();
        } catch (Exception es) {
            throw new SCHMException(es.getMessage());
        }
    }

    @Override
    public void delete(InputDetails o) throws SCHMException {
         try {
            em.getTransaction().begin();
            em.remove(o);
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
    public List<InputDetails> findAll() throws SCHMException {
         try {
            return (List<InputDetails>) em.createNamedQuery("InputDetails.findAll").getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }

    @Override
    public InputDetails findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<InputDetails> findByInputID(int id) throws SCHMException {
        try {
            return (List<InputDetails>) em.createNamedQuery("InputDetails.findByInputID").setParameter("inputID", new Inputs(id)).getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }

    @Override
    public List<InputDetails> findByInputDetails(Inputs i, Products p) throws SCHMException {
        try {
            return (List<InputDetails>) em.createNamedQuery("InputDetails.findByInputDetails").setParameter("inputID", i).setParameter("productID", p).getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }
    
}


