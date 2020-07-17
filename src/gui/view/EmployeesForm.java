/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import BLL.City;
import BLL.Company;
import BLL.Country;
import BLL.Employees;
import BLL.Objects;
import BLL.Permission;
import BLL.Title;
import DAL.CityInterface;
import DAL.CityRepository;
import DAL.CountryInterface;
import DAL.CountryRepository;
import DAL.EmployeeInterface;
import DAL.EmployeeRepository;
import DAL.ObjectsInterface;
import DAL.ObjectsRepository;
import DAL.SCHMException;
import DAL.TitleInterface;
import DAL.TitleRepository;
import gui.model.CityComboBoxModel;
import gui.model.CountryComboBoxModel;
import gui.model.EmployeeTableModel;
import gui.model.ObjectsComboBoxModel;
import gui.model.RaportsToComboBoxModel;
import gui.model.TitleComboBoxModel;
import java.awt.event.ActionListener;
import static java.sql.Types.NULL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.DateFormatter;

/**
 *
 * @author EN
 */
public class EmployeesForm extends javax.swing.JInternalFrame{

    /**
     * Creates new form EmployeesForm
     */
    EmployeeInterface eir = new EmployeeRepository();
    EmployeeTableModel etm = new EmployeeTableModel();
    TitleInterface tir = new TitleRepository();
    ObjectsInterface oir = new ObjectsRepository();
    CountryInterface cir = new CountryRepository();
    CityInterface cyir = new CityRepository();
    
    RaportsToComboBoxModel rcbbm;
    TitleComboBoxModel tcbbm;
    ObjectsComboBoxModel ocbbm;
    CountryComboBoxModel ccbbm;
    CityComboBoxModel cycbbm;
    
    private static Permission premission;
    private static Objects object;
    private static Title title;
    public EmployeesForm(Permission prem,Objects obj,Title tit) {
        premission = prem;
        object = obj;
        title = tit;
        initComponents();
        populateObjectsComboBox();
        if(object.getObjectID() == 1){
            loadTable();
        }else {
            loadTable(object);
            objectsCB.setSelectedItem(object);
            objectsCB.setEnabled(false);
            objectsCB.repaint();
        }
        if(!premission.getEmployeesManage()){
            saveBtn.setEnabled(false);
            deleteBtn.setEnabled(false);
        }
        tabelaSelectedIndexChange();
        populateReportsToComboBox();
        populateTitleComboBox();
        populateCountryComboBox();
        cityCB.setEnabled(false);
        datelindjaCH.getJCalendar().getYearChooser().setMinimum(Calendar.getInstance().get(Calendar.YEAR)-66);
        datelindjaCH.getJCalendar().getYearChooser().setMaximum(Calendar.getInstance().get(Calendar.YEAR)-17);
        hiredateDC.getJCalendar().getYearChooser().setMinimum(2000);
        hiredateDC.getJCalendar().getYearChooser().setMaximum(Calendar.getInstance().get(Calendar.YEAR)+1);        
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
    public void populateReportsToComboBox() {
        try {
            List<Employees> list = eir.findAll();
            rcbbm = new RaportsToComboBoxModel(list);
            raportsToCB.setModel(rcbbm);
            raportsToCB.repaint();
        } catch (SCHMException ex) {

        }
    }
    public void populateTitleComboBox() {
        try {
            List<Title> list = tir.findAll();
            tcbbm = new TitleComboBoxModel(list);
            titleCB.setModel(tcbbm);
            titleCB.repaint();
        } catch (SCHMException ex) {

        }
    }
    public void populateObjectsComboBox() {
        try {
            List<Objects> list = oir.findAll();
            ocbbm = new ObjectsComboBoxModel(list);
            objectsCB.setModel(ocbbm);
            objectsCB.repaint();
        } catch (SCHMException ex) {

        }
    }
    public void populateCountryComboBox() {
        try {
            List<Country> list = cir.findAll();
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
                    Employees e = etm.getEmployee(selectedIndex);
                    emriTF.setText(e.getEmployeeName());
                    mbiemriTF.setText(e.getEmployeeLastname());
                    datelindjaCH.setDate(e.getBirthdate());
                    titleCB.setSelectedItem(e.getTitleID());
                    titleCB.repaint();
                    if(e.getSex() == true){
                        mRB.setSelected(true);
                    }else {
                        fRB.setSelected(true);;
                    }
                    hiredateDC.setDate(e.getHiredate());
                    countryCB.setSelectedItem(e.getCityID().getCountryID());
                    countryCB.repaint();
                    cityCB.setSelectedItem(e.getCityID());
                    cityCB.repaint();
                    phoneTF.setText(e.getPhone());
                    raportsToCB.setSelectedItem(e.getReportsTo());
                    raportsToCB.repaint();
                    emailTF.setText(e.getEmail());
                    objectsCB.setSelectedItem(e.getObjectID());
                    objectsCB.repaint();
                    
                }
            }
        });
    }
    
    public void loadTable() {
        try {
            List<Employees> list = eir.findAll();
            etm.add(list);
            tabela.setModel(etm);
            etm.fireTableDataChanged();
            populateReportsToComboBox();
        } catch (SCHMException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    public void loadTable(Objects obj) {
        try {
            List<Employees> list = eir.findByObjectID(obj);
            etm.add(list);
            tabela.setModel(etm);
            etm.fireTableDataChanged();
            populateReportsToComboBox();
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

        gjiniaGroup = new javax.swing.ButtonGroup();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        phoneTF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        emriTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        mbiemriTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        emailTF = new javax.swing.JTextField();
        raportsToCB = new javax.swing.JComboBox();
        titleCB = new javax.swing.JComboBox();
        mRB = new javax.swing.JRadioButton();
        fRB = new javax.swing.JRadioButton();
        hiredateDC = new com.toedter.calendar.JDateChooser();
        objectsCB = new javax.swing.JComboBox();
        datelindjaCH = new com.toedter.calendar.JDateChooser();
        countryCB = new javax.swing.JComboBox();
        cityCB = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Employees");

        jLabel11.setText("Object:");

        jLabel4.setText("Birthdate");

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

        jLabel6.setText("Phone:");

        phoneTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneTFActionPerformed(evt);
            }
        });

        jLabel7.setText("RaportsTo:");

        jLabel8.setText("Email: ");

        jLabel9.setText("Gender:");

        jLabel10.setText("HireDate:");

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        emriTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emriTFActionPerformed(evt);
            }
        });

        jLabel1.setText("Country:");

        jLabel2.setText("Last name:");

        mbiemriTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mbiemriTFActionPerformed(evt);
            }
        });

        jLabel3.setText("Title:");

        jLabel5.setText("First name:");

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

        gjiniaGroup.add(mRB);
        mRB.setText("M");

        gjiniaGroup.add(fRB);
        fRB.setText("F");

        jLabel12.setText("City:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveBtn)
                .addGap(6, 6, 6)
                .addComponent(deleteBtn)
                .addGap(6, 6, 6)
                .addComponent(cancelBtn)
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(phoneTF, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(titleCB, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(107, 107, 107)
                                .addComponent(jLabel6)
                                .addGap(106, 106, 106)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(emriTF, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(mbiemriTF, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(mRB))
                                .addGap(5, 5, 5)
                                .addComponent(fRB)))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(datelindjaCH, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel10)
                            .addComponent(hiredateDC, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(countryCB, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cityCB, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(79, 79, 79)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(objectsCB, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(raportsToCB, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(3, 3, 3)
                                .addComponent(emriTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(2, 2, 2)
                                .addComponent(mbiemriTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(2, 2, 2)
                                .addComponent(mRB))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(fRB))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel1)
                                .addGap(2, 2, 2)
                                .addComponent(countryCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel12)
                                .addGap(2, 2, 2)
                                .addComponent(cityCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(0, 0, 0)
                        .addComponent(datelindjaCH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel10))
                    .addComponent(jLabel11)
                    .addComponent(jLabel7))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(phoneTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hiredateDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(objectsCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(raportsToCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveBtn)
                    .addComponent(deleteBtn)
                    .addComponent(cancelBtn))
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void phoneTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneTFActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int age = year - datelindjaCH.getJCalendar().getYearChooser().getYear();
        if (!emriTF.getText().trim().isEmpty() && !mbiemriTF.getText().trim().isEmpty() && datelindjaCH.getDate() != null
            && !phoneTF.getText().trim().isEmpty() && titleCB.getSelectedIndex() != -1 && hiredateDC.getDate() != null
                && cityCB.getSelectedIndex() != -1 && isValidEmailAddress(emailTF.getText()) && (mRB.isSelected() || fRB.isSelected())
                && objectsCB.getSelectedIndex() != -1 && (age > 18 && age < 65)) {
            int row = tabela.getSelectedRow();
            if (row == -1) {
                Employees e = new Employees();
                cityCB.setEnabled(false);
                e.setEmployeeName(emriTF.getText());
                e.setEmployeeLastname(mbiemriTF.getText());
                e.setBirthdate(datelindjaCH.getDate());
                e.setPhone(phoneTF.getText());
                e.setTitleID((Title) tcbbm.getSelectedItem());
                e.setHiredate(hiredateDC.getDate());
                e.setCityID((City) cityCB.getSelectedItem());
                
                e.setEmail(emailTF.getText());
                if(mRB.isSelected()){
                    e.setSex(true);
                }else{
                    e.setSex(false);
                }
                if(raportsToCB.getSelectedIndex() != -1){
                    e.setReportsTo((Employees) rcbbm.getSelectedItem());
                }
                e.setObjectID((Objects) ocbbm.getSelectedItem());
                try {
                    eir.create(e);
                } catch (SCHMException es) {
                    JOptionPane.showMessageDialog(this, es.getMessage());
                    return;
                }
            } else {
                Employees e = etm.getEmployee(row);
                e.setEmployeeName(emriTF.getText());
                e.setEmployeeLastname(mbiemriTF.getText());
                e.setBirthdate(datelindjaCH.getDate());
                e.setPhone(phoneTF.getText());
                e.setTitleID((Title) tcbbm.getSelectedItem());
                e.setHiredate(hiredateDC.getDate());
                e.setCityID((City) cityCB.getSelectedItem());
                e.setPhone(phoneTF.getText());
                e.setEmail(emailTF.getText());
                if(mRB.isSelected()){
                    e.setSex(true);
                }else{
                    e.setSex(false);
                }
                if(raportsToCB.getSelectedIndex() != -1){
                    e.setReportsTo((Employees) rcbbm.getSelectedItem());
                }else{
                    Employees e1 = null;
                    e.setReportsTo(e1);
                }
                e.setObjectID((Objects) ocbbm.getSelectedItem());
                try {
                    eir.edit(e);
                } catch (SCHMException es) {
                    JOptionPane.showMessageDialog(this, es.getMessage());
                    return;
                }
                
            }
            clearFild();
            if(object.getObjectID() == 1){
                loadTable();
            }else {
                loadTable(object);
                objectsCB.setSelectedItem(object);
                objectsCB.setEnabled(false);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Fushat nuk jane plotesuar ne menyre te rregullt!");
        }
    }//GEN-LAST:event_saveBtnActionPerformed
     public void clearFild() {
        tabela.clearSelection();
        emriTF.setText("");
        mbiemriTF.setText("");
        datelindjaCH.setDate(null);
        titleCB.setSelectedIndex(-1);
        titleCB.repaint();
        hiredateDC.setDate(null);
        countryCB.setSelectedIndex(-1);
        countryCB.repaint();
        cityCB.setEnabled(false);
        cityCB.setSelectedIndex(-1);
        cityCB.repaint();
        phoneTF.setText("");
        emailTF.setText("");
        raportsToCB.setSelectedIndex(-1);
        raportsToCB.repaint();
        objectsCB.setSelectedIndex(-1);
        objectsCB.repaint();
        gjiniaGroup.clearSelection();
    }
    private void emriTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emriTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emriTFActionPerformed

    private void mbiemriTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mbiemriTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mbiemriTFActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int row = tabela.getSelectedRow();
        if (row > -1) {
            Object[] ob = {"Po", "Jo"};
            int i = JOptionPane.showOptionDialog(this, "A dëshironi ta fshini ?", "Fshirja", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
            if (i == 0) {
                Employees e = etm.getEmployee(row);
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
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        clearFild();
    }//GEN-LAST:event_cancelBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelBtn;
    private javax.swing.JComboBox cityCB;
    private javax.swing.JComboBox countryCB;
    private com.toedter.calendar.JDateChooser datelindjaCH;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTextField emailTF;
    private javax.swing.JTextField emriTF;
    private javax.swing.JRadioButton fRB;
    private javax.swing.ButtonGroup gjiniaGroup;
    private com.toedter.calendar.JDateChooser hiredateDC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JTextField mbiemriTF;
    private javax.swing.JComboBox objectsCB;
    private javax.swing.JTextField phoneTF;
    private javax.swing.JComboBox raportsToCB;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTable tabela;
    private javax.swing.JComboBox titleCB;
    // End of variables declaration//GEN-END:variables
}
