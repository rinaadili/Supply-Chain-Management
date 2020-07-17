/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Country;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author EN
 */
public class CountryTableModel extends AbstractTableModel {

    List<Country> list;
    String[] cols = {"CountryID", "Country Name",  };

    public CountryTableModel() {
    }

    public CountryTableModel(List<Country> list) {
        this.list = list;
    }

    public void add(List<Country> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    public Country getCountry(int pos) {
        return list.get(pos);
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Country c = getCountry(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getCountryID();
            case 1:
                return c.getCountryName();
        
           
            default:
                return null;
        }
    }

}
