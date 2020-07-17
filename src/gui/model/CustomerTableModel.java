/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;
import BLL.Customer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author cc.ks
 */
public class CustomerTableModel extends AbstractTableModel{
    
    List<Customer> list;
    String[] cols = {"CustomerID", "CustomerName","CustomerSurname","Address","City","Birthdate","Sex","Phone","Email"};
    
     public CustomerTableModel() {
    }

    public CustomerTableModel(List<Customer> list) {
        this.list = list;
    }

    public void add(List<Customer> list) {
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
    
    public Customer getCustomer(int pos) {
        return list.get(pos);
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }
    
     public String ConvertDateFormatToString(Date d){
        SimpleDateFormat fdf=new SimpleDateFormat("dd.MM.yyyy");
        return fdf.format(d);
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Customer c = getCustomer(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getCustomerID();
            case 1:
                return c.getCustomerName();
            case 2:
                return c.getCustomerSurname();
            case 3:
                return c.getAddress();
            case 4:
                return c.getCityID();
            case 5:
                return ConvertDateFormatToString(c.getCustomerBirthdate());
            case 6:
                return (c.getSex() ? "M" : "F");
            case 7:
                return c.getPhone();
            case 8:
                return c.getEmail(); 
            default:
                return null;
        }
    }
}
