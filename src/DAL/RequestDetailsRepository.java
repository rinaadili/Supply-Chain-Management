/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Request;
import BLL.RequestDetails;
import java.util.List;

/**
 *
 * @author RA
 */
public class RequestDetailsRepository extends EntMngClass implements RequestDetailsInterface{

    @Override
    public void create(RequestDetails p) throws SCHMException {
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
    public void edit(RequestDetails p) throws SCHMException {
          try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception es) {
            throw new SCHMException(es.getMessage());
        }
    }

    @Override
    public void delete(RequestDetails p) throws SCHMException {
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
    public List<RequestDetails> findAll() throws SCHMException {
        try {
            return (List<RequestDetails>) em.createNamedQuery("RequestDetails.findAll").getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }

    @Override
    public RequestDetails findById(Integer id) throws SCHMException{
        try {
            return (RequestDetails)em.createNamedQuery("RequestDetails.findByProductID").setParameter("productID", id).getSingleResult();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }  

    @Override
    public List<RequestDetails> findAllByRequestID(int id) throws SCHMException {
        try {
            return (List<RequestDetails>) em.createNamedQuery("RequestDetails.findByRequestID").setParameter("requestID", new Request(id)).getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }
}
