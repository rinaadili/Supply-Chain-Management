/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Country;
import java.util.List;

/**
 *
 * @author EN
 */
public class CountryRepository extends EntMngClass implements CountryInterface {

    @Override
    public void create(Country c) throws SCHMException {
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
    public void edit(Country c) throws SCHMException {
        try {
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
        } catch (Exception es) {
            throw new SCHMException(es.getMessage());
        }
    }

    @Override
    public void delete(Country c) throws SCHMException {
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
    public List<Country> findAll() throws SCHMException{
        try {
            return (List<Country>) em.createNamedQuery("Country.findAll").getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }

    @Override
    public Country findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void test() {

    }

}
