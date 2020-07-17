/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.RequestDetails;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author EN
 */
public class RequestDetailsTableModel extends AbstractTableModel {

    List<RequestDetails> list;
    String[] cols = {"ProductID", "Quantity"};

    public RequestDetailsTableModel() {
    }

    public RequestDetailsTableModel(List<RequestDetails> list) {
        this.list = list;
    }

    public void add(List<RequestDetails> list) {
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

    public RequestDetails getRequestDetails(int pos) {
        return list.get(pos);
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RequestDetails c = getRequestDetails(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getProductID();
            case 1:
                return c.getQuantity();
            default:
                return null;
        }
    }

}
