/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Orders;
import java.util.*;

/**
 *
 * @author RA
 */
public class OrdersRespiratory extends EntMngClass implements OrdersInterface{

    @Override
    public void create(Orders o) throws SCHMException {
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
    public void edit(Orders o) throws SCHMException {
        try {
            em.getTransaction().begin();
            em.merge(o);
            em.getTransaction().commit();
        } catch (Exception es) {
            throw new SCHMException(es.getMessage());
        }
    }

    @Override
    public void delete(Orders o) throws SCHMException {
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
    public List<Orders> findAll() throws SCHMException {
         try {
            return (List<Orders>) em.createNamedQuery("Orders.findAll").getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }

    @Override
    public Orders findById(Integer id) {
       try {
            return (Orders)em.createNamedQuery("Orders.findByID").setParameter("requestID", id).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Orders> findByObjectID(Object obj) throws SCHMException {
        try {
            return (List<Orders>) em.createNamedQuery("Orders.findByObjectID").setParameter("objectID", obj).getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }
 
    
    
}

