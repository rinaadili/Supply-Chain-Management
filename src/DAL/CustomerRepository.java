/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Customer;
import java.util.List;

/**
 *
 * @author cc.ks
 */
public class CustomerRepository extends EntMngClass implements CustomerInterface{

    @Override
    public void create(Customer p) throws SCHMException {
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
    public void edit(Customer p) throws SCHMException {
          try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception es) {
            throw new SCHMException(es.getMessage());
        }
    }

    @Override
    public void delete(Customer p) throws SCHMException {
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
    public List<Customer> findAll() throws SCHMException {
        try {
            return (List<Customer>) em.createNamedQuery("Customer.findAll").getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }

    @Override
    public Customer findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  
}
