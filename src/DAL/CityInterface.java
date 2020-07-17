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
public interface CityInterface {
    void create(City c) throws SCHMException;
    void edit(City c) throws SCHMException;
    void delete(City x) throws SCHMException;
    List<City> findAll() throws SCHMException;
    List<City> findByCountryID(Country id) throws SCHMException;
    City findById(Integer id);
}
