/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Suppliers;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author EN
 */
public class SupplierComboBoxModel extends AbstractListModel<Suppliers> implements ComboBoxModel<Suppliers>{
    List<Suppliers> list;
    Suppliers selectedItem;
    public SupplierComboBoxModel(){
    }
    public void add(List<Suppliers> list){
        this.list=list;
    }
    public SupplierComboBoxModel(List<Suppliers> list){
        this.list=list;
    }
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Suppliers getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object o) {
        selectedItem=(Suppliers)o;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
}
