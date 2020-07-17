/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Offers;
import java.util.List;

/**
 *
 * @author RA
 */
public class OffersRepository extends EntMngClass implements OffersInterface{

    @Override
    public void create(Offers c) throws SCHMException {
    try {
            em.getTransaction().begin();
            em.persist(c);
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
    public void edit(Offers c) throws SCHMException {
          try {
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
        } catch (Exception es) {
            throw new SCHMException(es.getMessage());
        }
    }

    @Override
    public void delete(Offers x) throws SCHMException {
        try {

            em.getTransaction().begin();
            em.remove(x);
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
    public List<Offers> findAll() throws SCHMException {
      try {
            return (List<Offers>) em.createNamedQuery("Offers.findAll").getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }
    
    @Override
      public List<Offers> findByObjectID(Object id) throws SCHMException {
        try {
            return (List<Offers>) em.createNamedQuery("Offers.findByObjectID").setParameter("objectID", id).getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }
    
}
