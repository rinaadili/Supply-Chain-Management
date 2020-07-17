/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Objects;
import java.util.List;

/**
 *
 * @author EN
 */
public class ObjectsRepository extends EntMngClass implements ObjectsInterface {

    @Override
    public void create(Objects c) throws SCHMException {
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
    public void edit(Objects c) throws SCHMException {
        try {
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
        } catch (Exception es) {
            throw new SCHMException(es.getMessage());
        }
    }

    @Override
    public void delete(Objects c) throws SCHMException {
        try {

            em.getTransaction().begin();
            em.remove(c);
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
    public List<Objects> findAll() throws SCHMException{
        try {
            return (List<Objects>) em.createNamedQuery("Objects.findAll").getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }

    @Override
    public Objects findById(Integer id) throws SCHMException {
      try {
            return (Objects) em.createNamedQuery("Objects.findByObjectID").setParameter("objectID", id).getSingleResult();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }

    public void test() {

    }

}
