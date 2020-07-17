/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import BLL.Users;
import java.util.List;

/**
 *
 * @author EN
 */
public interface UsersInterface {
    void create(Users u) throws SCHMException;
    void edit(Users u) throws SCHMException;
    void delete(Users u) throws SCHMException;
    List<Users> findAll() throws SCHMException;
    Users findById(Integer id);
    Users findByUsername(String s) throws SCHMException;
    List<Users> findByObjectID(Object id) throws SCHMException;
}
