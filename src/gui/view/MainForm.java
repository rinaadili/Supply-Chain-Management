/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import BLL.Country;
import BLL.Objects;
import BLL.Offers;
import BLL.Permission;
import BLL.Products;
import BLL.Title;
import BLL.Users;
import DAL.OffersInterface;
import DAL.OffersRepository;
import DAL.PermissionInterface;
import DAL.PermissionRepository;
import DAL.ProductsInterface;
import DAL.ProductsRepository;
import DAL.SCHMException;
import gui.model.OffersTableModel;
import javax.swing.JFrame;
import gui.view.LoginForm;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author EN
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */

    private static Permission premission;
    private static Objects object;
    private static Title title;
    private static Users users;
    
    OffersInterface of = new OffersRepository();
    
    public MainForm(Permission prem,Objects obj,Title tit,Users u){
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        premission = prem;
        object = obj;
        title = tit;
        users = u;
        PermissionInterface pir = new PermissionRepository();
        Permission p = pir.findById(premission.getPermissionID());
        jMenuItem3.setEnabled(p.getEmployeesRead());
        jMenuItem4.setEnabled(p.getUsersRead());
        companyMenu.setEnabled(p.getObjectsRead());
        customerMenu.setEnabled(p.getCustomersRead());
        supplierMenu.setEnabled(p.getSuppliersRead());
        productMenu.setEnabled(p.getProductsRead());
        jMenuItem1.setEnabled(p.getRequestRead());
        jMenuItem2.setEnabled(p.getRequestMake());
        jMenuItem9.setEnabled(p.getOrdersRead());
        jMenuItem8.setEnabled(p.getSalesMake());
        jMenuItem5.setEnabled(p.getCountryRead());
        jMenuItem6.setEnabled(p.getCityRead());
        jMenuItem7.setEnabled(p.getTitleRead());
        checkValid();
        checkNotValid();
    }
    
    public void checkValid(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        Offers o;
        try {
            List<Offers> offers = of.findByObjectID(object);
            for(int i = 0; i< offers.size();i++){
                o = offers.get(i);
                if(o.getStartDate().getDate() == date.getDate() && o.getStartDate().getMonth() == date.getMonth() && o.getStartDate().getYear()== date.getYear() && o.getValid() == false){
                    o.setValid(true);
                    of.edit(o);
                }
            }
            
        } catch (SCHMException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
       public void checkNotValid(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        Offers o;
        try {
            List<Offers> offers = of.findByObjectID(object);
            for(int i = 0; i< offers.size();i++){
                o = offers.get(i);
                if(o.getEndDate().getDate() == date.getDate() && o.getEndDate().getMonth() == date.getMonth() && o.getEndDate().getYear()== date.getYear() && o.getValid() == true){
                    o.setValid(false);
                    of.edit(o);
                }
            }
            
        } catch (SCHMException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        employeeMenu = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        companyMenu = new javax.swing.JMenu();
        customerMenu = new javax.swing.JMenu();
        supplierMenu = new javax.swing.JMenu();
        supplierMenu1 = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        productMenu = new javax.swing.JMenu();
        productMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        Sales = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        offersMenu = new javax.swing.JMenu();
        reportMenu = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        pcategory = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        permissionMenu = new javax.swing.JMenuItem();
        permissionMenu1 = new javax.swing.JMenuItem();
        shippersMenu = new javax.swing.JMenuItem();
        logoutMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Supply Chain Management");

        desktopPane.setToolTipText("");

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 811, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
        );

        menuBar.setPreferredSize(new java.awt.Dimension(133, 35));

        employeeMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/components/icons8-name-tag-25.png"))); // NOI18N
        employeeMenu.setText("Employees");
        employeeMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeeMenuMouseClicked(evt);
            }
        });

        jMenuItem3.setText("Manage Employees");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        employeeMenu.add(jMenuItem3);

        jMenuItem4.setText("Manage Users");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        employeeMenu.add(jMenuItem4);

        menuBar.add(employeeMenu);

        companyMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/components/icons8-organization-25.png"))); // NOI18N
        companyMenu.setText("Objects");
        companyMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                companyMenuMouseClicked(evt);
            }
        });
        companyMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                companyMenuActionPerformed(evt);
            }
        });
        menuBar.add(companyMenu);

        customerMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/components/icons8-customer-25 (1).png"))); // NOI18N
        customerMenu.setText("Customers");
        customerMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerMenuMouseClicked(evt);
            }
        });
        customerMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerMenuActionPerformed(evt);
            }
        });
        menuBar.add(customerMenu);

        supplierMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/components/icons8-supplier-25.png"))); // NOI18N
        supplierMenu.setText("Suppliers");
        supplierMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supplierMenuMouseClicked(evt);
            }
        });
        supplierMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierMenuActionPerformed(evt);
            }
        });
        menuBar.add(supplierMenu);

        supplierMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/components/icons8-trolley-25 (2).png"))); // NOI18N
        supplierMenu1.setText("Inputs");
        supplierMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supplierMenu1MouseClicked(evt);
            }
        });
        supplierMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                supplierMenu1ActionPerformed(evt);
            }
        });

        jMenuItem12.setText("View All..");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        supplierMenu1.add(jMenuItem12);

        jMenuItem13.setText("Create New..");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        supplierMenu1.add(jMenuItem13);

        menuBar.add(supplierMenu1);

        productMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/components/icons8-product-25.png"))); // NOI18N
        productMenu.setText("Products");
        productMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productMenuMouseClicked(evt);
            }
        });
        productMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productMenuActionPerformed(evt);
            }
        });
        menuBar.add(productMenu);

        productMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/components/icons8-inspection-25.png"))); // NOI18N
        productMenu1.setText("Request");
        productMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productMenu1MouseClicked(evt);
            }
        });

        jMenuItem1.setText("View All..");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        productMenu1.add(jMenuItem1);

        jMenuItem2.setText("Create New..");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        productMenu1.add(jMenuItem2);

        menuBar.add(productMenu1);

        Sales.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/components/icons8-add-shopping-cart-25.png"))); // NOI18N
        Sales.setText("Sales");
        Sales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SalesMouseClicked(evt);
            }
        });

        jMenuItem8.setText("Make a Sale..");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        Sales.add(jMenuItem8);

        jMenuItem9.setText("Orders List..");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        Sales.add(jMenuItem9);

        menuBar.add(Sales);

        offersMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/components/icons8-sale-25.png"))); // NOI18N
        offersMenu.setText("Offers");
        offersMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                offersMenuMouseClicked(evt);
            }
        });
        menuBar.add(offersMenu);

        reportMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/components/icons8-presentation-25.png"))); // NOI18N
        reportMenu.setText("Reports");
        reportMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportMenuMouseClicked(evt);
            }
        });

        jMenuItem10.setText("Orders");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        reportMenu.add(jMenuItem10);

        menuBar.add(reportMenu);

        pcategory.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/components/icons8-settings-25.png"))); // NOI18N
        pcategory.setText("Settings");
        pcategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pcategoryMouseClicked(evt);
            }
        });

        jMenuItem5.setText("Country..");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        pcategory.add(jMenuItem5);

        jMenuItem6.setText("City..");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        pcategory.add(jMenuItem6);

        jMenuItem7.setText("Title");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        pcategory.add(jMenuItem7);

        permissionMenu.setText("Permission");
        permissionMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permissionMenuActionPerformed(evt);
            }
        });
        pcategory.add(permissionMenu);

        permissionMenu1.setText("ProductCategory");
        permissionMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permissionMenu1ActionPerformed(evt);
            }
        });
        pcategory.add(permissionMenu1);

        shippersMenu.setText("Shippers");
        shippersMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shippersMenuActionPerformed(evt);
            }
        });
        pcategory.add(shippersMenu);

        menuBar.add(pcategory);

        logoutMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/components/icons8-shutdown-25.png"))); // NOI18N
        logoutMenu.setText("Logout");
        logoutMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutMenuMouseClicked(evt);
            }
        });
        menuBar.add(logoutMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane)
        );

        desktopPane.getAccessibleContext().setAccessibleName("Supply Chain Management");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void employeeMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeMenuMouseClicked
        
    }//GEN-LAST:event_employeeMenuMouseClicked

    private void companyMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_companyMenuMouseClicked
        if(companyMenu.isEnabled()){
            ObjectsForm cf = new ObjectsForm(premission);
            desktopPane.add(cf);
            cf.show(); 
        }
    }//GEN-LAST:event_companyMenuMouseClicked

    private void customerMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerMenuMouseClicked
        if(customerMenu.isEnabled()){
            CustomerForm cuf = new CustomerForm();
            desktopPane.add(cuf);
            cuf.show();
        }
    }//GEN-LAST:event_customerMenuMouseClicked

    private void supplierMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierMenuMouseClicked
        if(supplierMenu.isEnabled()){
            SupplierForm sf = new SupplierForm();
            desktopPane.add(sf);
            sf.show();
        }
    }//GEN-LAST:event_supplierMenuMouseClicked

    private void productMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productMenuMouseClicked
       if(supplierMenu.isEnabled()){
            ProductsForm cf = new ProductsForm(premission,object,title);
            desktopPane.add(cf);
            cf.show();
        }
    }//GEN-LAST:event_productMenuMouseClicked

    private void productMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productMenu1MouseClicked
        
    }//GEN-LAST:event_productMenu1MouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        RequestView cf = new RequestView(premission,object,title,users);
        desktopPane.add(cf);
        cf.show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        RequestMake cf = new RequestMake(premission,object,title,users);
        desktopPane.add(cf);
        cf.show();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        if(employeeMenu.isEnabled()){
            EmployeesForm ef = new EmployeesForm(premission,object,title);
            desktopPane.add(ef);
            ef.show();
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        UsersForm cf = new UsersForm(premission,object,title,users);
        desktopPane.add(cf);
        cf.show();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        CountryForm cf = new CountryForm();
        desktopPane.add(cf);
        cf.show();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        CityForm cf = new CityForm();
        desktopPane.add(cf);
        cf.show();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void pcategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pcategoryMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pcategoryMouseClicked

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        TitleForm cf = new TitleForm();
        desktopPane.add(cf);
        cf.show();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        MakeASale ms = new MakeASale(premission,object,title,users);
        desktopPane.add(ms);
        ms.show();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void SalesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_SalesMouseClicked

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        OrdersForm of = new OrdersForm(premission,object,title);
        desktopPane.add(of);
        of.show();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void logoutMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMenuMouseClicked
        Object[] ob = {"Yes", "Cancel"};
        int i = JOptionPane.showOptionDialog(this, "Are you sure you want to log out?", "Logout", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
        if (i == 0) {
            this.dispose();
            LoginForm lf = new LoginForm();
            lf.setVisible(true);
        }
    }//GEN-LAST:event_logoutMenuMouseClicked

    private void companyMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_companyMenuActionPerformed
        
    }//GEN-LAST:event_companyMenuActionPerformed

    private void customerMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customerMenuActionPerformed
        
    }//GEN-LAST:event_customerMenuActionPerformed

    private void supplierMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierMenuActionPerformed
        
    }//GEN-LAST:event_supplierMenuActionPerformed

    private void productMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productMenuActionPerformed

    }//GEN-LAST:event_productMenuActionPerformed

    private void permissionMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_permissionMenuActionPerformed
        PermissionForm of = new PermissionForm(premission);
        desktopPane.add(of);
        of.show();
    }//GEN-LAST:event_permissionMenuActionPerformed

    private void permissionMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_permissionMenu1ActionPerformed
        ProductCategoryForm of = new ProductCategoryForm();
        desktopPane.add(of);
        of.show();
    }//GEN-LAST:event_permissionMenu1ActionPerformed

    private void shippersMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shippersMenuActionPerformed
       ShippersForm of = new ShippersForm();
        desktopPane.add(of);
        of.show();
    }//GEN-LAST:event_shippersMenuActionPerformed

    private void offersMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_offersMenuMouseClicked
        OffersForm of = new OffersForm(premission,object,title);
        desktopPane.add(of);
        of.show();
    }//GEN-LAST:event_offersMenuMouseClicked

    private void supplierMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supplierMenu1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_supplierMenu1MouseClicked

    private void supplierMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_supplierMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_supplierMenu1ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        InputView cf = new InputView(premission,object,title,users);
        desktopPane.add(cf);
        cf.show();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        AddProductForm ms = new AddProductForm(premission,object,title,users);
        desktopPane.add(ms);
        ms.show();
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void reportMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportMenuMouseClicked
        
    }//GEN-LAST:event_reportMenuMouseClicked

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        OrdersReportsForm ms = new OrdersReportsForm();
        desktopPane.add(ms);
        ms.show();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm(premission,object,title,users).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Sales;
    private javax.swing.JMenu companyMenu;
    private javax.swing.JMenu customerMenu;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenu employeeMenu;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenu logoutMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu offersMenu;
    private javax.swing.JMenu pcategory;
    private javax.swing.JMenuItem permissionMenu;
    private javax.swing.JMenuItem permissionMenu1;
    private javax.swing.JMenu productMenu;
    private javax.swing.JMenu productMenu1;
    private javax.swing.JMenu reportMenu;
    private javax.swing.JMenuItem shippersMenu;
    private javax.swing.JMenu supplierMenu;
    private javax.swing.JMenu supplierMenu1;
    // End of variables declaration//GEN-END:variables

}
