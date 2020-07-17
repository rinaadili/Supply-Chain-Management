/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;


import BLL.Employees;
import BLL.Objects;
import BLL.Permission;
import BLL.Request;
import BLL.Title;
import BLL.Users;
import DAL.EmployeeInterface;
import DAL.EmployeeRepository;
import DAL.RequestInterface;
import DAL.RequestRepository;
import DAL.SCHMException;
import gui.model.RequestTableModel;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author RA
 */
public class RequestView extends javax.swing.JInternalFrame {

    /**
     * Creates new form Request
     */
    RequestInterface cir = new RequestRepository();
    RequestTableModel ctm = new RequestTableModel();
    EmployeeInterface eir = new EmployeeRepository();
    
    private static Permission premission;
    private static Objects object;
    private static Title title;
    private static Users users;
    
    public RequestView(Permission prem,Objects obj,Title tit,Users u) {
        premission = prem;
        object = obj;
        title = tit;
        users = u;
        initComponents();
        if(object.getObjectID() == 1){
            loadTable();
        }else {
            loadTable2();
        }
        tabelaSelectedIndexChange();
    }
    public void loadTable() {
        try {
            List<Request> list = cir.findAll();
            ctm.add(list);
            tabela.setModel(ctm);
            ctm.fireTableDataChanged();
        } catch (SCHMException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    public void loadTable2() {
        try {
            List<Request> list = cir.findAll();
            List<Request> list1= new ArrayList<>();
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).getEmployeeID().getObjectID().equals(object))
                    list1.add(list.get(i));
            }
            ctm.add(list1);
            tabela.setModel(ctm);
            ctm.fireTableDataChanged();
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
                 Request c = ctm.getRequest(row);
                 int id = c.getRequestID();
                 RequestDetailsView rdv;
                 try {
                     rdv = new RequestDetailsView(id,users);
                     JDesktopPane desktopPane = getDesktopPane();
                     desktopPane.add(rdv);
                     rdv.show();
                 } catch (SCHMException ex) {
                     Logger.getLogger(RequestView.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
             }
             else {
                 //do something else
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
        tabela = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
