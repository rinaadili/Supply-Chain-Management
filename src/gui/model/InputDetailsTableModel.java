/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.InputDetails;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cc.ks
 */
public class InputDetailsTableModel extends AbstractTableModel{
    List<InputDetails> list;
    String[] cols = {"ProductID","Unit Price","Quantity"};

    public InputDetailsTableModel() {
    }

    public InputDetailsTableModel(List<InputDetails> list) {
        this.list = list;
    }

    public void add(List<InputDetails> list) {
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

    public InputDetails getInputDetails(int pos) {
        return list.get(pos);
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InputDetails o = getInputDetails(rowIndex);
        switch (columnIndex) {
            case 0:
                return o.getProductID();
            case 1:
                return o.getUnitPrice();
            case 2:
                return o.getQuantity();
            default:
                return null;
        }
    }
}


