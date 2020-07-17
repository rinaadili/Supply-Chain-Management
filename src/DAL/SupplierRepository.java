/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Suppliers;
import java.util.List;

/**
 *
 * @author cc.ks
 */
public class SupplierRepository extends EntMngClass implements SupplierInterface{

    @Override
    public void create(Suppliers s) throws SCHMException {
         try {
            em.getTransaction().begin();
            em.persist(s);
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
    public void edit(Suppliers s) throws SCHMException {
         try {
            em.getTransaction().begin();
            em.merge(s);
            em.getTransaction().commit();
        } catch (Exception es) {
            throw new SCHMException(es.getMessage());
        }
    }

    @Override
    public void delete(Suppliers s) throws SCHMException {
         try {
            em.getTransaction().begin();
            em.remove(s);
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
    public List<Suppliers> findAll() throws SCHMException {
          try {
            return (List<Suppliers>) em.createNamedQuery("Suppliers.findAll").getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }

    @Override
    public Suppliers findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
