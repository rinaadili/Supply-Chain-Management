/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Users;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author RA
 */
public class UsersTableModel extends AbstractTableModel{
    
    List<Users> list;
    String[] cols = {"EmployeeID", "Username","Password","Permission"};
    
    public UsersTableModel() {
    }

    public UsersTableModel(List<Users> list) {
        this.list = list;
    }

    public void add(List<Users> list) {
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
    
    public Users getUser(int pos) {
        return list.get(pos);
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
           Users u = getUser(rowIndex);
        switch (columnIndex) {
            case 0:
                return u.getEmployeeID();
            case 1:
                return u.getUsername();
            case 2:
                return u.getPassword();
            case 3:
                return u.getPermissionID();
            default:
                return null;
        }
    }
    
}
