/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.City;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author EN
 */
public class CityTableModel extends AbstractTableModel {

    List<City> list;
    String[] cols = {"CityID", "City Name", "Country ID", };

    public CityTableModel() {
    }

    public CityTableModel(List<City> list) {
        this.list = list;
    }

    public void add(List<City> list) {
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

    public City getCity(int pos) {
        return list.get(pos);
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        City c = getCity(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getCityID();
            case 1:
                return c.getCityName();
            case 2:
                return c.getCountryID();
           
            default:
                return null;
        }
    }

}
