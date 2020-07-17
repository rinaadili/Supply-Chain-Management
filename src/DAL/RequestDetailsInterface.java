/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import BLL.Request;
import BLL.RequestDetails;
import java.util.List;

/**
 *
 * @author RA
 */
public interface RequestDetailsInterface {
    void create(RequestDetails p) throws SCHMException;
    void edit(RequestDetails p) throws SCHMException;
    void delete(RequestDetails p) throws SCHMException;
    List<RequestDetails> findAll() throws SCHMException;
    RequestDetails findById(Integer id) throws SCHMException;
    List<RequestDetails> findAllByRequestID(int id) throws SCHMException;
}
