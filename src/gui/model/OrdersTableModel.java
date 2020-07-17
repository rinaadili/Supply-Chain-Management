/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Orders;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author RA
 */
public class OrdersTableModel extends AbstractTableModel{
    List<Orders> list;
    String[] cols = {"OrderID","CustomerID","Employee","OrderDate","ShipperID","ObjectID"};

    public OrdersTableModel() {
    }

    public OrdersTableModel(List<Orders> list) {
        this.list = list;
    }

    public void add(List<Orders> list) {
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

    public Orders getOrder(int pos) {
        return list.get(pos);
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Orders o = getOrder(rowIndex);
        switch (columnIndex) {
            case 0:
                return o.getOrderID();
            case 1:
                return o.getCustomerID();
            case 2:
                return o.getEmployeeID();
            case 3:
                return o.getOrderDate();
            case 4:
                return o.getShipperID();
            case 5:
                return o.getObjectID();
            default:
                return null;
        }
    }
}


