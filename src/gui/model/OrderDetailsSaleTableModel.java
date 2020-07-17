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
public class OrderDetailsSaleTableModel extends AbstractTableModel{
    List<OrderDetails> list;
    String[] cols = {"Product","Unit Price","Quantity","Discount","TotalAmount","Total for Payment"};

    public OrderDetailsSaleTableModel() {
    }

    public OrderDetailsSaleTableModel(List<OrderDetails> list) {
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
                return o.getProductID();
            case 1:
                return o.getProductID().getSellPrice();
            case 2:
                return o.getQuantityOrdered();
            case 3:
                return o.getDiscount();    
            case 4:
                return o.getTotalPrice();
            case 5:
                return o.getTotalPriceDsc();
            default:
                return null;
        }
    }
}
