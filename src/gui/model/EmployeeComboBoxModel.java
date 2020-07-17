/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Employees;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author RA
 */
public class EmployeeComboBoxModel extends AbstractListModel<Employees> implements ComboBoxModel<Employees>{
    List<Employees> list;
    Employees selectedItem;
    
    public EmployeeComboBoxModel () {}
    
    public EmployeeComboBoxModel (List<Employees> list) {
        this.list = list;
    }
    
    public void add(List<Employees> list){
        this.list=list;
    }
    
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Employees getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem=(Employees)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}
