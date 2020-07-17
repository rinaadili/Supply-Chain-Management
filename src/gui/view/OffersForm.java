/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import BLL.Objects;
import BLL.Offers;
import BLL.Permission;
import BLL.ProductCategory;
import BLL.Title;
import DAL.ObjectsInterface;
import DAL.ObjectsRepository;
import DAL.OffersInterface;
import DAL.OffersRepository;
import DAL.ProductCategoryInterface;
import DAL.ProductCategoryRepository;
import DAL.SCHMException;
import gui.model.ObjectsComboBoxModel;
import gui.model.OffersTableModel;
import gui.model.ProductCategoryComboBoxModel;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author cc.ks
 */
public class OffersForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form OffersForm
     */
    OffersInterface oir = new OffersRepository();
    OffersTableModel otm = new OffersTableModel();
    ProductCategoryInterface pir = new ProductCategoryRepository();
    ObjectsInterface obir = new ObjectsRepository();
    
    ProductCategoryComboBoxModel pcbbm;
    ObjectsComboBoxModel ocbbm;
    
    private static Permission premission;
    private static Objects object;
    private static Title title;
    
    public OffersForm(Permission prem,Objects obj,Title tit) {
        premission = prem;
        object = obj;
        title = tit;
        initComponents();
        populateObjectsComboBox();
         if(object.getObjectID() == 1){
            loadTable();
            
        }else {
            loadTable(object);            
            objectCB.setSelectedItem(object);
            objectCB.setEnabled(false);
        }
        populateProductCategoryComboBox();
        tableSelectedIndexChange();
        
        validTF.setEnabled(false);
        startDC.getJCalendar().getYearChooser().setMinimum(Calendar.getInstance().get(Calendar.YEAR)-100);
        startDC.getJCalendar().getYearChooser().setMaximum(Calendar.getInstance().get(Calendar.YEAR));
        endDC.getJCalendar().getYearChooser().setMinimum(2000);
        endDC.getJCalendar().getYearChooser().setMaximum(Calendar.getInstance().get(Calendar.YEAR)+1); 
    }
    
     public void populateProductCategoryComboBox() {
        try {
            List<ProductCategory> list = pir.findAll();
            pcbbm = new ProductCategoryComboBoxModel(list);
            CategoryCB.setModel(pcbbm);
            CategoryCB.repaint();
        } catch (SCHMException ex) {

        }
    }
     
    public void populateObjectsComboBox() {
        try {
            List<Objects> list = obir.findAll();
            ocbbm = new ObjectsComboBoxModel(list);
            objectCB.setModel(ocbbm);
            objectCB.repaint();
        } catch (SCHMException ex) {

        }   
    }
    public void loadTable() {
        try {
            List<Offers> list = oir.findAll();
            otm.add(list);
            offersTable.setModel(otm);
            otm.fireTableDataChanged();
        } catch (SCHMException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    public void loadTable(Objects obj) {
        try {
            List<Offers> list = oir.findByObjectID(obj);
            otm.add(list);
            offersTable.setModel(otm);
            otm.fireTableDataChanged();
        } catch (SCHMException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }    
    private void tableSelectedIndexChange() {
        final ListSelectionModel rowSM = offersTable.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Offers o = otm.getOffers(selectedIndex);
                    CategoryCB.setSelectedItem(o.getProductCategoryID());
                    discountTF.setText(o.getDiscountPrs() + "");
                    startDC.setDate(o.getStartDate());
                    endDC.setDate(o.getEndDate());
                   
                   if(o.getValid() == true){
                       validTF.setText("Yes");
                   }else {
                       validTF.setText("No");
                   }
                objectCB.setSelectedItem(o.getObjectID()); 
                }
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
        offersTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        discountTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        CategoryCB = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        startDC = new com.toedter.calendar.JDateChooser();
        endDC = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        validTF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        objectCB = new javax.swing.JComboBox();
        SaveButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        offersTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(offersTable);

        jLabel1.setText("Product Category:");

        jLabel2.setText("Discount Percentage:");

        jLabel3.setText("%");

        jLabel4.setText("Start Date:");

        jLabel5.setText("End Date:");

        jLabel6.setText("Valid:");

        jLabel7.setText("Object:");

        SaveButton.setText("Save");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(CategoryCB, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(discountTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(startDC, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(endDC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(validTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objectCB, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(SaveButton)
                .addGap(18, 18, 18)
                .addComponent(DeleteButton)
                .addGap(18, 18, 18)
                .addComponent(ClearButton)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(CategoryCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(startDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(validTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(discountTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addComponent(endDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(objectCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton)
                    .addComponent(DeleteButton)
                    .addComponent(ClearButton))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        if (!discountTF.getText().trim().equals("") && startDC.getDate() != null
       && endDC.getDate() != null && CategoryCB.getSelectedIndex() != -1 && objectCB.getSelectedIndex() != -1)
             {
                int row = offersTable.getSelectedRow();
                if (row == -1) {
                    Offers o = new Offers();
                    o.setDiscountPrs(Integer.parseInt(discountTF.getText()));
                    o.setStartDate(startDC.getDate());
                    o.setEndDate(endDC.getDate());
                    o.setProductCategoryID((ProductCategory) CategoryCB.getSelectedItem());
                    o.setObjectID((Objects) objectCB.getSelectedItem());


                    try {
                        oir.create(o);
                    } catch (SCHMException es) {
                        JOptionPane.showMessageDialog(this, es.getMessage());
                        return;
                    }
            } else {
                    Offers o = otm.getOffers(row);
                    o.setDiscountPrs(Integer.parseInt(discountTF.getText()));
                    o.setStartDate(startDC.getDate());
                    o.setEndDate(endDC.getDate());
                    o.setProductCategoryID((ProductCategory) CategoryCB.getSelectedItem());
                    o.setObjectID((Objects) objectCB.getSelectedItem());
                try {
                    oir.edit(o);
                } catch (SCHMException es) {
                    JOptionPane.showMessageDialog(this, es.getMessage());
                    return;
                }               
            }
            clearField();
            
            if(object.getObjectID() == 1){
                loadTable();
            }else {
                loadTable(object);
                objectCB.setSelectedItem(object);
                objectCB.setEnabled(false);
            }
    }//GEN-LAST:event_SaveButtonActionPerformed
    }
    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
          int row = offersTable.getSelectedRow();
        if (row > -1) {
            Object[] ob = {"Po", "Jo"};
            int i = JOptionPane.showOptionDialog(this, "A dëshironi ta fshini ?", "Fshirja", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
            if (i == 0) {
                Offers o = otm.getOffers(row);
                try {
                    oir.delete(o);
                } catch (SCHMException es) {
                    JOptionPane.showMessageDialog(this, es.getMessage());
                }
                clearField();
                if(object.getObjectID() == 1){
                    loadTable();
                  }else {
                    loadTable(object);
                  }
            } else {
                clearField();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Nuk keni selektuar asgje per te fshire!");

        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        clearField();
    }//GEN-LAST:event_ClearButtonActionPerformed
    
     public void clearField() {
        offersTable.clearSelection();
        discountTF.setText("");
        validTF.setText("");
        startDC.setDate(null);
        endDC.setDate(null);
        CategoryCB.setSelectedIndex(-1);
        CategoryCB.repaint();
        validTF.setEnabled(false);
        if(object.getObjectID() == 1){
            objectCB.setSelectedIndex(-1);
            objectCB.repaint();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox CategoryCB;
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField discountTF;
    private com.toedter.calendar.JDateChooser endDC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox objectCB;
    private javax.swing.JTable offersTable;
    private com.toedter.calendar.JDateChooser startDC;
    private javax.swing.JTextField validTF;
    // End of variables declaration//GEN-END:variables
}