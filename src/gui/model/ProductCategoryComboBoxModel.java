/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.ProductCategory;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author EN
 */
public class ProductCategoryComboBoxModel extends AbstractListModel<ProductCategory> implements ComboBoxModel<ProductCategory>{
    List<ProductCategory> list;
    ProductCategory selectedItem;
    public ProductCategoryComboBoxModel(){
    }
    public void add(List<ProductCategory> list){
        this.list=list;
    }
    public ProductCategoryComboBoxModel(List<ProductCategory> list){
        this.list=list;
    }
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public ProductCategory getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object o) {
        selectedItem=(ProductCategory)o;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
}
