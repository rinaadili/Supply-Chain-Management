/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Permission;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author EN
 */
public class PermissionTableModel extends AbstractTableModel {

    List<Permission> list;
    String[] cols = {"PermissionID", "Name", "Description","EmployeesRead","EmployeesManage","UsersRead","UsersManage","ObjectsRead","ObjectsManage"
                    ,"CustomersRead","CustomersManage","SuppliersRead","SuppliersManage","ProductsRead","ProductsManage","RequestRead","RequestMake"
                    ,"OrdersRead","SalesMake","CountryRead","CountryManage","CityRead","CityManage","TitleRead","TitleManage"};

    public PermissionTableModel() {
    }

    public PermissionTableModel(List<Permission> list) {
        this.list = list;
    }

    public void add(List<Permission> list) {
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

    public Permission getPermission(int pos) {
        return list.get(pos);
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Permission c = getPermission(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getPermissionID();
            case 1:
                return c.getName();
            case 2:
                return c.getDescription();    
            case 3:
                return c.getEmployeesRead();
            case 4:
                return c.getEmployeesManage();
            case 5:
                return c.getUsersRead();
            case 6:
                return c.getUsersManage();    
            case 7:
                return c.getObjectsRead();
            case 8:
                return c.getObjectsManage();
            case 9:
                return c.getCustomersRead();
            case 10:
                return c.getCustomersManage();
            case 11:
                return c.getSuppliersRead();
            case 12:
                return c.getSuppliersManage();    
            case 13:
                return c.getProductsRead();
            case 14:
                return c.getProductsManage();
            case 15:
                return c.getRequestRead();
            case 16:
                return c.getRequestMake();
            case 17:
                return c.getOrdersRead();
            case 18:
                return c.getSalesMake();    
            case 19:
                return c.getCountryRead();
            case 20:
                return c.getCountryManage();  
            case 21:
                return c.getCityRead();
            case 22:
                return c.getCityManage();    
            case 23:
                return c.getTitleRead();
            case 24:
                return c.getTitleManage();    
            default:
                return null;
        }
    }

}
