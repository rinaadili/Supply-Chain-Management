/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Country;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author EN
 */
public class CountryComboBoxModel extends AbstractListModel<Country> implements ComboBoxModel<Country>{
    List<Country> list;
    Country selectedItem;
    public CountryComboBoxModel(){
    }
    public void add(List<Country> list){
        this.list=list;
    }
    public CountryComboBoxModel(List<Country> list){
        this.list=list;
    }
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public Country getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object o) {
        selectedItem=(Country)o;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
}
