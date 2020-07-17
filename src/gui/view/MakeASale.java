/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import BLL.Customer;
import BLL.Shippers;
import BLL.Employees;
import BLL.InputDetails;
import BLL.Inputs;
import BLL.Objects;
import BLL.Offers;
import BLL.OrderDetails;
import BLL.Orders;
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
import DAL.OffersInterface;
import DAL.OffersRepository;
import DAL.OrderDetailsInterface;
import DAL.OrderDetailsRespiratory;
import DAL.OrdersInterface;
import DAL.OrdersRespiratory;
import DAL.ProductsInterface;
import DAL.ProductsRepository;
import DAL.SCHMException;
import DAL.ShippersInterface;
import DAL.ShippersRepository;
import gui.model.CustomerComboBoxModel;
import gui.model.OrderDetailsSaleTableModel;
import gui.model.OrderDetailsTableModel;
import gui.model.OrdersTableModel;
import gui.model.ProductsSaleTableModel;
import gui.model.ProductsTableModel;
import gui.model.ShippersComboBoxModel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
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
public class MakeASale extends javax.swing.JInternalFrame {

    /**
     * Creates new form MakeASale
     */
    
    ProductsInterface eir = new ProductsRepository();
    ProductsSaleTableModel etm = new ProductsSaleTableModel();
    ProductsInterface eir2 = new ProductsRepository();
    ProductsSaleTableModel etm2 = new ProductsSaleTableModel();
    OrderDetailsSaleTableModel rtm = new OrderDetailsSaleTableModel();
    OrderDetailsInterface cir = new OrderDetailsRespiratory();
    OrderDetailsSaleTableModel ctm = new OrderDetailsSaleTableModel();
    OrdersInterface reir = new OrdersRespiratory();
    OrdersTableModel retm = new OrdersTableModel();
    List<OrderDetails> listProd = new ArrayList<>();
    CustomerInterface ci = new CustomerRepository();
    ShippersInterface si = new ShippersRepository();
    InputsInterface iir = new InputsRespiratory();
    InputDetailsInterface idir = new InputDetailsRespiratory();
    OffersInterface of = new OffersRepository();
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
    public MakeASale(Permission prem,Objects obj,Title tit,Users u) {
        premission = prem;
        object = obj;
        title = tit;
        users = u;
        initComponents();
        loadTable();
        loadTable2();
        tabelaSelectedIndexChange();
        populateCustomerComboBox();
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
    
    public void populateCustomerComboBox() {
        try {
            List<Customer> list = ci.findAll();
            ccbm = new CustomerComboBoxModel(list);
            CustomerCB.setModel(ccbm);
            CustomerCB.repaint();
        } catch (SCHMException ex) {

        }
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
    Orders o = new Orders();
    private static DecimalFormat df2 = new DecimalFormat(".##");
    private void tabelaSelectedIndexChange() {
        table1.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent evt) {
            if (evt.getClickCount() == 2) {
                Point pnt = evt.getPoint();
                int row = table1.rowAtPoint(pnt);
                c = etm.getProducts(row);
                int tP=0;
                for(int i = 0; i < listProd.size(); i++){
                    if(listProd.get(i).getProductID().getProductID() == c.getProductID()){
                        tP += listProd.get(i).getQuantityOrdered();
                    }
                }
                String m = JOptionPane.showInputDialog("Sasia");
                quantity = Integer.parseInt(m);
                if(kalkuloSasin(c) == -100000 || kalkuloSasin(c) < tP+ quantity){
                    JOptionPane.showMessageDialog(null,"Nuk ka sasi te mjaftueshme te produktit");
                }else {
                    try {
                        double d = 0;
                        List<Offers> offers = of.findByObjectID(object);
                        for(int i = 0; i < offers.size();i++){
                            if(offers.get(i).getValid() && c.getCategoryID().getCategoryID() == offers.get(i).getProductCategoryID().getCategoryID()){
                                d = offers.get(i).getDiscountPrs();
                            }
                        } 
                        double t = c.getSellPrice();
                        double total = Double.parseDouble(df2.format((t * quantity)));
                        double pay = 0;
                        if(d == 0){
                            pay = total;
                            
                        }else {
                            pay = ((t * quantity)*(1- (d/100)));
                        }
                        listProd.add(new OrderDetails(o,c,quantity,d,total,pay));
                        loadTable2();
                        TotalTF.setText((kalkuloTotal())+"");
                    } catch (SCHMException ex) {
                        Logger.getLogger(MakeASale.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
             }
             else {
                 //do something else 
             }
         }
     });
    }
    public double kalkuloTotal(){
        double total= 0;
        for (int i = 0; i < listProd.size(); i++) {
            total += listProd.get(i).getTotalPriceDsc();
        }
        return total;
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
    private int kalkuloSasin(Products p1){
        try {
            List<Inputs> listInput = iir.findAll();
            Products p = eir.findById(p1.getProductID());
            int countI = 0;
            for(int i = 0 ; i < listInput.size(); i++){
                if(listInput.get(i).getObjectID().getObjectID() == object.getObjectID()){
                    List<InputDetails> list = idir.findByInputDetails(listInput.get(i),p);
                    for(int j = 0 ; j < list.size(); j++){
                        countI += list.get(j).getQuantity();
                    }  
                }
                
            }
            int countO = 0;
            List<Orders> listOrders = reir.findAll();
            for(int i = 0 ; i < listOrders.size(); i++){
                if(listOrders.get(i).getObjectID().getObjectID() == object.getObjectID()){
                    List<OrderDetails> list = cir.findByOrderIDProductID(listOrders.get(i), p);
                    for(int j = 0 ; j < list.size(); j++){
                        countO += list.get(j).getQuantityOrdered();
                    }
                }
            }
            return countI - countO;
        } catch (SCHMException ex) {
            Logger.getLogger(this.getName()).log(Level.SEVERE, null, ex);
            return -100000;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        SaveButton = new javax.swing.JButton();
        TotalTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CustomerCB = new javax.swing.JComboBox();
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

        SaveButton.setText("Take Payment");
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("TotalAmount:");

        jLabel6.setText("Shipper:");

        jLabel7.setText("Customer:");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 575, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(238, 238, 238)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(TotalTF, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(ClearButton)
                        .addGap(144, 144, 144)))
                .addGap(57, 57, 57))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(productTF, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(132, 132, 132)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(CustomerCB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(ShipperCB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 52, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(productTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(CustomerCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ShipperCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(ClearButton))
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TotalTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addContainerGap())))
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
            o.setCustomerID((Customer) ccbm.getSelectedItem());
            o.setEmployeeID(users.getEmployees());
            o.setOrderDate(new Date(dateFormat.format(date)));
            o.setShipperID((Shippers)ShipperCB.getSelectedItem());
            o.setObjectID(new Objects(object.getObjectID()));
            
            try {
                reir.create(o);
                for(OrderDetails rd: listProd){
                    cir.create(rd);
                }
//                zbritSasin();
            } catch (SCHMException es) {
                JOptionPane.showMessageDialog(this, es.getMessage());
                return;
            }
            JOptionPane.showMessageDialog(this, "Shitja eshte realizuar me sukses!");
            clearField();
            loadTable2();
            loadTable();
            o = new Orders();
        }else{
            JOptionPane.showMessageDialog(this, "Shto produktet ne list!");
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

     public void clearField() {
        listProd.clear();
        loadTable2();
        CustomerCB.setSelectedIndex(-1);
        CustomerCB.repaint();
        ShipperCB.setSelectedIndex(-1);
        ShipperCB.repaint();
        TotalTF.setText("");
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
    private javax.swing.JComboBox CustomerCB;
    private javax.swing.JButton SaveButton;
    private javax.swing.JComboBox ShipperCB;
    private javax.swing.JTextField TotalTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField productTF;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    // End of variables declaration//GEN-END:variables
}
