/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import BLL.Objects;
import java.util.List;

/**
 *
 * @author EN
 */
public interface ObjectsInterface {
    void create(Objects c) throws SCHMException;
    void edit(Objects c) throws SCHMException;
    void delete(Objects x) throws SCHMException;
    List<Objects> findAll() throws SCHMException;
    Objects findById(Integer id)  throws SCHMException;
}
