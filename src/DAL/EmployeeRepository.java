/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Employees;
import BLL.Objects;
import java.util.List;

/**
 *
 * @author EN
 */
public class EmployeeRepository extends EntMngClass implements EmployeeInterface {

    @Override
    public void create(Employees e) throws SCHMException {
        try {
            em.getTransaction().begin();
            em.persist(e);
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
    public void edit(Employees e) throws SCHMException {
        try {
            em.getTransaction().begin();
            em.merge(e);
            em.getTransaction().commit();
        } catch (Exception es) {
            throw new SCHMException(es.getMessage());
        }
    }

    @Override
    public void delete(Employees e) throws SCHMException {
        try {

            em.getTransaction().begin();
            em.remove(e);
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
    public List<Employees> findAll() throws SCHMException{
        try {
            return (List<Employees>) em.createNamedQuery("Employees.findAll").getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }

    @Override
    public Employees findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void test() {

    }

    @Override
    public List<Employees> findByObjectID(Objects id) throws SCHMException {
        try {
            return (List<Employees>) em.createNamedQuery("Employees.findByObjectID").setParameter("objectID", id).getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }

}
