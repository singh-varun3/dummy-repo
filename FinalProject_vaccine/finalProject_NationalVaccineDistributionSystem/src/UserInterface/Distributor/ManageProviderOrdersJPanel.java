/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.Distributor;

import Business.Business;
import Business.Enterprise.Enterprise;
import Business.NationalEnterprise.Distributor;
import Business.Organization.DistributorOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ProviderVaccineOrderWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vaibhav
 */
public class ManageProviderOrdersJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageProviderOrdersJPanel
     */
    
     private JPanel workContainer;
    
    private Distributor enterprise;
    private UserAccount userAccount;
    private DistributorOrganization distributorOrg;
    private Business business;
    
    
    public ManageProviderOrdersJPanel(JPanel workContainer,Distributor enterprise,DistributorOrganization distributorOrg, UserAccount userAccount,Business business) {
        initComponents();
         this.userAccount = userAccount;
        this.enterprise = enterprise;
        this.distributorOrg = distributorOrg;
        this.business = business;
        this.workContainer = workContainer;
        populateContractTable();
        populateAdhocTable();
    }
    
    private void populateContractTable(){
        
        DefaultTableModel model = (DefaultTableModel) contractjTable.getModel();
        model.setRowCount(0);
        
         DistributorOrganization distOrg = null;
         
        for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList())
        {   if(org instanceof DistributorOrganization)
        {   distOrg = (DistributorOrganization)org;
            for(WorkRequest workRequest : distOrg.getWorkQueue().getWorkRequestList())
            {   if(workRequest instanceof ProviderVaccineOrderWorkRequest)
            {ProviderVaccineOrderWorkRequest vaccineOrderWR = (ProviderVaccineOrderWorkRequest)workRequest;
                if(vaccineOrderWR.isAdhocRequest()== false)
                {
                Object[] row = new Object[9];
            
                row[0] = vaccineOrderWR;
                row[1] = getContractDetails(vaccineOrderWR);
                row[2] = vaccineOrderWR.getEnterprise();
                row[3] = vaccineOrderWR.getRequestState();
                row[4] = vaccineOrderWR.getSender();
                row[5] = vaccineOrderWR.getDeliveryDate();
                row[6] = vaccineOrderWR.getStatus();
                row[7] = vaccineOrderWR.getReceiver();
                row[8] = vaccineOrderWR.getResolveDate();
                
                model.addRow(row);
                
                }
            }
            }
        }
        
        
        
        
    }
        
        
    }
    
    private void populateAdhocTable(){
        
        DefaultTableModel model = (DefaultTableModel) adhocjTable.getModel();
        model.setRowCount(0);
        
         DistributorOrganization distOrg = null;
         
        for(Organization org : enterprise.getOrganizationDirectory().getOrganizationList())
        {   if(org instanceof DistributorOrganization)
        {   distOrg = (DistributorOrganization)org;
            for(WorkRequest workRequest : distOrg.getWorkQueue().getWorkRequestList())
            {   if(workRequest instanceof ProviderVaccineOrderWorkRequest)
            {ProviderVaccineOrderWorkRequest vaccineOrderWR = (ProviderVaccineOrderWorkRequest)workRequest;
                if(vaccineOrderWR.isAdhocRequest()== true)
                {
                Object[] row = new Object[7];
            
                row[0] = vaccineOrderWR;
                row[1] = vaccineOrderWR.getEnterprise();
                row[2] = vaccineOrderWR.getRequestState();
                row[3] = vaccineOrderWR.getSender();
                row[4] = vaccineOrderWR.getStatus();
                row[5] = vaccineOrderWR.getReceiver();
                row[6] = vaccineOrderWR.getResolveDate();
                
                
                model.addRow(row);
                
                }
            }
            }
        }
        
        
        
        
    }
        
        
        
        
        
        
    }
    
    
    private String getContractDetails(ProviderVaccineOrderWorkRequest request){
        
        if(request.isBimonthlyContract())
            return "Bi-Monthly";
        else if(request.isMonthlyContract())
            return "Monthly";
        else
           return "Ad-hoc";
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        contractjTable = new javax.swing.JTable();
        refreshContractjButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        viewDetailsContractjButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        adhocjTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        refreshAdocjButton = new javax.swing.JButton();
        viewDetailsAdhocjButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Provider Orders");

        contractjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order Number", "Contract Type", "Provider", "State", "Sender", "Next Delivery Date", "Status", "Shipped by", "Last Shipping Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        contractjTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(contractjTable);

        refreshContractjButton.setText("Refresh");
        refreshContractjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshContractjButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Contract Orders:");

        viewDetailsContractjButton.setText("View Details and Ship >>");
        viewDetailsContractjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDetailsContractjButtonActionPerformed(evt);
            }
        });

        adhocjTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order Number", "Provider", "State", "Sender", "Status", "Shipped By", "Shipping Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        adhocjTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(adhocjTable);

        jLabel3.setText("Adhoc Orders:");

        refreshAdocjButton.setText("Refresh");
        refreshAdocjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshAdocjButtonActionPerformed(evt);
            }
        });

        viewDetailsAdhocjButton.setText("View Details and Ship >>");
        viewDetailsAdhocjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDetailsAdhocjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshContractjButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 638, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refreshAdocjButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(viewDetailsContractjButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(viewDetailsAdhocjButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refreshContractjButton)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(viewDetailsContractjButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(refreshAdocjButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(viewDetailsAdhocjButton)
                .addContainerGap(26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void refreshContractjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshContractjButtonActionPerformed
        // TODO add your handling code here:
        populateContractTable();
    }//GEN-LAST:event_refreshContractjButtonActionPerformed

    private void viewDetailsContractjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDetailsContractjButtonActionPerformed
        // TODO add your handling code here:

        int selectedRow = contractjTable.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select an Order from table");
            return;
        }

        ProviderVaccineOrderWorkRequest request = (ProviderVaccineOrderWorkRequest)contractjTable.getValueAt(selectedRow, 0);

        ViewContractDetailsAndShipJPanel panel = new ViewContractDetailsAndShipJPanel(workContainer, userAccount, business, request, enterprise);
        workContainer.add("ViewContractDetailsAndShipJPanel", panel);
        CardLayout layout = (CardLayout)workContainer.getLayout();
        layout.next(workContainer);
    }//GEN-LAST:event_viewDetailsContractjButtonActionPerformed

    private void refreshAdocjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshAdocjButtonActionPerformed
        // TODO add your handling code here:
        populateContractTable();
    }//GEN-LAST:event_refreshAdocjButtonActionPerformed

    private void viewDetailsAdhocjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDetailsAdhocjButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = adhocjTable.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select an Order from table");
            return;
        }

        ProviderVaccineOrderWorkRequest request = (ProviderVaccineOrderWorkRequest)adhocjTable.getValueAt(selectedRow, 0);

        ViewAdhocDetailsAndShipJPanel panel = new ViewAdhocDetailsAndShipJPanel(workContainer, userAccount, business, request, enterprise);
        workContainer.add("ViewAdhocDetailsAndShipJPanel", panel);
        CardLayout layout = (CardLayout)workContainer.getLayout();
        layout.next(workContainer);
    }//GEN-LAST:event_viewDetailsAdhocjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable adhocjTable;
    private javax.swing.JTable contractjTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton refreshAdocjButton;
    private javax.swing.JButton refreshContractjButton;
    private javax.swing.JButton viewDetailsAdhocjButton;
    private javax.swing.JButton viewDetailsContractjButton;
    // End of variables declaration//GEN-END:variables
}
