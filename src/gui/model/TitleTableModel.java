/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Title;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author EN
 */
public class TitleTableModel extends AbstractTableModel {

    List<Title> list;
    String[] cols = {"TitleID", "Title Name","Description", };

    public TitleTableModel() {
    }

    public TitleTableModel(List<Title> list) {
        this.list = list;
    }

    public void add(List<Title> list) {
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

    public Title getTitle(int pos) {
        return list.get(pos);
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Title c = getTitle(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getTitleID();
            case 1:
                return c.getTitleName();
            case 2:
                return c.getDescription();
           
            default:
                return null;
        }
    }

}
