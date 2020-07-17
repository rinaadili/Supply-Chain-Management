/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;


import BLL.City;
import BLL.Country;
import BLL.Objects;
import BLL.Permission;
import DAL.CityInterface;
import DAL.CityRepository;
import DAL.CountryInterface;
import DAL.CountryRepository;
import DAL.SCHMException;
import DAL.ObjectsRepository;
import gui.model.ObjectsTableModel;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.beans.PropertyVetoException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import DAL.ObjectsInterface;
import gui.model.CityComboBoxModel;
import gui.model.CountryComboBoxModel;
import java.awt.event.ActionListener;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
/**
 *
 * @author EN
 */
public class ObjectsForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form EmployeeForm
     */
    ObjectsInterface cir = new ObjectsRepository();
    ObjectsTableModel ctm = new ObjectsTableModel();
    CountryInterface coir = new CountryRepository();
    CityInterface cyir = new CityRepository();
    
    CountryComboBoxModel ccbbm;
    CityComboBoxModel cycbbm;
    
        public static boolean isValidEmailAddress(String email) {
            boolean result = true;
            try {
               InternetAddress emailAddr = new InternetAddress(email);
               emailAddr.validate();
            } catch (AddressException ex) {
               result = false;
            }
            return result;
        }
    
    private static Permission premission;
    public ObjectsForm(Permission prem){
        premission = prem;
        initComponents();
        if(!premission.getObjectsManage()){
            saveBtn.setEnabled(false);
            deleteBtn.setEnabled(false);
        }
        loadTable();
        tabelaSelectedIndexChange();
        populateCountryComboBox();
        cityCB.setEnabled(false);
    }
    public void populateCountryComboBox() {
        try {
            List<Country> list = coir.findAll();
            ccbbm = new CountryComboBoxModel(list);
            countryCB.setModel(ccbbm);
            countryCB.repaint();
            countryCB.addActionListener (new ActionListener () {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    if(countryCB.getSelectedIndex() != -1){
                        Country co = (Country) countryCB.getSelectedItem();
                        populateCityComboBox(co);
                        cityCB.setEnabled(true);
                    }else{
                        cityCB.setEnabled(false);
                    }
                }
            });
        } catch (SCHMException ex) {

        }
    }
    public void populateCityComboBox(Country id) {
        try {
            List<City> list = cyir.findByCountryID(id);
            cycbbm = new CityComboBoxModel(list);
            cityCB.setModel(cycbbm);
            cityCB.repaint();
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
                    Objects c = ctm.getObjects(selectedIndex);
                    emriTF.setText(c.getCompanyName()+ "");
                    telefoniTF.setText(c.getPhone()+"");
                    adresaTF.setText(c.getAddress());
                    countryCB.setSelectedItem(c.getCityID().getCountryID());
                    countryCB.repaint();
                    cityCB.setSelectedItem(c.getCityID());
                    cityCB.repaint();
                    emailTF.setText(c.getEmail());
                    
                }
            }
        });
    }
    
    public void loadTable() {
        try {
            List<Objects> list = cir.findAll();
            ctm.add(list);
            tabela.setModel(ctm);
            ctm.fireTableDataChanged();
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        emriTF = new javax.swing.JTextField();
        adresaTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        emailTF = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        telefoniTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        saveBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        countryCB = new javax.swing.JComboBox();
        cityCB = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Objects");

        jLabel1.setText("* Adresa:");

        jLabel4.setText("* Emri:");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, telefoniTF, org.jdesktop.beansbinding.ObjectProperty.create(), emriTF, org.jdesktop.beansbinding.BeanProperty.create("nextFocusableComponent"));
        bindingGroup.addBinding(binding);

        emriTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emriTFActionPerformed(evt);
            }
        });

        adresaTF.setMinimumSize(new java.awt.Dimension(6, 19));
        adresaTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adresaTFActionPerformed(evt);
            }
        });

        jLabel6.setText("* Country: ");

        jLabel7.setText("Email:");

        emailTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTFActionPerformed(evt);
            }
        });

        jLabel9.setText("* Telefoni:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, adresaTF, org.jdesktop.beansbinding.ObjectProperty.create(), telefoniTF, org.jdesktop.beansbinding.BeanProperty.create("nextFocusableComponent"));
        bindingGroup.addBinding(binding);

        telefoniTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefoniTFActionPerformed(evt);
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

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        cancelBtn.setText("Clear");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });

        jLabel8.setText("* City: ");

        jLabel2.setText("* Indicates required field");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 645, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(saveBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelBtn))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(emriTF, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                            .addComponent(telefoniTF)
                            .addComponent(emailTF))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(countryCB, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cityCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(adresaTF, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(emriTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(adresaTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(cityCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(telefoniTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(countryCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveBtn)
                    .addComponent(deleteBtn)
                    .addComponent(cancelBtn)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adresaTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adresaTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adresaTFActionPerformed

    private void emailTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTFActionPerformed

    private void telefoniTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefoniTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefoniTFActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        if (!emriTF.getText().trim().equals("") && !telefoniTF.getText().trim().equals("") && !adresaTF.getText().trim().equals("")
            && cityCB.getSelectedIndex() != -1 && !emailTF.getText().trim().equals("") 
                && isValidEmailAddress(emailTF.getText())) {
            int row = tabela.getSelectedRow();
            if (row == -1) {
                Objects c = new Objects();
                c.setCompanyName(emriTF.getText());
                c.setPhone(telefoniTF.getText());
                c.setAddress(adresaTF.getText());
                c.setCityID((City) cityCB.getSelectedItem());
                c.setEmail(emailTF.getText());
                try {
                    cir.create(c);
                } catch (SCHMException es) {
                    JOptionPane.showMessageDialog(this, es.getMessage());
                    return;
                }
            } else {
                Objects c = ctm.getObjects(row);
                c.setCompanyName(emriTF.getText());
                c.setPhone(telefoniTF.getText());
                c.setAddress(adresaTF.getText());
                c.setCityID((City) cityCB.getSelectedItem());
                c.setEmail(emailTF.getText());
                try {
                    cir.edit(c);
                } catch (SCHMException es) {
                    JOptionPane.showMessageDialog(this, es.getMessage());
                    return;
                }
                
            }
            clearFild();
            loadTable();

        } else {
            JOptionPane.showMessageDialog(this, "Ju lutem plotesoni te gjitha fushat obligative!");
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        clearFild();
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int row = tabela.getSelectedRow();
        if (row > -1) {
            Object[] ob = {"Po", "Jo"};
            int i = JOptionPane.showOptionDialog(this, "A dëshironi ta fshini ?", "Fshirja", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
            if (i == 0) {
                Objects c = ctm.getObjects(row);
                try {
                    cir.delete(c);
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
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void emriTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emriTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emriTFActionPerformed
    public void clearFild() {
        tabela.clearSelection();
        emriTF.setText("");
        telefoniTF.setText("");
        adresaTF.setText("");
        countryCB.setSelectedIndex(-1);
        countryCB.repaint();
        cityCB.setEnabled(false);
        cityCB.setSelectedIndex(-1);
        cityCB.repaint();
        emailTF.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adresaTF;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JComboBox cityCB;
    private javax.swing.JComboBox countryCB;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField emailTF;
    private javax.swing.JTextField emriTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTable tabela;
    private javax.swing.JTextField telefoniTF;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
