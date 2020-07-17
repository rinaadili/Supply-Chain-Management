/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.InputDetails;
import BLL.Inputs;
import BLL.Products;
import java.util.List;

/**
 *
 * @author RA
 */
public interface InputDetailsInterface {
    void create(InputDetails o) throws SCHMException;
    void edit(InputDetails o) throws SCHMException;
    void delete(InputDetails o) throws SCHMException;
    List<InputDetails> findAll() throws SCHMException;
    InputDetails findById(Integer id);
    List<InputDetails> findByInputID(int id) throws SCHMException;
    List<InputDetails> findByInputDetails(Inputs i, Products p) throws SCHMException;
}
