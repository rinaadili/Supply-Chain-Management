/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Shippers;
import java.util.List;

/**
 *
 * @author Hp
 */
public interface ShippersInterface {
    void create(Shippers s) throws SCHMException;
    void edit(Shippers s) throws SCHMException;
    void delete(Shippers s) throws SCHMException;
    List<Shippers> findAll() throws SCHMException;
   Shippers findById(Integer id);
}
