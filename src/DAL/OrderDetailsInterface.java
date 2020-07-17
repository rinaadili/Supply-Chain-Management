/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.OrderDetails;
import BLL.Orders;
import BLL.Products;
import java.util.List;

/**
 *
 * @author RA
 */
public interface OrderDetailsInterface {
    void create(OrderDetails o) throws SCHMException;
    void edit(OrderDetails o) throws SCHMException;
    void delete(OrderDetails o) throws SCHMException;
    List<OrderDetails> findAll() throws SCHMException;
    OrderDetails findById(Integer id);
    List<OrderDetails> findByOrderID(int id) throws SCHMException;
    List<OrderDetails> findByOrderIDProductID(Orders o,Products p) throws SCHMException;
}
