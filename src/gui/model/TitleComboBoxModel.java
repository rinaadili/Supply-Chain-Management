/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Title;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author EN
 */
public class TitleComboBoxModel extends AbstractListModel<Title> implements ComboBoxModel<Title>{
    List<Title> list;
    Title selectedItem;
    public TitleComboBoxModel(){
    }
    public void add(List<Title> list){
        this.list=list;
    }
    public TitleComboBoxModel(List<Title> list){
        this.list=list;
    }
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Title getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object o) {
        selectedItem=(Title)o;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
}
