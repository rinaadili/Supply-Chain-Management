/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.OrderDetails;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author RA
 */
public class OrderDetailsTableModel extends AbstractTableModel{
    List<OrderDetails> list;
    String[] cols = {"OrderDetailsID", "OrderID","ProductID","QuantityOrdered","Discount","TotalAmount","Total for Payment"};

    public OrderDetailsTableModel() {
    }

    public OrderDetailsTableModel(List<OrderDetails> list) {
        this.list = list;
    }

    public void add(List<OrderDetails> list) {
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

    public OrderDetails getOrderDetails(int pos) {
        return list.get(pos);
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        OrderDetails o = getOrderDetails(rowIndex);
        switch (columnIndex) {
            case 0:
                return o.getId();
            case 1:
                return o.getOrderID();
            case 2:
                return o.getProductID();
            case 3:
                return o.getQuantityOrdered();
            case 4:
                return o.getDiscount();
            case 5:
                return o.getTotalPrice();
            case 6:
                return o.getTotalPriceDsc();
            default:
                return null;
        }
    }
}


