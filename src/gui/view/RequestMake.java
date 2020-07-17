/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import BLL.Employees;
import BLL.Objects;
import BLL.OrderDetails;
import BLL.Permission;
import BLL.Products;
import BLL.Request;
import BLL.RequestDetails;
import BLL.Title;
import BLL.Users;
import DAL.ProductsInterface;
import DAL.ProductsRepository;
import DAL.RequestDetailsInterface;
import DAL.RequestDetailsRepository;
import DAL.RequestInterface;
import DAL.RequestRepository;
import DAL.SCHMException;
import gui.model.ProductsTableModel;
import gui.model.RequestDetailsTableModel;
import gui.model.RequestTableModel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

/**
 *
 * @author EN
 */
public class RequestMake extends javax.swing.JInternalFrame {

    /**
     * Creates new form RequestMake
     */
    ProductsInterface eir = new ProductsRepository();
    ProductsTableModel etm = new ProductsTableModel();
    ProductsInterface eir2 = new ProductsRepository();
    ProductsTableModel etm2 = new ProductsTableModel();
    RequestDetailsTableModel rtm = new RequestDetailsTableModel();
    RequestDetailsInterface cir = new RequestDetailsRepository();
    RequestDetailsTableModel ctm = new RequestDetailsTableModel();
    RequestInterface reir = new RequestRepository();
    RequestTableModel retm = new RequestTableModel();
    
    private static Permission premission;
    private static Objects object;
    private static Title title;
    private static Users users;
    
    
    private JPopupMenu popupMenu;
    private JMenuItem menuItemAdd;
    private JMenuItem menuItemRemove;
    private JMenuItem menuItemRemoveAll;
    private int rowS;
    public RequestMake(Permission prem,Objects obj,Title tit,Users u) {
        premission = prem;
        object = obj;
        title = tit;
        users = u;
        initComponents();
        loadTable();
        loadTable2();
        tabelaSelectedIndexChange();
        tabelaRightClickedRow();
        popupMenu = new JPopupMenu();
        menuItemAdd = new JMenuItem("Edit Quantity");
        menuItemRemove = new JMenuItem("Remove Current Row");
        menuItemRemoveAll = new JMenuItem("Remove All Rows");
        
        menuItemAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                String m = JOptionPane.showInputDialog("Sasia");
                listProd.get(rowS).setQuantity(Integer.parseInt(m));
                loadTable2();
            }
        });
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
        
        popupMenu.add(menuItemAdd);
        popupMenu.add(menuItemRemove);
        popupMenu.add(menuItemRemoveAll);
        
        
        tabela2.setComponentPopupMenu(popupMenu);
        
    }
    List<RequestDetails> listProd = new ArrayList<>();
    public void loadTable2() {
        rtm.add(listProd);
        tabela2.setModel(rtm);
        rtm.fireTableDataChanged();
    }
    public void loadTable() {
        try {
            List<Products> list = eir.findAll();
            etm.add(list);
            tabela.setModel(etm);
            etm.fireTableDataChanged();
        } catch (SCHMException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    public void loadTable(Object obj) {
        try {
            List<Products> list = eir.findByObjectID(obj);
            etm.add(list);
            tabela.setModel(etm);
            etm.fireTableDataChanged();
        } catch (SCHMException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    public void loadTable(String n) {
        try {
            List<Products> list = eir.findByProductName(n);
            etm.add(list);
            tabela.setModel(etm);
            etm.fireTableDataChanged();
        } catch (SCHMException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    private void tabelaSelectedIndexChange() {
        tabela.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
             if (evt.getClickCount() == 2) {
                Point pnt = evt.getPoint();
                int row = tabela.rowAtPoint(pnt);
                Products c = etm.getProducts(row);
                String m = JOptionPane.showInputDialog("Sasia");
                listProd.add(new RequestDetails(Integer.parseInt(m),c,r));
                loadTable2();
             }
             else {
                 //do something else
             }
         }
     });
    }
    private void tabelaRightClickedRow() {
        tabela2.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent evt) {
                Point point = evt.getPoint();
                int currentRow = tabela2.rowAtPoint(point);
                rowS = currentRow;
                tabela2.setRowSelectionInterval(currentRow, currentRow);
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
        tabela = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela2 = new javax.swing.JTable();
        saveBT = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Search product by name:");

        productTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                productTFKeyReleased(evt);
            }
        });

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
        tabela.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabela);

        tabela2.setModel(new javax.swing.table.DefaultTableModel(
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
        tabela2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tabela2);

        saveBT.setText("Save");
        saveBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBTActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productTF, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 643, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ClearButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveBT)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(productTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBT)
                    .addComponent(ClearButton))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    Request r = new Request();
    private void saveBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBTActionPerformed
        
        if(!listProd.isEmpty()){
            r.setEmployeeID(users.getEmployees());
            r.setApproved(false);
            try {
                reir.create(r);
                for(RequestDetails rd: listProd){
                    cir.create(rd);
                }
            } catch (SCHMException es) {
                JOptionPane.showMessageDialog(this, es.getMessage());
                return;
            }
            JOptionPane.showMessageDialog(this, "Kerkesa ka perfunduar me sukses");
            listProd.clear();
            loadTable2();
            r = new Request();
        }else{
            JOptionPane.showMessageDialog(this, "Shto produktet ne list!");
        }
    }//GEN-LAST:event_saveBTActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        clearField();
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void productTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_productTFKeyReleased
        String name = productTF.getText();
        if(name.trim().isEmpty()){
            loadTable();
        }else {
            loadTable(name); 
        }
    }//GEN-LAST:event_productTFKeyReleased
    public void clearField() {
        listProd.clear();
        loadTable2();
  }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField productTF;
    private javax.swing.JButton saveBT;
    private javax.swing.JTable tabela;
    private javax.swing.JTable tabela2;
    // End of variables declaration//GEN-END:variables
}
