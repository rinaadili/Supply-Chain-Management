/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Suppliers;
import java.util.List;

/**
 *
 * @author RA
 */
public interface SupplierInterface {
    void create(Suppliers s) throws SCHMException;
    void edit(Suppliers s) throws SCHMException;
    void delete(Suppliers s) throws SCHMException;
    List<Suppliers> findAll() throws SCHMException;
    Suppliers findById(Integer id);
}
