/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import BLL.Title;
import java.util.List;

/**
 *
 * @author EN
 */
public interface TitleInterface {
    void create(Title c) throws SCHMException;
    void edit(Title c) throws SCHMException;
    void delete(Title x) throws SCHMException;
    List<Title> findAll() throws SCHMException;
    Title findById(Integer id);
}
