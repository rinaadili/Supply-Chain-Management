/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Objects;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author EN
 */
public class ObjectsComboBoxModel extends AbstractListModel<Objects> implements ComboBoxModel<Objects>{
    List<Objects> list;
    Objects selectedItem;
    public ObjectsComboBoxModel(){
    }
    public void add(List<Objects> list){
        this.list=list;
    }
    public ObjectsComboBoxModel(List<Objects> list){
        this.list=list;
    }
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Objects getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object o) {
        selectedItem=(Objects)o;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
}
