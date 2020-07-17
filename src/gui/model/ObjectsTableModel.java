/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Objects;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author EN
 */
public class ObjectsTableModel extends AbstractTableModel {

    List<Objects> list;
    String[] cols = {"ObjectID", "Company Name", "Address", "City", "Phone","Email"};

    public ObjectsTableModel() {
    }

    public ObjectsTableModel(List<Objects> list) {
        this.list = list;
    }

    public void add(List<Objects> list) {
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

    public Objects getObjects(int pos) {
        return list.get(pos);
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Objects c = getObjects(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getObjectID();
            case 1:
                return c.getCompanyName();
            case 2:
                return c.getAddress();
            case 3:
                return c.getCityID();
            case 4:
                return c.getPhone();
            case 5:
                return c.getEmail();
            default:
                return null;
        }
    }

}
