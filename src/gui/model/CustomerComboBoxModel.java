/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Customer;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author cc.ks
 */
public class CustomerComboBoxModel extends AbstractListModel<Customer> implements ComboBoxModel<Customer>{
    List<Customer> list;
    Customer selectedItem;
    
    public CustomerComboBoxModel () {}
    
    public CustomerComboBoxModel (List<Customer> list) {
        this.list = list;
    }
    
    public void add(List<Customer> list){
        this.list=list;
    }
    
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Customer getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem=(Customer)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}
