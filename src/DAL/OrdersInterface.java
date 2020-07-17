/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Orders;
import java.util.List;

/**
 *
 * @author RA
 */
public interface OrdersInterface {
    void create(Orders o) throws SCHMException;
    void edit(Orders o) throws SCHMException;
    void delete(Orders o) throws SCHMException;
    List<Orders> findAll() throws SCHMException;
    Orders findById(Integer id);
    List<Orders> findByObjectID(Object obj)  throws SCHMException;
}
