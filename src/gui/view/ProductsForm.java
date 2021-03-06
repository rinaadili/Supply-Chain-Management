/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import BLL.Objects;
import BLL.Permission;
import BLL.ProductCategory;
import BLL.Products;
import BLL.Suppliers;
import BLL.Title;
import DAL.ObjectsInterface;
import DAL.ObjectsRepository;
import DAL.ProductCategoryInterface;
import DAL.ProductCategoryRepository;
import DAL.ProductsInterface;
import DAL.ProductsRepository;
import DAL.SCHMException;
import DAL.SupplierInterface;
import DAL.SupplierRepository;
import gui.model.ObjectsComboBoxModel;
import gui.model.ProductCategoryComboBoxModel;
import gui.model.ProductsTableModel;
import gui.model.SupplierComboBoxModel;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author EN
 */
public class ProductsForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form ProdctsForm
     */
    ProductsInterface eir = new ProductsRepository();
    ProductsTableModel etm = new ProductsTableModel();
    ProductCategoryInterface pir = new ProductCategoryRepository();
    SupplierInterface sir = new SupplierRepository();
    ObjectsInterface oir = new ObjectsRepository();
    
    ProductCategoryComboBoxModel pcbbm;
    SupplierComboBoxModel scbbm;
    ObjectsComboBoxModel ocbbm;
    
    private static Permission premission;
    private static Objects object;
    private static Title title;
    public ProductsForm(Permission prem,Objects obj,Title tit) {
        premission = prem;
        object = obj;
        title = tit;
        initComponents();
        loadTable();
        tabelaSelectedIndexChange();
        populateProductCategoryComboBox();
        populateSupplierComboBox();
    }
    public void populateProductCategoryComboBox() {
        try {
            List<ProductCategory> list = pir.findAll();
            pcbbm = new ProductCategoryComboBoxModel(list);
            categoryCB.setModel(pcbbm);
            categoryCB.repaint();
        } catch (SCHMException ex) {

        }
    }
    public void populateSupplierComboBox() {
        try {
            List<Suppliers> list = sir.findAll();
            scbbm = new SupplierComboBoxModel(list);
            supplierCB.setModel(scbbm);
            supplierCB.repaint();
        } catch (SCHMException ex) {

        }
    }
    private void tabelaSelectedIndexChange() {
        final ListSelectionModel rowSM = tabela.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Products e = etm.getProducts(selectedIndex);
                    productTF.setText(e.getProductName());
                    categoryCB.setSelectedItem(e.getCategoryID());
                    categoryCB.repaint();
                    supplierCB.setSelectedItem(e.getSupplierID());
                    supplierCB.repaint();
                    buyPriceTF.setText(e.getBuyPrice()+ "");
                    sellPriceTF.setText(e.getSellPrice()+"");
                    barcodeTF.setText(e.getBarcode()+ "");
                    
                }
            }
        });
    }
    public void loadTable() {
        try {
            List<Products> list = eir.findAll();
            etm.add(list);
            tabela.setModel(etm);
            etm.fireTableDataChanged();
            tabela.repaint();
        } catch (SCHMException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    public void loadTable(Objects obj) {
        try {
            List<Products> list = eir.findByObjectID(obj);
            etm.add(list);
            tabela.setModel(etm);
            etm.fireTableDataChanged();
            tabela.repaint();
        } catch (SCHMException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        buyPriceTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        sellPriceTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        barcodeTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        saveBT = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        categoryCB = new javax.swing.JComboBox();
        supplierCB = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Products");

        jLabel1.setText("* Product Name:");

        jLabel2.setText("* Category:");

        jLabel3.setText("* Supplier:");

        jLabel4.setText("* Buy Price:");

        jLabel5.setText("* Sell Price:");

        jLabel6.setText("Barcode:");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabela);

        saveBT.setText("Save");
        saveBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBTActionPerformed(evt);
            }
        });

        jButton1.setText("Delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setText("* Indicates required field");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveBT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(productTF, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(categoryCB, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(supplierCB, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(buyPriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(sellPriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(barcodeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buyPriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(productTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(categoryCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(supplierCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sellPriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(barcodeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBT)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBTActionPerformed
        synchronized(this){
            if (!productTF.getText().trim().isEmpty() && categoryCB.getSelectedIndex() != -1 && supplierCB.getSelectedIndex() != -1
                && !buyPriceTF.getText().trim().isEmpty() && !sellPriceTF.getText().trim().isEmpty() && !barcodeTF.getText().trim().isEmpty()) 
            {
                int row = tabela.getSelectedRow();
                if (row == -1) {
                    Products e = new Products();
                    e.setProductName(productTF.getText());
                    e.setCategoryID((ProductCategory) categoryCB.getSelectedItem());
                    e.setSupplierID((Suppliers) supplierCB.getSelectedItem());
                    e.setBuyPrice(Double.parseDouble(buyPriceTF.getText()));
                    e.setSellPrice(Double.parseDouble(sellPriceTF.getText()));
                    e.setBarcode(Integer.parseInt(barcodeTF.getText()));

                    try {
                        eir.create(e);
                    } catch (SCHMException es) {
                        JOptionPane.showMessageDialog(this, es.getMessage());
                        return;
                    }
                } else {
                    Products e = etm.getProducts(row);
                    e.setProductName(productTF.getText());
                    e.setCategoryID((ProductCategory) categoryCB.getSelectedItem());
                    e.setSupplierID((Suppliers) supplierCB.getSelectedItem());
                    e.setBuyPrice(Double.parseDouble(buyPriceTF.getText()));
                    e.setSellPrice(Double.parseDouble(sellPriceTF.getText()));
                    e.setBarcode(Integer.parseInt(barcodeTF.getText()));
                    try {
                        eir.edit(e);
                    } catch (SCHMException es) {
                        JOptionPane.showMessageDialog(this, es.getMessage());
                        return;
                    }

                }
                clearFild();
                notify();
                if(object.getObjectID() == 1){
                    loadTable();
                }else {
                    loadTable(object);
                }

            } else {
                JOptionPane.showMessageDialog(this, "Ju lutem plotesoni te gjitha fushat obligative!");
            }
        }
    }//GEN-LAST:event_saveBTActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int row = tabela.getSelectedRow();
        if (row > -1) {
            Object[] ob = {"Po", "Jo"};
            int i = JOptionPane.showOptionDialog(this, "A dëshironi ta fshini ?", "Fshirja", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
            if (i == 0) {
                Products e = etm.getProducts(row);
                try {
                    eir.delete(e);
                } catch (SCHMException es) {
                    JOptionPane.showMessageDialog(this, es.getMessage());
                }
                clearFild();
                loadTable();
            } else {
                clearFild();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Nuk keni selektuar asgje per te fshire!");

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        clearFild();
    }//GEN-LAST:event_jButton2ActionPerformed
    public void clearFild() {
        tabela.clearSelection();
        productTF.setText("");
        categoryCB.setSelectedIndex(-1);
        categoryCB.repaint();
        supplierCB.setSelectedIndex(-1);
        supplierCB.repaint();
        buyPriceTF.setText("");
        sellPriceTF.setText("");
        barcodeTF.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField barcodeTF;
    private javax.swing.JTextField buyPriceTF;
    private javax.swing.JComboBox categoryCB;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField productTF;
    private javax.swing.JButton saveBT;
    private javax.swing.JTextField sellPriceTF;
    private javax.swing.JComboBox supplierCB;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
