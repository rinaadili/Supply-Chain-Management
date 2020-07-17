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
public interface CountryInterface {
    void create(Country c) throws SCHMException;
    void edit(Country c) throws SCHMException;
    void delete(Country x) throws SCHMException;
    List<Country> findAll() throws SCHMException;
    Country findById(Integer id);
}
