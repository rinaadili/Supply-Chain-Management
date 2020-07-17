/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.view;

import BLL.InputDetails;
import BLL.Inputs;
import BLL.OrderDetails;
import BLL.Orders;
import BLL.Products;
import BLL.Request;
import BLL.RequestDetails;
import BLL.Users;
import DAL.InputDetailsInterface;
import DAL.InputDetailsRespiratory;
import DAL.InputsInterface;
import DAL.InputsRespiratory;
import DAL.OrderDetailsInterface;
import DAL.OrderDetailsRespiratory;
import DAL.OrdersInterface;
import DAL.OrdersRespiratory;
import DAL.ProductsInterface;
import DAL.ProductsRepository;
import DAL.RequestDetailsInterface;
import DAL.RequestDetailsRepository;
import DAL.RequestInterface;
import DAL.RequestRepository;
import DAL.SCHMException;
import gui.model.RequestDetailsTableModel;
import gui.model.RequestTableModel;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author EN
 */
public class RequestDetailsView extends javax.swing.JInternalFrame {

    /**
     * Creates new form RequestDetails
     */
    RequestDetailsInterface cir = new RequestDetailsRepository();
    RequestDetailsTableModel ctm = new RequestDetailsTableModel();
    ProductsInterface eir = new ProductsRepository();
    RequestInterface rir = new RequestRepository();
    InputsInterface iir = new InputsRespiratory();
    InputDetailsInterface idir = new InputDetailsRespiratory();
    OrdersInterface reir = new OrdersRespiratory();
    OrderDetailsInterface ccir = new OrderDetailsRespiratory();
    
    public RequestDetailsView() {
        initComponents();
        loadTable();
    }
    public int id;
    private static Users users;
    
    public RequestDetailsView(int id,Users u) throws SCHMException {
        initComponents();
        this.id = id;
        users = u;
        loadTable();
        r = rir.findById(id);
        if(u.getEmployees().getObjectID().getObjectID() == 1){
            if(kaSasi()){
                sasiaLA.setText("Po");
            }else {
                jButton1.setEnabled(false);
            }
        }else {
            jLabel1.setText("Kerkesa nuk eshte aprovuar ende");
            sasiaLA.setText("");
            jButton1.setVisible(false);
            jButton2.setVisible(false);
        }
        if(r.getApproved()){
            tabela.setBackground(Color.green);
            tabela.setEnabled(false);
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jLabel1.setText("");
            sasiaLA.setBackground(Color.green);
            sasiaLA.setOpaque(true);
            sasiaLA.setText("Kerkesa eshte aprovuar!");
        }
    }
    
    List<RequestDetails> list = new ArrayList<>();
    public void loadTable() {
        try {
            list = cir.findAllByRequestID(id);
            ctm.add(list);
            tabela.setModel(ctm);
            ctm.fireTableDataChanged();
        } catch (SCHMException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    public boolean kaSasi() throws SCHMException{
        
        for (int i = 0; i < list.size(); i++) {
            Integer pID = kalkuloSasin(list.get(i).getProductID());
            if(list.get(i).getQuantity() > pID){
                return false;
            }
        }
        return true;
    }
//    public void zbritSasin() throws SCHMException{
//        for (int i = 0; i < list.size(); i++) {
//            Integer pID = list.get(i).getProductID().getBarcode();
//            Products p = eir.findByPOId(pID, 1);
//            p.setQuantity(p.getQuantity()-list.get(i).getQuantity());
//            try {
//                eir.edit(p);
//            } catch (SCHMException es) {
//                JOptionPane.showMessageDialog(this, es.getMessage());
//                return;
//            }
//        }
//    }
    private int kalkuloSasin(Products p1){
        try {
            List<Inputs> listInput = iir.findAll();
            Products p = eir.findById(p1.getProductID());
            int countI = 0;
            for(int i = 0 ; i < listInput.size(); i++){
                if(listInput.get(i).getObjectID().getObjectID() == 1){
                    List<InputDetails> list = idir.findByInputDetails(listInput.get(i),p);
                    for(int j = 0 ; j < list.size(); j++){
                        countI += list.get(j).getQuantity();
                    }  
                }
                
            }
            int countO = 0;
            List<Orders> listOrders = reir.findAll();
            for(int i = 0 ; i < listOrders.size(); i++){
                if(listOrders.get(i).getObjectID().getObjectID() == 1){
                    List<OrderDetails> list = ccir.findByOrderIDProductID(listOrders.get(i), p);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        sasiaLA = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

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
        jScrollPane1.setViewportView(tabela);

        jLabel1.setText("A ka sasi te mjaftushme:");

        sasiaLA.setText("Jo");

        jButton1.setText("Aprovo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Refuzo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sasiaLA)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(sasiaLA)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    Request r;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try {
            r = rir.findById(id);
            Object[] ob = {"Po", "Jo"};
            int i = JOptionPane.showOptionDialog(this, "A dëshironi ta aprovoni kerkesen ?", "Kerkesa", JOptionPane.OK_OPTION, JOptionPane.QUESTION_MESSAGE, null, ob, ob[1]);
            if(i == 0){
//                zbritSasin();
                r.setApproved(true);
                rir.edit(r);
                tabela.setBackground(Color.green);
                tabela.setEnabled(false);
                jButton1.setEnabled(false);
                jButton2.setEnabled(false);
                jLabel1.setText("");
                sasiaLA.setBackground(Color.green);
                sasiaLA.setOpaque(true);
                sasiaLA.setText("Kerkesa eshte aprovuar!");
                ctm.fireTableStructureChanged();  
            }
            
        } catch (SCHMException ex) {
            Logger.getLogger(RequestDetailsView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel sasiaLA;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
