/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import BLL.Customer;
import java.util.List;

/**
 *
 * @author RA
 */
public interface CustomerInterface {
    void create(Customer p) throws SCHMException;
    void edit(Customer p) throws SCHMException;
    void delete(Customer p) throws SCHMException;
    List<Customer> findAll() throws SCHMException;
    Customer findById(Integer id);
}
