/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import BLL.ProductCategory;
import java.util.List;

/**
 *
 * @author EN
 */
public interface ProductCategoryInterface {
    void create(ProductCategory c) throws SCHMException;
    void edit(ProductCategory c) throws SCHMException;
    void delete(ProductCategory x) throws SCHMException;
    List<ProductCategory> findAll() throws SCHMException;
    ProductCategory findById(Integer id);
}
