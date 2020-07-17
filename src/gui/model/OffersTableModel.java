/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import BLL.Offers;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author EN
 */
public class OffersTableModel extends AbstractTableModel {

    List<Offers> list;
    String[] cols = {"OfferID", "ProductCategoryID", "Discount Price", "Start Date", "End Date","Valid", "ObjectID"};

    public OffersTableModel() {
    }

    public OffersTableModel(List<Offers> list) {
        this.list = list;
    }

    public void add(List<Offers> list) {
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

    public Offers getOffers(int pos) {
        return list.get(pos);
    }

    @Override
    public String getColumnName(int column) {
        return cols[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Offers c = getOffers(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getOfferID();
            case 1:
                return c.getProductCategoryID();
            case 2:
                return c.getDiscountPrs();
            case 3:
                return c.getStartDate();
            case 4: 
                return c.getEndDate();
            case 5:
                return c.getValid();
            case 6:
                return c.getObjectID();
            default:
                return null;
        }
    }

}
