/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Inputs;
import java.util.*;

/**
 *
 * @author cc.ks
 */
public class InputsRespiratory extends EntMngClass implements InputsInterface{

    @Override
    public void create(Inputs o) throws SCHMException {
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
    public void edit(Inputs o) throws SCHMException {
        try {
            em.getTransaction().begin();
            em.merge(o);
            em.getTransaction().commit();
        } catch (Exception es) {
            throw new SCHMException(es.getMessage());
        }
    }

    @Override
    public void delete(Inputs o) throws SCHMException {
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
    public List<Inputs> findAll() throws SCHMException {
        try {
            return (List<Inputs>) em.createNamedQuery("Inputs.findAll").getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }

    @Override
    public Inputs findById(Integer id) {
       try {
            return (Inputs)em.createNamedQuery("Inputs.findByInputID").setParameter("inputID", id).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Inputs> findByObjectID(Object obj) throws SCHMException {
        try {
            return (List<Inputs>) em.createNamedQuery("Inputs.findByObjectID").getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }
 
    
    
}

