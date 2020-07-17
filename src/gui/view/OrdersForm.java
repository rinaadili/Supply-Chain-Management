/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import BLL.Objects;
import BLL.Orders;
import BLL.Permission;
import BLL.Title;
import DAL.OrdersInterface;
import DAL.OrdersRespiratory;
import DAL.SCHMException;
import gui.model.OrdersTableModel;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

/**
 *
 * @author cc.ks
 */
public class OrdersForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form OrdersForm
     */
    OrdersInterface oir = new OrdersRespiratory();
    OrdersTableModel otm = new OrdersTableModel();
    
    private static Permission permission;
    private static Objects object;
    private static Title title;
    
    public OrdersForm(Permission permission,Objects object,Title title){
        this.permission = permission;
        this.object = object;
        this.title = title;
        initComponents();
        if(object.getObjectID() == 1){
            loadTable();
        }else {
            loadTable(object);
        }
        
        tabelaSelectedIndexChange();
    }
    
     public void loadTable() {
        try {
            List<Orders> list = oir.findAll();
            otm.add(list);
            oTable.setModel(otm);
            otm.fireTableDataChanged();
        } catch (SCHMException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
     
        public void loadTable(Objects obj) {
        try {
            List<Orders> list = oir.findByObjectID(obj);
            otm.add(list);
            oTable.setModel(otm);
            otm.fireTableDataChanged();
            oTable.repaint();
        } catch (SCHMException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
     private void tabelaSelectedIndexChange() {
        oTable.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent evt) {
             if (evt.getClickCount() == 2) {
                 Point pnt = evt.getPoint();
                 int row = oTable.rowAtPoint(pnt);
                Orders o = otm.getOrder(row);
                 int id = o.getOrderID();
                 OrderDetailsForm rdv;
                 try {
                     rdv = new OrderDetailsForm(id);
                     JDesktopPane desktopPane = getDesktopPane();
                     desktopPane.add(rdv);
                     rdv.show();
                 } catch (SCHMException ex) {
                     Logger.getLogger(RequestView.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
             }
             else {   }
         }
     });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        oTable = new javax.swing.JTable();

        setClosable(true);

        oTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(oTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable oTable;
    // End of variables declaration//GEN-END:variables
}