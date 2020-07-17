/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Permission;
import java.util.List;

/**
 *
 * @author cc.ks
 */
public class PermissionRepository extends EntMngClass implements PermissionInterface{

    @Override
    public void create(Permission p) throws SCHMException {
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
    public void edit(Permission p) throws SCHMException {
          try {
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        } catch (Exception es) {
            throw new SCHMException(es.getMessage());
        }
    }

    @Override
    public void delete(Permission p) throws SCHMException {
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
    public List<Permission> findAll() throws SCHMException {
        try {
            return (List<Permission>) em.createNamedQuery("Permission.findAll").getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }

    @Override
    public Permission findById(Integer id) {
        try {
            return (Permission)em.createNamedQuery("Permission.findByPermissionID").setParameter("permissionID", id).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }  
}
