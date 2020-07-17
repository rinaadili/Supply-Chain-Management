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
 * @author EN
 */
public class RaportsToComboBoxModel extends AbstractListModel<Employees> implements ComboBoxModel<Employees>{
    List<Employees> list;
    Employees selectedItem;
    public RaportsToComboBoxModel(){
    }
    public void add(List<Employees> list){
        this.list=list;
    }
    public RaportsToComboBoxModel(List<Employees> list){
        this.list=list;
        Employees e = null;
        list.add(e);
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
    public void setSelectedItem(Object o) {
        selectedItem=(Employees)o;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
}
