/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Employees;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author EN
 */
public class EmployeeTableModel extends AbstractTableModel {

    List<Employees> list;
    String[] cols = {"EmployeeID", "Firstname", "Lastname", "Title", "Birthdate","Gender","Hiredate","City","Phone","Email","Raports To","Object"};

    public EmployeeTableModel() {
    }

    public EmployeeTableModel(List<Employees> list) {
        this.list = list;
    }

    public void add(List<Employees> list) {
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

    public Employees getEmployee(int pos) {
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
        Employees e = getEmployee(rowIndex);
        switch (columnIndex) {
            case 0:
                return e.getEmployeeID();
            case 1:
                return e.getEmployeeName();
            case 2:
                return e.getEmployeeLastname();
            case 3:
                return e.getTitleID();
            case 4:
                return ConvertDateFormatToString(e.getBirthdate());
            case 5:
                return (e.getSex() ? "M" : "F");
            case 6:
                return ConvertDateFormatToString(e.getHiredate());
            case 7:
                return e.getCityID();
            case 8:
                return e.getPhone(); 
            case 9:
                return e.getEmail(); 
            case 10:
                return e.getReportsTo(); 
            case 11:
                return e.getObjectID();
            default:
                return null;
        }
    }

}
