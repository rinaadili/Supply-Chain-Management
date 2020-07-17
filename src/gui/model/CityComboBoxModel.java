/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.City;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author EN
 */
public class CityComboBoxModel extends AbstractListModel<City> implements ComboBoxModel<City>{
    List<City> list;
    City selectedItem;
    public CityComboBoxModel(){
    }
    public void add(List<City> list){
        this.list=list;
    }
    public CityComboBoxModel(List<City> list){
        this.list=list;
    }
    @Override
    public int getSize() {
        return list.size();
    }

    @Override
    public City getElementAt(int index) {
        return list.get(index);
    }

    @Override
    public void setSelectedItem(Object o) {
        selectedItem=(City)o;
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }
    
}
