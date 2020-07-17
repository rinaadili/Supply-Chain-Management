/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Users;
import java.util.List;

/**
 *
 * @author EN
 */
public class UsersRepository extends EntMngClass implements UsersInterface {

    @Override
    public void create(Users u) throws SCHMException {
        try {
            em.getTransaction().begin();
            em.persist(u);
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
    public void edit(Users u) throws SCHMException {
        try {
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        } catch (Exception es) {
            throw new SCHMException(es.getMessage());
        }
    }

    @Override
    public void delete(Users u) throws SCHMException {
        try {

            em.getTransaction().begin();
            em.remove(u);
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
    public List<Users> findAll() throws SCHMException{
        try {
            return (List<Users>) em.createNamedQuery("Users.findAll").getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }

    @Override
    public Users findByUsername(String s) throws SCHMException {
        try {
            return (Users) em.createNamedQuery("Users.findByUsername").setParameter("username", s).getSingleResult();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }
    
    @Override
    public Users findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Users> findByObjectID(Object id) throws SCHMException {
       try {
            return (List<Users>) em.createNamedQuery("Users.findByObID").setParameter("objectID", id).getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }

}
