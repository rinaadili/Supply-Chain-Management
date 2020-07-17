/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Shippers;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author RA
 */
public class ShippersComboBoxModel extends AbstractListModel<Shippers> implements ComboBoxModel<Shippers>{
    
    List<Shippers> list;
    Shippers selectedItem;
    
     public ShippersComboBoxModel () {}
    
    public ShippersComboBoxModel (List<Shippers> list) {
        this.list = list;
    }
    
    public void add(List<Shippers> list){
        this.list=list;
    }
    
    @Override
    public int getSize() {
         return list.size();
    }

    @Override
    public Shippers getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
         selectedItem=(Shippers)anItem;
    }

    @Override
    public Object getSelectedItem() {
         return selectedItem;
    }
    
}
