/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import BLL.Permission;
import java.util.List;

/**
 *
 * @author cc.ks
 */
public interface PermissionInterface {
    void create(Permission p) throws SCHMException;
    void edit(Permission p) throws SCHMException;
    void delete(Permission p) throws SCHMException;
    List<Permission> findAll() throws SCHMException;
    Permission findById(Integer id);
}
