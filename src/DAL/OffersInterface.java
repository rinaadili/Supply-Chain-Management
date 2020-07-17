/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import BLL.Offers;
import java.util.List;

/**
 *
 * @author RA
 */
public interface OffersInterface {
    void create(Offers c) throws SCHMException;
    void edit(Offers c) throws SCHMException;
    void delete(Offers x) throws SCHMException;
    List<Offers> findAll() throws SCHMException;
    List<Offers> findByObjectID(Object id) throws SCHMException;
}
