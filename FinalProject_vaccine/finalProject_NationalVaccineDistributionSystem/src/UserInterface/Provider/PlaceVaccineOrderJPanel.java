/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.Provider;

import Business.Business;
import Business.Enterprise.HospitalEnterprise;
import Business.NationalEnterprise.CDC;
import Business.NationalEnterprise.Manufacturer;
import Business.Network.StateNetwork;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.CDCOrganization;
import Business.Organization.HospitalOrganization;
import Business.Organization.ManufactureOrganization;
import Business.Organization.Organization;
import Business.Organization.PHDImmunizationOrganization;
import Business.UserAccount.UserAccount;
import Business.Vaccine.VaccineProduct;
import Business.WorkQueue.ProviderVaccineOrderWorkRequest;
import Business.WorkQueue.VaccineOrderWorkRequest;
import UserInterface.CDC.*;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vaibhav
 */
public class PlaceVaccineOrderJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreateVaccineOrderJPanel
     */
    private JPanel workContainer;

    private HospitalEnterprise hospital;
    private UserAccount userAccount;
    private HospitalOrganization hospitalOrg;
    private Business business;
    private Order tempOrder;
    private ArrayList<OrderItem> cartOrder;
    private boolean isCheckout;
    private StateNetwork state;

    public PlaceVaccineOrderJPanel(JPanel workContainer, HospitalEnterprise hospital,HospitalOrganization hospitalOrg,UserAccount userAccount , Business business, StateNetwork state) {
        initComponents();
        this.workContainer = workContainer;
        this.userAccount = userAccount;
        this.hospital = hospital;
        this.business = business;
        this.state = state;
        populateManufacturerComboBox();
        this.isCheckout = false;
        
        //create an order for Cart Table
         cartOrder = new ArrayList<OrderItem>();
         
         if(isCheckout == false){
             tempOrder = new Order();
         }
        
        
        
    }

    private void populateManufacturerComboBox() {
        manufacturerjComboBox.removeAllItems();
        for (Manufacturer manufacturer : business.getManufacturerDirectory().getManufacturerList()) {
            manufacturerjComboBox.addItem(manufacturer);

        }
    }
    
    private void displayManufacturerVaccines(){
        
        int rowCount = manufacturerjTable.getRowCount();
        DefaultTableModel dtm = (DefaultTableModel)manufacturerjTable.getModel();
        
        //delete rows
        for(int i=rowCount-1 ; i>=0; i--){
            dtm.removeRow(i);
        }
        
        
        //get Manufacturer from combo box
        Manufacturer manufacturer = (Manufacturer)manufacturerjComboBox.getSelectedItem();
        if(manufacturer == null){
            return;
        }
        
        //populate the table
        ManufactureOrganization manufacureOrg = null;
        for(Organization org : manufacturer.getOrganizationDirectory().getOrganizationList())
        {   if(org instanceof ManufactureOrganization)
        {   manufacureOrg = (ManufactureOrganization)org;
            for(VaccineProduct vaccine : manufacureOrg.getVaccineProductCatalog().getVaccineProductList())
            {Object[] row = new Object[9];
            row[0] = vaccine;
            row[1] = vaccine.getVaccineDefinition().getVaccineName();
            row[2] = vaccine.getVaccineId();
            row[3] = vaccine.getBatchId();
            row[4] = vaccine.getVaccinePrice();
            row[5] = String.valueOf(vaccine.getMinOperatingTemp()+ " - " +vaccine.getMaxOperatingTemp());
            row[6] = vaccine.getManufactureDate();
            row[7] = vaccine.getDateOfExpiry();
            
            dtm.addRow(row);
            }
        }
        }
        
        
        
        
    }
    
    
    private void searchVaccineProducts(String vaccineCode){
        
        int rowCount = manufacturerjTable.getRowCount();
        DefaultTableModel dtm = (DefaultTableModel)manufacturerjTable.getModel();
        
        for(int i=rowCount-1 ; i>=0; i--){
            dtm.removeRow(i);
        }
        
        //search vaccines from all the manufacturers
        
        for(Manufacturer manufacturer: business.getManufacturerDirectory().getManufacturerList())
        {
             ManufactureOrganization manufacureOrg = null;
        for(Organization org : manufacturer.getOrganizationDirectory().getOrganizationList())
        {   if(org instanceof ManufactureOrganization)
        {   manufacureOrg = (ManufactureOrganization)org;
            for(VaccineProduct vaccine : manufacureOrg.getVaccineProductCatalog().getVaccineProductList())
            {
                if(vaccineCode.equalsIgnoreCase(vaccine.getVaccineDefinition().getVaccineCode()))
                {
                Object[] row = new Object[9];
            
                row[0] = vaccine;
                row[1] = vaccine.getVaccineDefinition().getVaccineName();
                row[2] = vaccine.getVaccineId();
                row[3] = vaccine.getBatchId();
                row[4] = vaccine.getVaccinePrice();
                row[5] = String.valueOf(vaccine.getMinOperatingTemp()+ " - " +vaccine.getMaxOperatingTemp());
                row[6] = vaccine.getManufactureDate();
                row[7] = vaccine.getDateOfExpiry();
                
                dtm.addRow(row);
                }
            }
        }
            
        }
            
            
        }
        
        
        
    }
    
    
    private void refreshCartTable(){
        
          int rowCount = cartjTable.getRowCount();
        DefaultTableModel dtm = (DefaultTableModel)cartjTable.getModel();
        
        for(int i=rowCount-1 ; i>=0; i--){
            dtm.removeRow(i);
        }
        
        
        for(OrderItem oi: tempOrder.getOrderList() )
        {
            Object[] row = new Object[10];
            
                row[0] = oi.getVaccineProduct();
                row[1] = oi;
                row[2] = oi.getVaccineProduct().getVaccineId();
                row[3] = oi.getVaccineProduct().getBatchId();
                row[4] = oi.getVaccineProduct().getVaccinePrice();
                row[5] = String.valueOf(oi.getVaccineProduct().getMinOperatingTemp()+ " - " +oi.getVaccineProduct().getMaxOperatingTemp());
                row[6] = oi.getQuantity();
                row[7] = oi.getVaccineProduct().getManufactureDate();
                row[8] = oi.getVaccineProduct().getDateOfExpiry();
                row[9] = oi.getVaccineProduct().getVaccinePrice()*oi.getQuantity();
                dtm.addRow(row);
            
            
            
            
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
        manufacturerjComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        vaccineSearchjTextField = new javax.swing.JTextField();
        searchjButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        manufacturerjTable = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        cartjTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        quantityJSpinner = new javax.swing.JSpinner();
        addToCartJButton = new javax.swing.JButton();
        modifyJTextField = new javax.swing.JTextField();
        modifyJButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        removeJButton = new javax.swing.JButton();
        checkOutJButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        totalAmountOrderjTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        bimonthlyjRadioButton = new javax.swing.JRadioButton();
        monthlyjRadioButton = new javax.swing.JRadioButton();
        adhocjRadioButton = new javax.swing.JRadioButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Create Vaccine Order");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Manufacturer:");

        manufacturerjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        manufacturerjComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manufacturerjComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Manufacturer Vaccine Catalog:");

        jLabel4.setText("Search Vaccine:");

        jLabel5.setText("Vaccine Code:");

        searchjButton.setText("Search");
        searchjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchjButtonActionPerformed(evt);
            }
        });

        manufacturerjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Code", "Vaccine Name", "Vaccine id", "Lot Number", "Price", "Temperature Range", "manufacture date", "expiry date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(manufacturerjTable);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Cart:");

        cartjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Code", "Vaccine Name", "Vaccine id", "Lot Number", "Price", "Temperature Range", "Quantity", "manufacture date", "expiry date", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(cartjTable);

        jLabel7.setText("Quantity:");

        addToCartJButton.setText("Add to Cart");
        addToCartJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartJButtonActionPerformed(evt);
            }
        });

        modifyJButton.setText("Modify");
        modifyJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyJButtonActionPerformed(evt);
            }
        });

        jLabel8.setText("Quantity:");

        removeJButton.setText("Remove");
        removeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeJButtonActionPerformed(evt);
            }
        });

        checkOutJButton.setText("Check Out");
        checkOutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOutJButtonActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Total Amount of Order:");

        totalAmountOrderjTextField.setEnabled(false);

        jLabel10.setText("Set Contract: ");

        buttonGroup1.add(bimonthlyjRadioButton);
        bimonthlyjRadioButton.setText("Bi-Monthly");

        buttonGroup1.add(monthlyjRadioButton);
        monthlyjRadioButton.setText("Monthly");

        buttonGroup1.add(adhocjRadioButton);
        adhocjRadioButton.setText("Ad-hoc");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(manufacturerjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vaccineSearchjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(removeJButton)
                        .addGap(78, 78, 78)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bimonthlyjRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(monthlyjRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(adhocjRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addComponent(checkOutJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modifyJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(modifyJButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quantityJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addToCartJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(totalAmountOrderjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(manufacturerjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(searchjButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(vaccineSearchjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(quantityJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addToCartJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(modifyJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modifyJButton)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(totalAmountOrderjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkOutJButton)
                    .addComponent(removeJButton)
                    .addComponent(jLabel10)
                    .addComponent(bimonthlyjRadioButton)
                    .addComponent(monthlyjRadioButton)
                    .addComponent(adhocjRadioButton))
                .addContainerGap(68, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addToCartJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToCartJButtonActionPerformed
        // TODO add your handling code here:
        int quantity = (Integer) quantityJSpinner.getValue();

        //get the selected item
        int selectRow = manufacturerjTable.getSelectedRow();
        if (selectRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a Vaccine First!");
            return;
        }
        VaccineProduct product = (VaccineProduct) manufacturerjTable.getValueAt(selectRow, 0);
        
        
        //condition for -ve 
        if (quantity <= 0 ) {
            JOptionPane.showMessageDialog(null, "Please enter correct quantity");
            return;
        }
        
        
        

        //Before add to cart we need to check
        boolean flag = true;
        //  ArrayList<OrderItem> orders = customer.getOrder().getOrderItemList();
        ArrayList<OrderItem> orders = tempOrder.getOrderList();
        for (OrderItem oi : orders) {
            if (oi.getVaccineProduct().equals(product)) {
                int oldQuantity = oi.getQuantity();
                int newQuantity = oldQuantity + quantity;
                oi.setQuantity(newQuantity);
                flag = false;
            }
        }
         
        //add to cart
        if(flag){
        //OrderItem orderItem = customer.getOrder().addOrderItem(product, quantity);
        OrderItem orderItem = tempOrder.addNewOrderItem(quantity, product);
        }
         
        
         
         /*
        //add to temp orderList
        
        
        OrderItem orderItem = new OrderItem();
        orderItem.setVaccineProduct(product);
        orderItem.setQuantity(quantity);
        cartOrder.add(orderItem);
        
        
        
        //add to cart
       
        */

        isCheckout = false;
        String msg = Integer.toString(quantity) + " " + product.getVaccineDefinition().getVaccineName() + " has added to cart!";
        JOptionPane.showMessageDialog(null, msg);
        
            
        

        //refresh the table
       displayManufacturerVaccines();
        refreshCartTable();
        calulateTotalAmountOfOrder();

    }//GEN-LAST:event_addToCartJButtonActionPerformed
    
    private void calulateTotalAmountOfOrder(){
        
        if(tempOrder == null){
            return;
        }
        double totalAmount = 0;
        
        for(OrderItem oi: tempOrder.getOrderList())
        {
            totalAmount = totalAmount + oi.getQuantity()*oi.getVaccineProduct().getVaccinePrice();
            
        }
        
        totalAmountOrderjTextField.setText(String.valueOf(totalAmount));
        
        
    }
    
    
    
    
    
    private void modifyJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyJButtonActionPerformed
        // TODO add your handling code here:
        //
        int selectRow = cartjTable.getSelectedRow();
        if (selectRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a vaccine from cart first!");
            return;
        }
        //modify the item Quantity
        OrderItem orderItem = (OrderItem) cartjTable.getValueAt(selectRow, 1);
        //get old quantity
        int oldQuantity = orderItem.getQuantity();
        //get new quantity
        int newQuantity = Integer.parseInt(modifyJTextField.getText());
        
        /*    
        //get old quantity
        int oldQuantity = orderItem.getQuantity();
        int oldAvail = orderItem.getVaccineProduct().getAvailablity();

        int newQuantity = Integer.parseInt(modifyJTextField.getText());

        //judge the quantities
        if (newQuantity <= 0 || newQuantity > oldQuantity + oldAvail) {
            JOptionPane.showMessageDialog(null, "Please enter a valid quantity");
            return;
        }
        */
        
        orderItem.setQuantity(newQuantity);
        String msg = "The quantity of " + orderItem.getVaccineProduct().getVaccineDefinition().getVaccineName() + " has changed from " + oldQuantity + " to " + newQuantity;
        JOptionPane.showMessageDialog(null, msg);
        
        //orderItem.getVaccineProduct().setAvailablity(oldAvail + oldQuantity - newQuantity);//update the availability

        //refresh the tables
        displayManufacturerVaccines();
        refreshCartTable();

    }//GEN-LAST:event_modifyJButtonActionPerformed

    private void removeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeJButtonActionPerformed
        // TODO add your handling code here:
        int selectRow = cartjTable.getSelectedRow();
        if (selectRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a vaccine from cart first!");
            return;
        }
        OrderItem oi = (OrderItem) cartjTable.getValueAt(selectRow, 1);
        
        /*
        //add the quantity back
        int oldQuantity = oi.getVaccineProduct().getAvailablity();
        int orderedQuantity = oi.getQuantity();
        int newQuantity = orderedQuantity + oldQuantity;
        oi.getVaccineProduct().setAvailablity(newQuantity);
        */
        
        tempOrder.removeOrderItem(oi);
        

        //refresh the tables
        displayManufacturerVaccines();
        refreshCartTable();

    }//GEN-LAST:event_removeJButtonActionPerformed

    private void checkOutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOutJButtonActionPerformed
        // TODO add your handling code here:
        // if(!customer.getOrder().getOrderItemList().isEmpty())
        
        if((bimonthlyjRadioButton.isSelected() || monthlyjRadioButton.isSelected() || adhocjRadioButton.isSelected()))
        {
            
        
        if (!tempOrder.getOrderList().isEmpty()) 
            {   
                // Insert the order in the PHD Order List
                
                
                //get the contract details
                boolean adhoc = adhocjRadioButton.isSelected();
                boolean bimonth = bimonthlyjRadioButton.isSelected();
                boolean monthly = monthlyjRadioButton.isSelected();
                
                //Insert the order in the Provider Orders List
                Order o = hospital.getOrderCatalog().addNewOrder();
                o=tempOrder;
                
                //Create a new Work request 
                ProviderVaccineOrderWorkRequest workRequest = new ProviderVaccineOrderWorkRequest();
                workRequest.setAdhocRequest(adhoc);
                workRequest.setBimonthlyContract(bimonth);
                workRequest.setMonthlyContract(monthly);
                workRequest.setVaccineOrder(tempOrder);
                workRequest.setSender(userAccount);
                workRequest.setStatus("New Order");
                workRequest.calculateDeliveryDate(workRequest);
                workRequest.setEnterprise(hospital);
                
                // add it into own workqueue
                for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
                {
                    if(org instanceof HospitalOrganization)
                    {
                        HospitalOrganization hosOrg = (HospitalOrganization)org;
                        hosOrg.getWorkQueue().addWorkRequest(workRequest);
                    }
                }
                
                
                
                
                //fetch the PHD, and insert the order in his queue
                for(Organization org: state.getPublicHealthDepartment().getOrganizationDirectory().getOrganizationList())
                {
                    if(org instanceof PHDImmunizationOrganization)
                    {
                        org.getWorkQueue().addWorkRequest(workRequest);
                    }
                }
                
                
                
                
                
                /*
                //create a new Order Work Request
                VaccineOrderWorkRequest vaccineWorkRequest = new VaccineOrderWorkRequest();
                vaccineWorkRequest.setSender(userAccount);
                vaccineWorkRequest.setStatus("NewOrder");
                vaccineWorkRequest.setVaccineOrder(order);
                
                
                //fetch the manufacturer and insert the work request in his queue
                for(OrderItem oi: cartOrder)
                {
                    String manufacturer = oi.getVaccineProduct().getManufacturerName();
                    for(Manufacturer manuf : business.getManufacturerDirectory().getManufacturerList())
                    {
                        if(manufacturer.equalsIgnoreCase(String.valueOf(manuf)))
                        {   
                            //create a new Order Work Request
                                VaccineOrderWorkRequest vaccineWorkRequest = new VaccineOrderWorkRequest();
                                vaccineWorkRequest.setSender(userAccount);
                                vaccineWorkRequest.setStatus("NewOrder");
                                Order order = new Order();
                                order.addNewOrderItem(oi.getQuantity(), oi.getVaccineProduct());
                                vaccineWorkRequest.setVaccineOrder(order);
                                //add order to cdc order catalog
                                //cdcOrg.getDistributorOrders().addOrder(order);
                            
                            
                            for(Organization org:manuf.getOrganizationDirectory().getOrganizationList() )
                            {
                                if(org instanceof ManufactureOrganization)
                                {
                                    org.getWorkQueue().addWorkRequest(vaccineWorkRequest);
                                }
                            }
                        }
                    }
                }
                */
                
                JOptionPane.showMessageDialog(null, "Your order has been successfuly added!");
            
        }
        else
        {JOptionPane.showMessageDialog(null, "Error occured when trying to check out!");
        }
        
        isCheckout = true;
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to Place another order?", "Warning", dialogButton);

        //if yes
        if (dialogResult == JOptionPane.YES_OPTION) {
            tempOrder = new Order(); // to create new order

        }
        
        
        displayManufacturerVaccines();
        refreshCartTable();
        
        //reload the page
          PlaceVaccineOrderJPanel panel = new PlaceVaccineOrderJPanel(workContainer, hospital, hospitalOrg, userAccount, business, state);
        workContainer.add("PlaceVaccineOrderJPanel", panel);
        CardLayout layout = (CardLayout)workContainer.getLayout();
        layout.next(workContainer);
        
        
        
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please Select a type of contract");
            return;
        }
        
        /*
                
                ShippingOrderWorkRequest shippingWorkRequest = new ShippingOrderWorkRequest();
                shippingWorkRequest.setSender(userAccount);
                shippingWorkRequest.setStatus("Pending Approval");
                shippingWorkRequest.setOrderNumber(order.getOrderNumber());
                //fetch the Sales organization and insert this work request in its work queue
                Organization org = null;
                for (Organization organization : business.getOrganizationDir().getOrganizationList()) {
                    if (organization instanceof SalesOrganization) {
                        org = organization;
                    }
                }
                if (org != null) {
                    org.getWorkQueue().getWorkRequestList().add(shippingWorkRequest);
                    userAccount.getWorkQueue().getWorkRequestList().add(shippingWorkRequest);
                }
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Error occured when trying to check out!");
        }
        isCheckedOut = true;
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to Place another order?", "Warning", dialogButton);

        //if yes
        if (dialogResult == JOptionPane.YES_OPTION) {
            order = new Order(); // to create new order

        }
                        
        System.out.println("After checkout: " + order.getOrderNumber());
                        */
        //refresh tables
        
    }//GEN-LAST:event_checkOutJButtonActionPerformed

    private void manufacturerjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manufacturerjComboBoxActionPerformed
        // TODO add your handling code here:

        displayManufacturerVaccines();
    }//GEN-LAST:event_manufacturerjComboBoxActionPerformed

    private void searchjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchjButtonActionPerformed
        // TODO add your handling code here:
        
        String vaccineCode = vaccineSearchjTextField.getText();
        searchVaccineProducts(vaccineCode);
        
        
    }//GEN-LAST:event_searchjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToCartJButton;
    private javax.swing.JRadioButton adhocjRadioButton;
    private javax.swing.JRadioButton bimonthlyjRadioButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTable cartjTable;
    private javax.swing.JButton checkOutJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox manufacturerjComboBox;
    private javax.swing.JTable manufacturerjTable;
    private javax.swing.JButton modifyJButton;
    private javax.swing.JTextField modifyJTextField;
    private javax.swing.JRadioButton monthlyjRadioButton;
    private javax.swing.JSpinner quantityJSpinner;
    private javax.swing.JButton removeJButton;
    private javax.swing.JButton searchjButton;
    private javax.swing.JTextField totalAmountOrderjTextField;
    private javax.swing.JTextField vaccineSearchjTextField;
    // End of variables declaration//GEN-END:variables
}
