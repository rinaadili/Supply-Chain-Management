/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Inputs;
import java.util.List;

/**
 *
 * @author cc.ks
 */
public interface InputsInterface {
    void create(Inputs o) throws SCHMException;
    void edit(Inputs o) throws SCHMException;
    void delete(Inputs o) throws SCHMException;
    List<Inputs> findAll() throws SCHMException;
    Inputs findById(Integer id);
    List<Inputs> findByObjectID(Object obj)  throws SCHMException;
}
