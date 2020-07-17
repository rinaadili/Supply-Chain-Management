/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.City;
import BLL.Country;
import java.util.List;

/**
 *
 * @author EN
 */
public class CityRepository extends EntMngClass implements CityInterface {

    @Override
    public void create(City c) throws SCHMException {
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
    public void edit(City c) throws SCHMException {
        try {
            em.getTransaction().begin();
            em.merge(c);
            em.getTransaction().commit();
        } catch (Exception es) {
            throw new SCHMException(es.getMessage());
        }
    }

    @Override
    public void delete(City c) throws SCHMException {
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
    public List<City> findAll() throws SCHMException{
        try {
            return (List<City>) em.createNamedQuery("City.findAll").getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }

    @Override
    public City findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void test() {

    }

    @Override
    public List<City> findByCountryID(Country id) throws SCHMException {
        try {
            return (List<City>) em.createNamedQuery("City.findByCountryID").setParameter("countryID", id).getResultList();
        } catch (Exception e) {
            throw new SCHMException(e.getMessage());
        }
    }

}
