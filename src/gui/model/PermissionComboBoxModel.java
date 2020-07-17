/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Permission;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author RA
 */
public class PermissionComboBoxModel extends AbstractListModel<Permission> implements ComboBoxModel<Permission>{
    List<Permission> list;
    Permission selectedItem;
    
    public PermissionComboBoxModel () {}
    
     public PermissionComboBoxModel (List<Permission> list) {
        this.list = list;
    }
    
    public void add(List<Permission> list){
        this.list=list;
    }

    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Permission getElementAt(int index) {
       return list.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectedItem=(Permission)anItem;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
}
