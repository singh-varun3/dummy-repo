/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.CDC;

import Business.Business;
import Business.NationalEnterprise.CDC;
import Business.NationalEnterprise.Manufacturer;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.CDCOrganization;
import Business.Organization.ManufactureOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.Vaccine.VaccineProduct;
import Business.WorkQueue.VaccineOrderWorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vaibhav
 */
public class CreateVaccineOrderJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreateVaccineOrderJPanel
     */
    private JPanel workContainer;

    private CDC cdc;
    private UserAccount userAccount;
    private CDCOrganization cdcOrg;
    private Business business;
    private ArrayList<OrderItem> cartOrder;
    private boolean isCheckout;

    public CreateVaccineOrderJPanel(JPanel workContainer, CDC cdc, Business business, CDCOrganization cdcOrg, UserAccount userAccount) {
        initComponents();
        this.workContainer = workContainer;
        this.userAccount = userAccount;
        this.cdc = cdc;
        this.business = business;
        populateManufacturerComboBox();
        this.isCheckout = false;
        
        //create an order for Cart Table
         cartOrder = new ArrayList<OrderItem>();
        
        
        
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
            {Object[] row = new Object[8];
            row[0] = vaccine;
            row[1] = vaccine.getVaccineDefinition().getVaccineName();
            row[2] = vaccine.getManufacturerName();
            
            row[3] = vaccine.getVaccinePrice();
            row[4] = String.valueOf(vaccine.getMinOperatingTemp()+ " - " +vaccine.getMaxOperatingTemp());
            row[5] = vaccine.getAvailablity();
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
                    
                Object[] row = new Object[8];
            row[0] = vaccine;
            row[1] = vaccine.getVaccineDefinition().getVaccineName();
            row[2] = vaccine.getManufacturerName();
            
            row[3] = vaccine.getVaccinePrice();
            row[4] = String.valueOf(vaccine.getMinOperatingTemp()+ " - " +vaccine.getMaxOperatingTemp());
            row[5] = vaccine.getAvailablity();
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
        
        
        for(OrderItem oi: cartOrder )
        {
            Object[] row = new Object[9];
            
                row[0] = oi.getVaccineProduct();
                row[1] = oi;
                row[2] = oi.getVaccineProduct().getManufacturerName();
                
                row[3] = oi.getVaccineProduct().getVaccinePrice();
                row[4] = String.valueOf(oi.getVaccineProduct().getMinOperatingTemp()+ " - " +oi.getVaccineProduct().getMaxOperatingTemp());
                row[5] = oi.getQuantity();
                row[6] = oi.getVaccineProduct().getManufactureDate();
                row[7] = oi.getVaccineProduct().getDateOfExpiry();
                row[8] = oi.getVaccineProduct().getVaccinePrice()*oi.getQuantity();
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
        backJButton = new javax.swing.JButton();
        removeJButton = new javax.swing.JButton();
        checkOutJButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        totalAmountOrderjTextField = new javax.swing.JTextField();

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
                "Vaccine Code", "Vaccine Name", "Brand", "Price", "Temperature Range", "Availability", "manufacture date", "expiry date"
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
                "Vaccine Code", "Vaccine Name", "Brand", "Price", "Temperature Range", "Quantity", "manufacture date", "expiry date", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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

        backJButton.setText("Cancel Order");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantityJSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addToCartJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(removeJButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backJButton)
                        .addGap(18, 18, 18)
                        .addComponent(checkOutJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(manufacturerjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(vaccineSearchjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(searchjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(modifyJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(modifyJButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(totalAmountOrderjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(vaccineSearchjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchjButton))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(modifyJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(modifyJButton)
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(totalAmountOrderjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkOutJButton)
                    .addComponent(removeJButton)
                    .addComponent(backJButton))
                .addContainerGap(74, Short.MAX_VALUE))
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

        //condition for -ve or 0 or more than availabilty
        if (quantity <= 0 || quantity > product.getAvailablity()) {
            JOptionPane.showMessageDialog(null, "Please enter correct quantity");
            return;
        }
        
        
        
        //Before add to cart we need to check
        boolean flag = true;
        //  ArrayList<OrderItem> orders = customer.getOrder().getOrderItemList();
        ArrayList<OrderItem> orders = cartOrder;
        for (OrderItem oi : orders) {
            if (oi.getVaccineProduct().equals(product)) {
                int oldQuantity = oi.getQuantity();
                int newQuantity = oldQuantity + quantity;
                oi.setQuantity(newQuantity);
                flag = false;
            }
        }
           
        
        //add to temp orderList
        
        if(flag==true)
        {OrderItem orderItem = new OrderItem();
        orderItem.setVaccineProduct(product);
        orderItem.setQuantity(quantity);
        cartOrder.add(orderItem);
        
        }
        
        //add to cart
       
        

        //isCheckedOut = false;
        String msg = Integer.toString(quantity) + " " + product.getVaccineDefinition().getVaccineName() + " has added to cart!";
        JOptionPane.showMessageDialog(null, msg);
        
        //reduce the availailty
        product.setAvailablity(product.getAvailablity()-quantity);
        

        //refresh the table
       displayManufacturerVaccines();
        refreshCartTable();
        calulateTotalAmountOfOrder();

    }//GEN-LAST:event_addToCartJButtonActionPerformed
    
    private void calulateTotalAmountOfOrder(){
        
        if(cartOrder == null){
            return;
        }
        double totalAmount = 0;
        
        for(OrderItem oi: cartOrder)
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
        int oldAvail = orderItem.getVaccineProduct().getAvailablity();

        int newQuantity = Integer.parseInt(modifyJTextField.getText());

        //judge the quantities
        if (newQuantity <= 0 || newQuantity > oldQuantity + oldAvail) {
            JOptionPane.showMessageDialog(null, "Please enter a valid quantity");
            return;
        }
        orderItem.setQuantity(newQuantity);
        String msg = "The quantity of " + orderItem.getVaccineProduct().getVaccineDefinition().getVaccineName() + " has changed from " + oldQuantity + " to " + newQuantity;
        JOptionPane.showMessageDialog(null, msg);
        orderItem.getVaccineProduct().setAvailablity(oldAvail + oldQuantity - newQuantity);//update the availability

        //refresh the tables
        displayManufacturerVaccines();
        refreshCartTable();

    }//GEN-LAST:event_modifyJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        //if you didn't check out, we need the quantity back
        if (!isCheckout) {

            for (OrderItem oi : cartOrder) {
                VaccineProduct product = oi.getVaccineProduct();
                int oldAvail = product.getAvailablity();
                int orderedQuantity = oi.getQuantity();
                int newAvail = oldAvail + orderedQuantity;
                //set to the product
                product.setAvailablity(newAvail);
            }
            

            JOptionPane.showMessageDialog(null, "Your order has not been checked out, so all your previous oder will be canceled!");

        } else {
            JOptionPane.showMessageDialog(null, "Your order has been checked out! Thank you!");
        }
        workContainer.remove(this);
        CardLayout layout = (CardLayout) workContainer.getLayout();
        layout.previous(workContainer);

    }//GEN-LAST:event_backJButtonActionPerformed

    private void removeJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeJButtonActionPerformed
        // TODO add your handling code here:
        int selectRow = cartjTable.getSelectedRow();
        if (selectRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a vaccine from cart first!");
            return;
        }
        OrderItem oi = (OrderItem) cartjTable.getValueAt(selectRow, 1);

        //add the quantity back
        int oldQuantity = oi.getVaccineProduct().getAvailablity();
        int orderedQuantity = oi.getQuantity();
        int newQuantity = orderedQuantity + oldQuantity;
        oi.getVaccineProduct().setAvailablity(newQuantity);
        
        cartOrder.remove(oi);
        

        //refresh the tables
        displayManufacturerVaccines();
        refreshCartTable();

    }//GEN-LAST:event_removeJButtonActionPerformed

    private void checkOutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOutJButtonActionPerformed
        // TODO add your handling code here:
        // if(!customer.getOrder().getOrderItemList().isEmpty())
        try {
        // Log: Button click detected
        System.out.println("Checkout button clicked.");

        // Check if the cart is not null
        if (cartOrder != null) {
            System.out.println("Cart is not null. Proceeding with checkout...");

            // Create a new CDC order
            Order cdcOrder = new Order();
            System.out.println("New CDC Order created.");

            for (OrderItem oi : cartOrder) {
                cdcOrder.getOrderList().add(oi);
                System.out.println("Added item to CDC Order: " + oi.getVaccineProduct().getVaccineDefinition().getVaccineName()+ ", Quantity: " + oi.getQuantity());
            }

            // Process each item in the cart
            for (OrderItem oi : cartOrder) {
                String manufacturer = oi.getVaccineProduct().getManufacturerName();
                System.out.println("Processing item: " + oi.getVaccineProduct().getVaccineDefinition().getVaccineName() + " by manufacturer: " + manufacturer);

                for (Manufacturer manuf : business.getManufacturerDirectory().getManufacturerList()) {
                    if (manufacturer.equalsIgnoreCase(String.valueOf(manuf))) {
                        System.out.println("Found matching manufacturer: " + manuf.getName());

                        // Create a new Vaccine Order Work Request
                        VaccineOrderWorkRequest vaccineWorkRequest = new VaccineOrderWorkRequest();
                        vaccineWorkRequest.setSender(userAccount);
                        vaccineWorkRequest.setStatus("NewOrder");

                        Order order = new Order();
                        order.addNewOrderItem(oi.getQuantity(), oi.getVaccineProduct());
                        vaccineWorkRequest.setVaccineOrder(order);
                        System.out.println("Created VaccineOrderWorkRequest for item: " + oi.getVaccineProduct().getVaccineName());

                        // Deduct amount from CDC
                        double amount = oi.getQuantity() * oi.getVaccineProduct().getVaccinePrice();
                        if (cdc.getFinancialAccount() != null) {
                            double newBalance = cdc.getFinancialAccount().getTotalBalance() - amount;
                            cdc.getFinancialAccount().setTotalBalance(newBalance);
                            System.out.println("Deducted " + amount + " from CDC account. New balance: " + newBalance);
                        }

                        // Add amount to Manufacturer
                        if (manuf.getFinancialAccount() != null) {
                            double newBalance = manuf.getFinancialAccount().getTotalBalance() + amount;
                            manuf.getFinancialAccount().setTotalBalance(newBalance);
                            System.out.println("Added " + amount + " to Manufacturer account. New balance: " + newBalance);
                        }

                        // Add the work request to the Manufacturer's organization queue
                        for (Organization org : manuf.getOrganizationDirectory().getOrganizationList()) {
                            if (org instanceof ManufactureOrganization) {
                                org.getWorkQueue().addWorkRequest(vaccineWorkRequest);
                                System.out.println("Added work request to ManufactureOrganization: " + org.getName());
                            }
                        }
                    }
                }
            }

            JOptionPane.showMessageDialog(null, "Your order has been successfully added!");
            System.out.println("Order successfully added.");

            // Navigate to the Create Vaccine Order panel
            CreateVaccineOrderJPanel panel = new CreateVaccineOrderJPanel(workContainer, cdc, business, cdcOrg, userAccount);
            workContainer.add("CreateVaccineOrderJPanel", panel);
            CardLayout layout = (CardLayout) workContainer.getLayout();
            layout.next(workContainer);
            System.out.println("Navigated to CreateVaccineOrderJPanel.");

        } else {
            JOptionPane.showMessageDialog(null, "Error occurred when trying to check out!");
            System.out.println("Error: Cart order is null.");
        }

        // Refresh the manufacturer vaccines and cart table
        displayManufacturerVaccines();
        refreshCartTable();
        System.out.println("Refreshed manufacturer vaccines and cart table.");

    } catch (Exception e) {
        System.out.println("Error occurred during checkout: " + e.getMessage());
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "An error occurred during checkout. Please check the logs for details.");
    }
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
    private javax.swing.JButton backJButton;
    private javax.swing.JTable cartjTable;
    private javax.swing.JButton checkOutJButton;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox manufacturerjComboBox;
    private javax.swing.JTable manufacturerjTable;
    private javax.swing.JButton modifyJButton;
    private javax.swing.JTextField modifyJTextField;
    private javax.swing.JSpinner quantityJSpinner;
    private javax.swing.JButton removeJButton;
    private javax.swing.JButton searchjButton;
    private javax.swing.JTextField totalAmountOrderjTextField;
    private javax.swing.JTextField vaccineSearchjTextField;
    // End of variables declaration//GEN-END:variables
}
