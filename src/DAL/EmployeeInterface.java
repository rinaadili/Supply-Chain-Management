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
public interface EmployeeInterface {
    void create(Employees p) throws SCHMException;
    void edit(Employees p) throws SCHMException;
    void delete(Employees p) throws SCHMException;
    List<Employees> findAll() throws SCHMException;
    Employees findById(Integer id);
    List<Employees> findByObjectID(Objects id) throws SCHMException;
}
