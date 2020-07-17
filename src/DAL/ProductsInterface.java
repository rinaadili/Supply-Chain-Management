/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import BLL.Objects;
import BLL.Products;
import BLL.Inputs;
import java.util.List;

/**
 *
 * @author RA
 */
public interface ProductsInterface {
    void create(Products p) throws SCHMException;
    void edit(Products p) throws SCHMException;
    void delete(Products p) throws SCHMException;
    List<Products> findAll() throws SCHMException;
    Products findById(Integer id)  throws SCHMException;
    Products findByPOId(Integer pID,Integer oID)  throws SCHMException;
    List<Products> findByName(String name) throws SCHMException;
    List<Products> findByObjectID(Object id) throws SCHMException;
    List<Products> findByProductName(String name) throws SCHMException;
    Products findByObjectIDproductID(Object id , int pid) throws SCHMException;
}
