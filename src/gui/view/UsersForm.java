/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import BLL.Employees;
import BLL.Objects;
import BLL.Permission;
import BLL.Title;
import BLL.Users;
import DAL.EmployeeInterface;
import DAL.EmployeeRepository;
import DAL.PermissionInterface;
import DAL.PermissionRepository;
import DAL.SCHMException;
import DAL.UsersInterface;
import DAL.UsersRepository;
import gui.model.EmployeeComboBoxModel;
import gui.model.PermissionComboBoxModel;
import gui.model.UsersTableModel;
import java.awt.event.ActionListener;
import java.security.MessageDigest;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author RA
 */
public class UsersForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form UsersForm
     */
    
    UsersInterface uir = new UsersRepository();
    UsersTableModel utm = new UsersTableModel();
    PermissionInterface pir = new PermissionRepository();
    EmployeeInterface eir = new EmployeeRepository();
    PermissionComboBoxModel pcbbm;
    EmployeeComboBoxModel ecbbm;
    
    private static Permission premission;
    private static Objects object;
    private static Title title;
    private static Users users;
    
    public UsersForm(Permission prem,Objects obj,Title tit,Users u) {
        initComponents();
        premission = prem;
        object = obj;
        title = tit;
        users = u;
        if(object.getObjectID() == 1){
            loadTable();
        }else {
            loadTable(object);
        }
        
        tabeleSelectedIndexChange();
        populatePermissionComboBox();
        populateEmployeeComboBox();
    }
    public static String md5(String msg) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(msg.getBytes());
            byte byteData[] = md.digest();
            //convert the byte to hex format method 1
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            return  sb.toString();
        } catch (Exception ex) {
            return "";
        }
    }
    private void tabeleSelectedIndexChange() {
        final ListSelectionModel rowSM = utable.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Users u = utm.getUser(selectedIndex);
                    employeeCB.setSelectedItem(u.getEmployees());
                    employeeCB.repaint();
                    UsernameTF.setText(u.getUsername());
                    permissionCB.setSelectedItem(u.getPermissionID());
                    permissionCB.repaint();
                }
            }
        });
    }
    
     public void populatePermissionComboBox() {
        try {
            List<Permission> list = pir.findAll();
            pcbbm = new PermissionComboBoxModel(list);
            permissionCB.setModel(pcbbm);
            permissionCB.repaint();
        } catch (SCHMException ex) {

        }
    }
     
    public void populateEmployeeComboBox() {
        try {
            List<Employees> list = eir.findAll();
            ecbbm = new EmployeeComboBoxModel(list);
            employeeCB.setModel(ecbbm);
            employeeCB.repaint();
        } catch (SCHMException ex) {

        }
    }
    
      public void loadTable() {
        try {
            List<Users> list = uir.findAll();
            utm.add(list);
            utable.setModel(utm);
            utm.fireTableDataChanged();
            utable.repaint();
        } catch (SCHMException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }
      public void loadTable(Objects o) {
        try {
            List<Users> list = uir.findByObjectID(o);
            utm.add(list);
            utable.setModel(utm);
            utm.fireTableDataChanged();
            utable.repaint();
        } catch (SCHMException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }
      
 
      
       public void clearField() {
        utable.clearSelection();
        employeeCB.setSelectedIndex(-1);
        employeeCB.repaint();
        UsernameTF.setText("");
        PasswordTF.setText("");
        permissionCB.setSelectedIndex(-1);
        permissionCB.repaint();
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
        jLabel2 = new javax.swing.JLabel();
        UsernameTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        utable = new javax.swing.JTable();
        SaveButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        ClearButton = new javax.swing.JButton();
        permissionCB = new javax.swing.JComboBox();
        employeeCB = new javax.swing.JComboBox();
        PasswordTF = new javax.swing.JPasswordField();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setText("Employee:");

        jLabel2.setText("Username:");

        jLabel3.setText("Password:");

        jLabel4.setText("Permission:");

        utable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(utable);

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
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(20, 20, 20)
                        .addComponent(employeeCB, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(permissionCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(UsernameTF, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(PasswordTF))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(SaveButton)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteButton)
                        .addGap(18, 18, 18)
                        .addComponent(ClearButton)
                        .addGap(59, 59, 59))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(employeeCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(UsernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(permissionCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SaveButton)
                            .addComponent(DeleteButton)
                            .addComponent(ClearButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(PasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 445, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        if (employeeCB.getSelectedIndex() != -1 && !UsernameTF.getText().trim().equals("") &&
            !PasswordTF.getText().trim().equals("") && permissionCB.getSelectedIndex() != -1) {
            int row = utable.getSelectedRow();
            if (row == -1) {
                Users u = new Users();
                Employees e = new Employees();
                e = (Employees)employeeCB.getSelectedItem();
                u.setEmployees(e);
                u.setEmployeeID(e.getEmployeeID());
                u.setUsername(UsernameTF.getText());
                u.setPassword(md5(PasswordTF.getText()));
                u.setPermissionID((Permission) permissionCB.getSelectedItem());

                try {
                    uir.create(u);
                } catch (SCHMException es) {
                    JOptionPane.showMessageDialog(this, es.getMessage());
                    return;
                }
            } else {
                Users u = utm.getUser(row);
                u.setEmployees((Employees)employeeCB.getSelectedItem());
                u.setUsername(UsernameTF.getText());
                u.setPassword(md5(PasswordTF.getText()));
                u.setPermissionID((Permission) permissionCB.getSelectedItem());

                try {
                    uir.edit(u);
                } catch (SCHMException es) {
                    JOptionPane.showMessageDialog(this, es.getMessage());
                    return;
                }               
            }
            clearField();
            loadTable();

        } else {
            JOptionPane.showMessageDialog(this, "Ju lutem plotesoni te gjitha fushat obligative!");
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
         int row = utable.getSelectedRow();
        if (row > -1) {
            Object[] ob = {"Po", "Jo"};
            int i = JOptionPane.showOptionDialog(this, "A dëshironi ta fshini ?", "Fshirja", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
            if (i == 0) {
                Users u = utm.getUser(row);
                try {
                    uir.delete(u);
                } catch (SCHMException es) {
                    JOptionPane.showMessageDialog(this, es.getMessage());
                }
                clearField();
                loadTable();
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JPasswordField PasswordTF;
    private javax.swing.JButton SaveButton;
    private javax.swing.JTextField UsernameTF;
    private javax.swing.JComboBox employeeCB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox permissionCB;
    private javax.swing.JTable utable;
    // End of variables declaration//GEN-END:variables
}
