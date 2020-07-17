/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import BLL.City;
import BLL.Country;
import BLL.Customer;
import DAL.CityInterface;
import DAL.CityRepository;
import DAL.CountryInterface;
import DAL.CountryRepository;
import DAL.CustomerInterface;
import DAL.CustomerRepository;
import DAL.SCHMException;
import gui.model.CityComboBoxModel;
import gui.model.CountryComboBoxModel;
import gui.model.CustomerTableModel;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.List;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author cc.ks
 */
public class CustomerForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form CustomerForm
     */
    
    CustomerInterface cir = new CustomerRepository();
    CustomerTableModel ctm = new CustomerTableModel();
    CountryInterface coir = new CountryRepository();
    CityInterface cyir = new CityRepository();
    
    CountryComboBoxModel ccbbm;
    CityComboBoxModel cycbbm;
    
    public CustomerForm() {
        initComponents();
        loadTable();
        tabeleSelectedIndexChange();
        populateCountryComboBox();
        cityCB.setEnabled(false);
        birthdateDC.getJCalendar().getYearChooser().setMinimum(Calendar.getInstance().get(Calendar.YEAR)-66);
        birthdateDC.getJCalendar().getYearChooser().setMaximum(Calendar.getInstance().get(Calendar.YEAR)-17);
    }

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
    
    private void tabeleSelectedIndexChange() {
        synchronized(this){
        final ListSelectionModel rowSM = ctable.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent Ise) {
                if (Ise.getValueIsAdjusting()) {
                    return;
                }
                ListSelectionModel rowSM = (ListSelectionModel) Ise.getSource();
                int selectedIndex = rowSM.getAnchorSelectionIndex();
                if (selectedIndex > -1) {
                    Customer c = ctm.getCustomer(selectedIndex);
                    AddressTF.setText(c.getAddress());
                    CustomerSurnameTF.setText(c.getCustomerSurname());
                    birthdateDC.setDate(c.getCustomerBirthdate());
                    CustomerNameTF.setText(c.getCustomerName());
                    EmailTF.setText(c.getEmail());
                    PhoneTF.setText(c.getPhone()+""); 
                    if(c.getSex() == true){
                        mRB.setSelected(true);
                    }else {
                        fRB.setSelected(true);;
                    }
                    countryCB.setSelectedItem(c.getCityID().getCountryID());
                    countryCB.repaint();
                    cityCB.setSelectedItem(c.getCityID());
                    cityCB.repaint();
                }
            }
        });
        }
    }
    
     public void loadTable() {
        try {
            List<Customer> list = cir.findAll();
            ctm.add(list);
            ctable.setModel(ctm);
            ctm.fireTableDataChanged();
        } catch (SCHMException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        AddressTF = new javax.swing.JTextField();
        CustomerNameTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        PhoneTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ctable = new javax.swing.JTable();
        SaveButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        EmailTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        CustomerSurnameTF = new javax.swing.JTextField();
        cityCB = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        countryCB = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        mRB = new javax.swing.JRadioButton();
        fRB = new javax.swing.JRadioButton();
        birthdateDC = new com.toedter.calendar.JDateChooser();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Konsumatoret");

        jLabel1.setText("Name:");

        jLabel2.setText("Address:");

        jLabel3.setText("City:");

        AddressTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddressTFActionPerformed(evt);
            }
        });

        jLabel6.setText("Phone:");

        PhoneTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhoneTFActionPerformed(evt);
            }
        });

        ctable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(ctable);

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

        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("Email");

        jLabel5.setText("Surname:");

        jLabel7.setText("Country:");

        countryCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                countryCBActionPerformed(evt);
            }
        });

        jLabel8.setText("Birthdate:");

        jLabel9.setText("Gender:");

        buttonGroup1.add(mRB);
        mRB.setText("M");

        buttonGroup1.add(fRB);
        fRB.setText("F");
        fRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fRBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(SaveButton)
                        .addGap(18, 18, 18)
                        .addComponent(DeleteButton)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 959, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CustomerNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(countryCB, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                                .addComponent(jLabel9))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(CustomerSurnameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(AddressTF, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel8)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(birthdateDC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cityCB, 0, 112, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EmailTF, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(mRB)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fRB))
                            .addComponent(PhoneTF, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(CustomerSurnameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(cityCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CustomerNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(countryCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)
                                .addComponent(mRB)
                                .addComponent(fRB)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(PhoneTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(EmailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(AddressTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addComponent(birthdateDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SaveButton)
                    .addComponent(DeleteButton)
                    .addComponent(jButton3))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddressTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddressTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddressTFActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int age = year - birthdateDC.getJCalendar().getYearChooser().getYear();
        if (!AddressTF.getText().trim().equals("")  &&
            !PhoneTF.getText().trim().equals("") && !CustomerNameTF.getText().trim().equals("") 
            && !EmailTF.getText().trim().equals("") && (age > 18 && age < 65)
                && isValidEmailAddress(EmailTF.getText()))
             {
            int row = ctable.getSelectedRow();
            if (row == -1) {
                Customer c = new Customer();
                c.setCustomerName(CustomerNameTF.getText());
                c.setCustomerSurname(CustomerSurnameTF.getText());
                c.setAddress(AddressTF.getText());
                c.setEmail(EmailTF.getText());
                c.setPhone(PhoneTF.getText());
                c.setCustomerBirthdate(birthdateDC.getDate());
                c.setCityID((City) cityCB.getSelectedItem());
                 if(mRB.isSelected()){
                    c.setSex(true);
                }else{
                    c.setSex(false);
                }

                try {
                    cir.create(c);
                } catch (SCHMException es) {
                    JOptionPane.showMessageDialog(this, es.getMessage());
                    return;
                }
            } else {
                Customer c = ctm.getCustomer(row);
                 c.setCustomerName(CustomerNameTF.getText());
                c.setCustomerSurname(CustomerSurnameTF.getText());
                c.setAddress(AddressTF.getText());
                c.setEmail(EmailTF.getText());
                c.setPhone(PhoneTF.getText());
                c.setCustomerBirthdate(birthdateDC.getDate());
                c.setCityID((City) cityCB.getSelectedItem());
                 if(mRB.isSelected()){
                    c.setSex(true);
                }else{
                    c.setSex(false);
                }

                try {
                    cir.edit(c);
                } catch (SCHMException es) {
                    JOptionPane.showMessageDialog(this, es.getMessage());
                    return;
                }               
            }
            clearField();
            loadTable();

        } else {
            JOptionPane.showMessageDialog(this, "Fushat nuk jane plotesuar ne menyre te rregullt!");
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        int row = ctable.getSelectedRow();
        if (row > -1) {
            Object[] ob = {"Po", "Jo"};
            int i = JOptionPane.showOptionDialog(this, "A dëshironi ta fshini ?", "Fshirja", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
            if (i == 0) {
                Customer c = ctm.getCustomer(row);
                try {
                    cir.delete(c);
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        clearField();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void PhoneTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhoneTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhoneTFActionPerformed

    private void fRBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fRBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fRBActionPerformed

    private void countryCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_countryCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_countryCBActionPerformed

 public void clearField() {
        ctable.clearSelection();
        AddressTF.setText("");
        CustomerSurnameTF.setText("");
        CustomerNameTF.setText("");
        EmailTF.setText("");
        PhoneTF.setText("");
        birthdateDC.setDate(null);
        countryCB.setSelectedIndex(-1);
        countryCB.repaint();
        cityCB.setEnabled(false);
        cityCB.setSelectedIndex(-1);
        cityCB.repaint();
        mRB.setSelected(false);
        fRB.setSelected(false);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AddressTF;
    private javax.swing.JTextField CustomerNameTF;
    private javax.swing.JTextField CustomerSurnameTF;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JTextField EmailTF;
    private javax.swing.JTextField PhoneTF;
    private javax.swing.JButton SaveButton;
    private com.toedter.calendar.JDateChooser birthdateDC;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cityCB;
    private javax.swing.JComboBox countryCB;
    private javax.swing.JTable ctable;
    private javax.swing.JRadioButton fRB;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton mRB;
    // End of variables declaration//GEN-END:variables
}
