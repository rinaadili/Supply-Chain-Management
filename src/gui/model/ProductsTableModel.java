/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;
import BLL.Products;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author cc.ks
 */
public class ProductsTableModel extends AbstractTableModel{
    
    List<Products> list;
    String[] cols = {"ProductID", "ProductName","CategoryID","Supplier","Buy Price","Sell Price","Barcode"};
    
     public ProductsTableModel() {
    }

    public ProductsTableModel(List<Products> list) {
        this.list = list;
    }

    public void add(List<Products> list) {
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
    
    public Products getProducts(int pos) {
        return list.get(pos);
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Products c = getProducts(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getProductID();
            case 1:
                return c.getProductName();
            case 2:
                return c.getCategoryID();
            case 3:
                return c.getSupplierID();
            case 4:
                return c.getBuyPrice();
            case 5:
                return c.getSellPrice();
            case 6:
                return c.getBarcode();
            default:
                return null;
        }
    }
}
