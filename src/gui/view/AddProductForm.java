/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import BLL.Customer;
import BLL.Shippers;
import BLL.Employees;
import BLL.Objects;
import BLL.InputDetails;
import BLL.Inputs;
import BLL.Permission;
import BLL.Products;
import BLL.RequestDetails;
import BLL.Shippers;
import BLL.Title;
import BLL.Users;
import DAL.CustomerInterface;
import DAL.CustomerRepository;
import DAL.InputDetailsInterface;
import DAL.InputDetailsRespiratory;
import DAL.InputsInterface;
import DAL.InputsRespiratory;
import DAL.ProductsInterface;
import DAL.ProductsRepository;
import DAL.SCHMException;
import DAL.ShippersInterface;
import DAL.ShippersRepository;
import gui.model.CustomerComboBoxModel;
import gui.model.InputDetailsTableModel;
import gui.model.InputsTableModel;
import gui.model.ProductsTableModel;
import gui.model.ShippersComboBoxModel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

/**
 *
 * @author cc.ks
 */
public class AddProductForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form MakeASale
     */
    
    ProductsInterface eir = new ProductsRepository();
    ProductsTableModel etm = new ProductsTableModel();
    ProductsInterface eir2 = new ProductsRepository();
    ProductsTableModel etm2 = new ProductsTableModel();
    InputDetailsTableModel rtm = new InputDetailsTableModel();
    InputDetailsInterface cir = new InputDetailsRespiratory();
    InputDetailsTableModel ctm = new InputDetailsTableModel();
    InputsInterface reir = new InputsRespiratory();
    InputsTableModel retm = new InputsTableModel();
    List<InputDetails> listProd = new ArrayList<>();
    CustomerInterface ci = new CustomerRepository();
    ShippersInterface si = new ShippersRepository();
    CustomerComboBoxModel ccbm;
    ShippersComboBoxModel scbm;
    
    private static Permission premission;
    private static Objects object;
    private static Title title;
    private static Users users;
        
    Products c;
    int quantity;
    
    private JPopupMenu popupMenu;
    private JMenuItem menuItemAdd;
    private JMenuItem menuItemRemove;
    private JMenuItem menuItemRemoveAll;
    private int rowS;
    public AddProductForm(Permission prem,Objects obj,Title tit,Users u) {
        premission = prem;
        object = obj;
        title = tit;
        users = u;
        initComponents();
        loadTable();
        loadTable2();
        tabelaSelectedIndexChange();
        populateShippersComboBox();
        tabelaRightClickedRow();
        popupMenu = new JPopupMenu();
        menuItemRemove = new JMenuItem("Remove Current Row");
        menuItemRemoveAll = new JMenuItem("Remove All Rows");
        menuItemRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                listProd.remove(rowS);
                loadTable2();
            }
        });
        menuItemRemoveAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                clearField();
            }
        });
        
        popupMenu.add(menuItemRemove);
        popupMenu.add(menuItemRemoveAll);
        
        
        table2.setComponentPopupMenu(popupMenu);
    }
    
     public void populateShippersComboBox() {
        try {
            List<Shippers> list = si.findAll();
            scbm = new ShippersComboBoxModel(list);
            ShipperCB.setModel(scbm);
            ShipperCB.repaint();
        } catch (SCHMException ex) {

        }
    }
    
     public void loadTable2() {
        rtm.add(listProd);
        table2.setModel(rtm);
        rtm.fireTableDataChanged();
    }
     
      public void loadTable() {
        try {
            List<Products> list = eir.findAll();
            etm.add(list);
            table1.setModel(etm);
            etm.fireTableDataChanged();
        } catch (SCHMException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
      
      public void loadTable(Objects obj) {
        try {
            List<Products> list = eir.findByObjectID(obj);
            etm.add(list);
            table1.setModel(etm);
            etm.fireTableDataChanged();
        } catch (SCHMException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    public void loadTable(String n) {
        try {
            List<Products> list = eir.findByProductName(n);
            etm.add(list);
            table1.setModel(etm);
            etm.fireTableDataChanged();
        } catch (SCHMException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    Inputs o = new Inputs();
    private void tabelaSelectedIndexChange() {
        table1.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent evt) {
            if (evt.getClickCount() == 2) {
                Point pnt = evt.getPoint();
                int row = table1.rowAtPoint(pnt);
                c = etm.getProducts(row);
                String m = JOptionPane.showInputDialog("Sasia");
                quantity = Integer.parseInt(m);
                listProd.add(new InputDetails(o,c,c.getBuyPrice(),quantity));
                loadTable2();
             }
             else {
                 //do something else 
             }
         }
     });
    }
    private void tabelaRightClickedRow() {
        table2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                Point point = evt.getPoint();
                int currentRow = table2.rowAtPoint(point);
                rowS = currentRow;
                table2.setRowSelectionInterval(currentRow, currentRow);
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

        jLabel1 = new javax.swing.JLabel();
        productTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        SaveButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        ShipperCB = new javax.swing.JComboBox();
        ClearButton = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Item:");

        productTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productTFActionPerformed(evt);
            }
        });
        productTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                productTFKeyReleased(evt);
            }
        });

        table1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table1);

        table2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(table2);

        jLabel2.setText("Selected Items:");

        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Shipper:");

        ShipperCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShipperCBActionPerformed(evt);
            }
        });

        ClearButton.setText("Clear");
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(productTF, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(ShipperCB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(317, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(SaveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ClearButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(productTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(ShipperCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ClearButton)
                    .addComponent(SaveButton))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void productTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productTFActionPerformed
        // TODO add your handling code here:
 
        
        
    }//GEN-LAST:event_productTFActionPerformed
    
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
//    public void zbritSasin() throws SCHMException{
//        for (int i = 0; i < listProd.size(); i++) {
//            Integer pID = listProd.get(i).getProductID().getProductID();
//            Products p = eir.findByObjectIDproductID(object, pID);
//            p.setQuantity(p.getQuantity()-listProd.get(i).getQuantityOrdered());
//            try {
//                eir.edit(p);
//            } catch (SCHMException es) {
//                JOptionPane.showMessageDialog(this, es.getMessage());
//                return;
//            }
//        }
//    }
    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        // TODO add your handling code here:
        if(!listProd.isEmpty()){
            o.setEmployeeID(users.getEmployees());
            o.setInputDate(new Date(dateFormat.format(date)));
            o.setShipperID((Shippers)ShipperCB.getSelectedItem());
            o.setObjectID(new Objects(object.getObjectID()));
            
            try {
                reir.create(o);
                for(InputDetails rd: listProd){
                    cir.create(rd);
                }
//                zbritSasin();
            } catch (SCHMException es) {
                JOptionPane.showMessageDialog(this, es.getMessage());
                return;
            }
            JOptionPane.showMessageDialog(this, "Te dhenat u ruajten me sukses!");
            clearField();
            loadTable2();
            loadTable();
            o = new Inputs();
        }else{
            JOptionPane.showMessageDialog(this, "Shto produktet ne list!");
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

     public void clearField() {
        listProd.clear();
        loadTable2();
        ShipperCB.setSelectedIndex(-1);
        ShipperCB.repaint();
  }
    
    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
       clearField();
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void ShipperCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShipperCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ShipperCBActionPerformed

    private void productTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productTFKeyReleased
        String name = productTF.getText();
        if(name.trim().isEmpty()){
            loadTable();
        }else {
            loadTable(name); 
        }
    }//GEN-LAST:event_productTFKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JComboBox ShipperCB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField productTF;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    // End of variables declaration//GEN-END:variables
}
