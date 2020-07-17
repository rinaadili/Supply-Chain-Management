/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import BLL.Employees;
import BLL.Objects;
import BLL.Request;
import java.util.List;

/**
 *
 * @author RA
 */
public interface RequestInterface {
    void create(Request p) throws SCHMException;
    void edit(Request p) throws SCHMException;
    void delete(Request p) throws SCHMException;
    List<Request> findAll() throws SCHMException;
    Request findById(Integer id) throws SCHMException;
    List<Request> findAllByEmployees(Employees id) throws SCHMException;
}
