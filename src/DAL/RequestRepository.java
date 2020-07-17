/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Employees;
import BLL.Objects;
import BLL.Request;
import java.util.List;

/**
 *
 * @author cc.ks
 */
public class RequestRepository extends EntMngClass implements RequestInterface{

    @Override
    public void create(Request p) throws SCHMException {
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
    public void edit(Request p) throws SCHMException {
          try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception es) {
            throw new SCHMException(es.getMessage());
        }
    }

    @Override
    public void delete(Request p) throws SCHMException {
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
    public List<Request> findAll() throws SCHMException {
        try {
            return (List<Request>) em.createNamedQuery("Request.findAll").getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }
    @Override
    public Request findById(Integer id) throws SCHMException {
        try {
            return (Request) em.createNamedQuery("Request.findByRequestID").setParameter("requestID", id).getSingleResult();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }

    @Override
    public List<Request> findAllByEmployees(Employees id) throws SCHMException {
        try {
            return (List<Request>) em.createNamedQuery("Request.findByEmployeeID").setParameter("employeeID", id).getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }
    
}
