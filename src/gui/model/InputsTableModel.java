/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Inputs;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author cc.ks
 */
public class InputsTableModel extends AbstractTableModel{
    List<Inputs> list;
    String[] cols = {"InputsID","Employee","Input Date","Object" ,"Shipper"};

    public InputsTableModel() {
    }

    public InputsTableModel(List<Inputs> list) {
        this.list = list;
    }

    public void add(List<Inputs> list) {
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

    public Inputs getInputs(int pos) {
        return list.get(pos);
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Inputs o = getInputs(rowIndex);
        switch (columnIndex) {
            case 0:
                return o.getInputID();
            case 1:
                return o.getEmployeeID();
            case 2:
                return o.getInputDate();
            case 3:
                return o.getObjectID();
            case 4:
                return o.getShipperID();
            default:
                return null;
        }
    }
}


