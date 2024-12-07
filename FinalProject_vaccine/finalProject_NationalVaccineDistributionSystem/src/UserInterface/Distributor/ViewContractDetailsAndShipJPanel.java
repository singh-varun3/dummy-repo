/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.Distributor;

import Business.Business;
import Business.Enterprise.HospitalEnterprise;
import Business.NationalEnterprise.Distributor;
import Business.Network.StateNetwork;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.CDCOrganization;
import Business.Organization.DistributorOrganization;
import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;
import Business.Organization.PHDImmunizationOrganization;
import Business.UserAccount.UserAccount;
import Business.Vaccine.VaccineProduct;
import Business.Warehouse.Warehouse;
import Business.WorkQueue.PaymentRequestWorkRequest;
import Business.WorkQueue.ProviderVaccineOrderWorkRequest;
import Business.WorkQueue.ShippingOrderWorkRequest;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vaibhav
 */
public class ViewContractDetailsAndShipJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewContractDetailsAndShipJPanel
     */
    
    private JPanel workContainer;
    
    private Distributor distributorEnterprise;
    
    private UserAccount userAccount;
    private Business business;
    private ProviderVaccineOrderWorkRequest request;
    private boolean flag;
    
    public ViewContractDetailsAndShipJPanel( JPanel workContainer, UserAccount userAccount,Business business, ProviderVaccineOrderWorkRequest request, Distributor distributorEnterprise ) {
        initComponents();
        this.workContainer = workContainer;
        this.userAccount = userAccount;
        this.business = business;
        this.request = request;
        this.distributorEnterprise = distributorEnterprise;
        orderjTextField.setText(String.valueOf(request.getVaccineOrder().getOrderNumber()));
        displayContractDetails();
        calculateTotalCostOfOrder();
        populateOrderTable();
        flag = false;
        
        
        
    }
    
    private void displayContractDetails(){
        
        if(request.isBimonthlyContract())
            contractDetailsjTextField.setText("Bimonthly");
        if(request.isMonthlyContract())
            contractDetailsjTextField.setText("Monthly");
        if(request.isAdhocRequest())
            contractDetailsjTextField.setText("Adhoc");
        
    }
    
    
    private void calculateTotalCostOfOrder(){
        
        double total = 0;
        for(OrderItem oi : request.getVaccineOrder().getOrderList())
        {
            total = total + (oi.getVaccineProduct().getVaccinePrice()*oi.getQuantity());
        }
        totalCostjTextField.setText(String.valueOf(total));
    }
    
    
    private void populateOrderTable(){
        
         int rowCount = orderjTable.getRowCount();
        DefaultTableModel dtm = (DefaultTableModel)orderjTable.getModel();
        
        for(int i=rowCount-1 ; i>=0; i--){
            dtm.removeRow(i);
        }
        
        for(OrderItem oi: request.getVaccineOrder().getOrderList())
        {
            Object[] row = new Object[12];
            
                row[0] = oi.getVaccineProduct();
                row[1] = oi;
                row[2] = oi.getVaccineProduct().getManufacturerName();
                row[3] = oi.getVaccineProduct().getVaccineId();
                row[4] = oi.getVaccineProduct().getBatchId();
                
                row[5] = oi.getVaccineProduct().getVaccinePrice();
                row[6] = String.valueOf(oi.getVaccineProduct().getMinOperatingTemp()+ " - " +oi.getVaccineProduct().getMaxOperatingTemp());
                row[7] = oi.getQuantity();
                row[8] = oi.getVaccineProduct().getManufactureDate();
                row[9] = oi.getVaccineProduct().getDateOfExpiry();
                row[10] = oi.getVaccineProduct().getVaccinePrice()*oi.getQuantity();
                row[11] = oi.getVaccineProduct().getVaccineDefinition().isFederalFunded() ? "Federal" : oi.getVaccineProduct().getVaccineDefinition().getFundedStateList().isEmpty()? "Not Funded" : " State";
               
                dtm.addRow(row);
            
            
            
            
        }
    }
    
    private void RequestPayment(){
        
         //take the request
        
        
       
        
        //create array list for products
        ArrayList<OrderItem> cdcVaccineList = new ArrayList<OrderItem>();
        ArrayList<OrderItem> phdVaccineList = new ArrayList<OrderItem>();
        ArrayList<OrderItem> providerVaccineList = new ArrayList<OrderItem>();
        
        //check if the vaccine is fed funded/ state funded
        for(OrderItem oi: request.getVaccineOrder().getOrderList())
        {   
        
            if(oi.getVaccineProduct().getVaccineDefinition().isFederalFunded())
            {
                cdcVaccineList.add(oi);
                               
            }
            else if(oi.getVaccineProduct().getVaccineDefinition().isStateFunded() && oi.getVaccineProduct().getVaccineDefinition().isVaccineFundedByMentionedState(request.getRequestState()))
            {
                phdVaccineList.add(oi);
            }
            else 
            {
                providerVaccineList.add(oi);
            }
            
        }
        
        //check and send it to respective sites.
        
        if(cdcVaccineList.isEmpty()==false){
          PaymentRequestWorkRequest cdcPaymentRequest = new PaymentRequestWorkRequest();
          cdcPaymentRequest.setVaccineOrder(request.getVaccineOrder());
          cdcPaymentRequest.setSender(userAccount);
          cdcPaymentRequest.setRequestDate(new Date());
          cdcPaymentRequest.setStatus("Pending");
          cdcPaymentRequest.setProviderRequest(request);
          //create a billed order and calculate the total amount
          double totalAmount =0;
          for(OrderItem oi: cdcVaccineList)
          {
              cdcPaymentRequest.getBilledOrder().addNewOrderItem(oi.getQuantity(), oi.getVaccineProduct());
              totalAmount = totalAmount + (oi.getVaccineProduct().getVaccinePrice()*oi.getQuantity());
          }
          
          cdcPaymentRequest.setAmount(totalAmount);
          //store the request in distributor workqueue
            for(Organization org : distributorEnterprise.getOrganizationDirectory().getOrganizationList())
            {
                if(org instanceof DistributorOrganization)
                {
                    DistributorOrganization distOrg = (DistributorOrganization)org;
                    distOrg.getWorkQueue().addWorkRequest(cdcPaymentRequest);
                    break;
                }
            }
          
          //send the request to CDC
          for(Organization org: business.getCdc().getOrganizationDirectory().getOrganizationList()){
              if(org instanceof CDCOrganization){
                  CDCOrganization cdcOrg = (CDCOrganization)org;
                  cdcOrg.getWorkQueue().addWorkRequest(cdcPaymentRequest);
              }
          }
        }
        if(phdVaccineList.isEmpty()==false){
          PaymentRequestWorkRequest phdPaymentRequest = new PaymentRequestWorkRequest();
          phdPaymentRequest.setVaccineOrder(request.getVaccineOrder());
          phdPaymentRequest.setSender(userAccount);
          phdPaymentRequest.setRequestDate(new Date());
          phdPaymentRequest.setStatus("Pending");
          phdPaymentRequest.setProviderRequest(request);
          //create a billed order and calculate the total amount
          double totalAmount =0;
          for(OrderItem oi: phdVaccineList)
          {
              phdPaymentRequest.getBilledOrder().addNewOrderItem(oi.getQuantity(), oi.getVaccineProduct());
              totalAmount = totalAmount + (oi.getVaccineProduct().getVaccinePrice()*oi.getQuantity());
          }
          
          phdPaymentRequest.setAmount(totalAmount);
          //store the request in distributor workqueue
            for(Organization org : distributorEnterprise.getOrganizationDirectory().getOrganizationList())
            {
                if(org instanceof DistributorOrganization)
                {
                    DistributorOrganization distOrg = (DistributorOrganization)org;
                    distOrg.getWorkQueue().addWorkRequest(phdPaymentRequest);
                    break;
                }
            }
          
          //send the request to respective State
          StateNetwork fundedState = request.getRequestState();
          
          for(Organization org: fundedState.getPublicHealthDepartment().getOrganizationDirectory().getOrganizationList()){
              if(org instanceof PHDImmunizationOrganization){
                  PHDImmunizationOrganization phdOrg = (PHDImmunizationOrganization)org;
                  phdOrg.getWorkQueue().addWorkRequest(phdPaymentRequest);
              }
          }
        }
        if(providerVaccineList.isEmpty()==false){
          PaymentRequestWorkRequest providerPaymentRequest = new PaymentRequestWorkRequest();
          providerPaymentRequest.setVaccineOrder(request.getVaccineOrder());
          providerPaymentRequest.setSender(userAccount);
          providerPaymentRequest.setRequestDate(new Date());
          providerPaymentRequest.setStatus("Pending");
          providerPaymentRequest.setProviderRequest(request);
          //create a billed order and calculate the total amount
          double totalAmount =0;
          for(OrderItem oi: providerVaccineList)
          {
              providerPaymentRequest.getBilledOrder().addNewOrderItem(oi.getQuantity(), oi.getVaccineProduct());
              totalAmount = totalAmount + (oi.getVaccineProduct().getVaccinePrice()*oi.getQuantity());
          }
          
          providerPaymentRequest.setAmount(totalAmount);
          //store the request in distributor workqueue
            for(Organization org : distributorEnterprise.getOrganizationDirectory().getOrganizationList())
            {
                if(org instanceof DistributorOrganization)
                {
                    DistributorOrganization distOrg = (DistributorOrganization)org;
                    distOrg.getWorkQueue().addWorkRequest(providerPaymentRequest);
                    break;
                }
            }
          
          
          //send the request to respective Provider
            HospitalEnterprise hospital = (HospitalEnterprise)request.getEnterprise();
          
          for(Organization org: hospital.getOrganizationDirectory().getOrganizationList()){
              if(org instanceof HospitalOrganization){
                  HospitalOrganization hospOrg = (HospitalOrganization)org;
                  hospOrg.getWorkQueue().addWorkRequest(providerPaymentRequest);
              }
          }
        }
        
        JOptionPane.showMessageDialog(null, "Payment request send to respective sites!");
            
            
        
        
        
        
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
        orderjTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderjTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inventoryjTable = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        shipOrderjButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        totalCostjTextField = new javax.swing.JTextField();
        checkInventoryjButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        contractDetailsjTextField = new javax.swing.JTextField();
        backJButton3 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("View Contract Details and Ship");

        jLabel2.setText("Order Number:");

        orderjTextField.setEnabled(false);

        orderjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Code", "Vaccine Name", "Brand", "Vaccine id", "Batch ID", "Price", "Temperature Range", "Quantity", "manufacture date", "expiry date", "Amount", "Funded?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        orderjTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(orderjTable);

        jLabel3.setText("Order Particulars:");

        inventoryjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Code", "Vaccine Name", "Brand", "Warehouse Id", "Warehouse Location", "Vaccine Id", "BatchID", "Vaccines in Inventory", "Available?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        inventoryjTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(inventoryjTable);

        jLabel4.setText("Inventory Check:");

        shipOrderjButton.setText("Ship order");
        shipOrderjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shipOrderjButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Total Cost of the Order:");

        totalCostjTextField.setEnabled(false);

        checkInventoryjButton.setText("Check Inventory");
        checkInventoryjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkInventoryjButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("Contract :");

        contractDetailsjTextField.setEnabled(false);

        backJButton3.setText("<< Back");
        backJButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 527, Short.MAX_VALUE)
                        .addComponent(checkInventoryjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(orderjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalCostjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(contractDetailsjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(backJButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(shipOrderjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(contractDetailsjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(totalCostjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(orderjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(checkInventoryjButton)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shipOrderjButton)
                    .addComponent(backJButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void checkInventoryjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkInventoryjButtonActionPerformed
        // TODO add your handling code here:
         int rowCount = inventoryjTable.getRowCount();
        DefaultTableModel dtm = (DefaultTableModel)inventoryjTable.getModel();
        
        for(int i=rowCount-1 ; i>=0; i--){
            dtm.removeRow(i);
        }
        
        
        
        
        String vaccineCode = null;
        String manufacturer = null;
        String batchId = null;
       // int vaccineId = 0;
        DistributorOrganization distOrg = null;
       
        //counter for checking
        int count =0;
        //get the vaccine name/code and  manufacturers name from the order item
        for(OrderItem oi : request.getVaccineOrder().getOrderList())
        {
            vaccineCode = oi.getVaccineProduct().getVaccineDefinition().getVaccineCode();
            manufacturer = oi.getVaccineProduct().getManufacturerName();
            batchId = oi.getVaccineProduct().getBatchId();
            //vaccineId = oi.getVaccineProduct().getVaccineId();
           
            
            //search through the distributor inventory
            
            for(Organization org: distributorEnterprise.getOrganizationDirectory().getOrganizationList())
            {
                if(org instanceof DistributorOrganization)
                {
                    distOrg = (DistributorOrganization) org;
                    for(Warehouse warehouse: distOrg.getWarehouseDir().getWarehouseList())
                    {   
                        for(VaccineProduct product: warehouse.getVaccineInventoryList())
                        {
                            if(product.getVaccineDefinition().getVaccineCode().equalsIgnoreCase(vaccineCode) && product.getManufacturerName().equalsIgnoreCase(manufacturer)&& product.getBatchId().equals(batchId))// && product.getVaccineId() == oi.getVaccineProduct().getVaccineId() )
                            {   
                                if(product.getAvailablity()>0)
                                { count++;
                                flag = true;
                                Object[] row = new Object[9];
                                
                                row[0] = product;
                                row[1] = product.getVaccineDefinition().getVaccineName();
                                row[2] = product.getManufacturerName();
                                row[3] = warehouse;
                                row[4] = warehouse.getLocation();
                                row[5] = product.getVaccineId();
                                row[6] = product.getBatchId();
                                row[7] = product.getAvailablity();
                                row[8] = "Yes";
                                
                               
                                dtm.addRow(row);
                                }
                                else
                                {
                                    String msg = new String("Not Enough quantity of "+ product);
                                        JOptionPane.showMessageDialog(null, msg);
                                        return;
                                    
                                }
                            }
                        }
                    }
                    
                    
                }
                
            }
            
            
            
            
        }
        
        if(count==0)
        {
            JOptionPane.showMessageDialog(null, "Vaccine not Available in Inventory!");
            return;
        }
        
        
        
        //populate the table
        
        
    }//GEN-LAST:event_checkInventoryjButtonActionPerformed

    private void shipOrderjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shipOrderjButtonActionPerformed

        // TODO add your handling code here:
      
        
        
        
        
        //check if quantity is available
        if(flag== false)
        {
            JOptionPane.showMessageDialog(null, "Vaccine not Available in Inventory!");
            return;
        }
        flag = false;
        //create a shipping order request
        
        ShippingOrderWorkRequest shipRequest = new ShippingOrderWorkRequest();
        shipRequest.setVaccineOrder(request.getVaccineOrder());
        shipRequest.setShippingDate(new Date());
        shipRequest.setSender(userAccount);
        shipRequest.setStatus("Shipped");
        
        //change request status and receiver
        
        request.setReceiver(userAccount);
        request.setStatus("Shipped");
        request.setResolveDate(new Date());
        request.setRequestDate(new Date());
        request.calculateDeliveryDate(request);
        
        //deduct the quantity from the inventory
        
        String vaccineCode = null;
        String manufacturer = null;
        DistributorOrganization distOrg = null;
        int vaccineId = 0;
        String batchID = null;
        boolean warehouseFlag = false;
        boolean productFlag = false;
        
        
        //get the vaccine name/code and  manufacturers name from the order item
        for(OrderItem oi : request.getVaccineOrder().getOrderList())
        {   warehouseFlag= false;
            vaccineCode = oi.getVaccineProduct().getVaccineDefinition().getVaccineCode();
            manufacturer = oi.getVaccineProduct().getManufacturerName();
            batchID = oi.getVaccineProduct().getBatchId();
            //vaccineId = oi.getVaccineProduct().getVaccineId();
            
            //search through the distributor inventory
            for(Organization org: distributorEnterprise.getOrganizationDirectory().getOrganizationList())
            {
                if(org instanceof DistributorOrganization)
                {
                    distOrg = (DistributorOrganization) org;
                    for(Warehouse warehouse: distOrg.getWarehouseDir().getWarehouseList())
                    {   if(warehouseFlag == false)
                    {   
                        
                        
                        for(VaccineProduct product: warehouse.getVaccineInventoryList())
                        {   
                            if(product.getVaccineDefinition().getVaccineCode().equalsIgnoreCase(vaccineCode) && product.getManufacturerName().equalsIgnoreCase(manufacturer) && product.getBatchId().equals(batchID))// && product.getVaccineId() == vaccineId)
                            {   
                                if(product.getAvailablity()>0)
                                { product.setAvailablity(product.getAvailablity()-oi.getQuantity());
                                shipRequest.getShipOrder().addNewOrderItem(oi.getQuantity(), product);
                                warehouseFlag = true;
                                
                                break;
                                }
                                else
                                    {   String msg = new String("Not Enough quantity of "+ product);
                                        JOptionPane.showMessageDialog(null, msg);
                                        return;
                                    }
                            }
                        }
                    }
                    else
                    {
                        break;
                    }
                    }
                    
                    
                    
                }
                
            }
            
            
            
            
        }
        
        
        
        
        //get the provider and insert it in his work queue
        HospitalOrganization hospOrg = null;
        for(Organization org: request.getEnterprise().getOrganizationDirectory().getOrganizationList())
        {
            if(org instanceof HospitalOrganization)
            {
                hospOrg = (HospitalOrganization)org;
                hospOrg.getWorkQueue().addWorkRequest(shipRequest);
                
            }
            
            
        }
        
        JOptionPane.showMessageDialog(null, "Order Shipped!");
        
        // send payment request
        RequestPayment();
        
        
        
    }//GEN-LAST:event_shipOrderjButtonActionPerformed

    private void backJButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton3ActionPerformed
        // TODO add your handling code here:
        workContainer.remove(this);
        CardLayout layout = (CardLayout) workContainer.getLayout();
        layout.previous(workContainer);
    }//GEN-LAST:event_backJButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton3;
    private javax.swing.JButton checkInventoryjButton;
    private javax.swing.JTextField contractDetailsjTextField;
    private javax.swing.JTable inventoryjTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable orderjTable;
    private javax.swing.JTextField orderjTextField;
    private javax.swing.JButton shipOrderjButton;
    private javax.swing.JTextField totalCostjTextField;
    // End of variables declaration//GEN-END:variables
}
