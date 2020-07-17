/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Request;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author EN
 */
public class RequestTableModel extends AbstractTableModel {

    List<Request> list;
    String[] cols = {"RequestID", "Employee", "Approved"};

    public RequestTableModel() {
    }

    public RequestTableModel(List<Request> list) {
        this.list = list;
    }

    public void add(List<Request> list) {
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

    public Request getRequest(int pos) {
        return list.get(pos);
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Request c = getRequest(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getRequestID();
            case 1:
                return c.getEmployeeID();
            case 2:
                return c.getApproved();
            default:
                return null;
        }
    }

}
