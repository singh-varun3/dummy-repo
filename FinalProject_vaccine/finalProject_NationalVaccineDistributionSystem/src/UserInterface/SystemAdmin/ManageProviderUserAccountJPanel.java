/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.SystemAdmin;

import Business.Business;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.NationalEnterprise.Manufacturer;
import Business.Network.CityNetwork;
import Business.Network.StateNetwork;
import Business.Organization.Organization;
import Business.Person.EnterpriseAdminPerson;
import Business.Role.EnterpriseAdminRole;
import Business.Role.Role.RoleType;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vaibhav
 */
public class ManageProviderUserAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageProviderUserAccountJPanel
     */
    
    private JPanel workContainer;
    private Business business;
    public ManageProviderUserAccountJPanel(JPanel workContainer, Business business) {
        initComponents();
        this.workContainer = workContainer;
        this.business = business;
        populateTable();
        providerNamejComboBox.removeAllItems();
        populateProviderJComboBox();
    }
    
    private void populateTable(){
        
        DefaultTableModel model = (DefaultTableModel) providerJTable.getModel();
        model.setRowCount(0);
        
        for(StateNetwork state : business.getStateList())
        {
            for(CityNetwork city : state.getCityList())
            {
                for(Enterprise hospital :city.getEnterpriseDirectory().getEnterpriseList())
                {   
                    for(UserAccount ua : hospital.getUserAccountDirectory().getUserAccountList())
                    {   
                        if(ua.getRole() instanceof EnterpriseAdminRole)
                        {Object[] row = new Object[4];
                        row[0] = ua;
                        row[1] = ua.getPassword();
                        row[2] = hospital;
                        row[3] = ua.getPerson().getFirstName()+ " " + ua.getPerson().getLastName();
                        model.addRow(row);
                        }
                    }
                }
            }
            
        }
        
        
        
    }
    
    private void populateProviderJComboBox(){
        
        providerNamejComboBox.removeAllItems();
        for(StateNetwork state : business.getStateList())
        {
            for(CityNetwork city : state.getCityList())
            {
                for(Enterprise hospital :city.getEnterpriseDirectory().getEnterpriseList())
                {   
                    
                    providerNamejComboBox.addItem(hospital);
                }
            }
            
        }
        
        
    }
    
    private boolean checkIfUserAccountExists(String username){
        
        boolean flag= false;
        
        flag = business.getUserAccountDirectory().checkIfUserAccountExists(username );
        
        if (flag == false) {
            //not a sys admin
            //check if it is a cdc enterprise admin

            flag = business.getCdc().getUserAccountDirectory().checkIfUserAccountExists(username);
            if(flag == false)
            { for(Organization org: business.getCdc().getOrganizationDirectory().getOrganizationList())
            {
                flag = org.getUserAccountDirectory().checkIfUserAccountExists(username);
                if(flag == true)
                break;
            }
            
            }
            
        }
        if (flag == false) {
                //not a sys,cdc admin
            //check if it is a manufacture enterprise admin
            for(Manufacturer manufacturer : business.getManufacturerDirectory().getManufacturerList())
            { 
                flag = manufacturer.getUserAccountDirectory().checkIfUserAccountExists(username);
                
                if(flag == false)
                {
                    for(Organization org: manufacturer.getOrganizationDirectory().getOrganizationList())
                {
                    flag = org.getUserAccountDirectory().checkIfUserAccountExists(username);
                    if(flag == true)
                        break;
                }
                }
                if(flag == true)
                { 
                    break;
                }
            }
            
                
            
        }if (flag == false) {
                //not a sys,cdc,manufacturer admin
            //check if it is a distributor enterprise admin

            flag = business.getDistributor().getUserAccountDirectory().checkIfUserAccountExists(username);
            if(flag == false)
            { for(Organization org: business.getDistributor().getOrganizationDirectory().getOrganizationList())
            { flag = org.getUserAccountDirectory().checkIfUserAccountExists(username);
                if(flag == true)
                {
                    
                    break;
                }
            }
            }
            

        }if (flag == false) {
                //not a sys,cdc,manufacturer,distributor admin
            //check if it is a PHD enterprise admin
            for (StateNetwork state : business.getStateList()) {
                if(flag == false)
                { flag = state.getPublicHealthDepartment().getUserAccountDirectory().checkIfUserAccountExists(username);
                if(flag == false)
                {for(Organization org: state.getPublicHealthDepartment().getOrganizationDirectory().getOrganizationList())
                {flag = org.getUserAccountDirectory().checkIfUserAccountExists(username);
                    if(flag == true)
                    {   
                        break;
                    }
                }
                }
                
                if (flag == false) {
                              //not a sys,cdc,manufacturer,distributor,PHD admin
                    //check if it is a Provider/hospital enterprise admin

                    for (CityNetwork city : state.getCityList()) {
                        for (Enterprise hospital : city.getEnterpriseDirectory().getEnterpriseList()) {
                            flag = hospital.getUserAccountDirectory().checkIfUserAccountExists(username);
                            if (flag == false) {
                                for (Organization o : hospital.getOrganizationDirectory().getOrganizationList()) {
                                    flag = o.getUserAccountDirectory().checkIfUserAccountExists(username);

                                    if (flag == true) {
                                        
                                        break;

                                    }
                                }
                            }
                            else
                            {   
                                //find the useraccount as enterprise admin
                                
                                break;
                            }
                            // check if we already found the ord user account
                    if(flag == true)
                    {
                        break;
                    }
                            

                        }
                        if(flag == true)
                {
                    break;
                }
                    }

                } 
                else {
                    
                    break;
                }

            }
        }
        }
    
        
        return flag;
        
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
        providerJTable = new javax.swing.JTable();
        removeAdminJButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        providerNamejComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        userNamejTextField = new javax.swing.JTextField();
        passwordJTextField = new javax.swing.JTextField();
        addAdminJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        firstNameJTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lastNamejTextField = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Provider Admins");

        providerJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "username", "password", "Enterprise Name", "Person name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        providerJTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(providerJTable);
        if (providerJTable.getColumnModel().getColumnCount() > 0) {
            providerJTable.getColumnModel().getColumn(0).setResizable(false);
            providerJTable.getColumnModel().getColumn(1).setResizable(false);
            providerJTable.getColumnModel().getColumn(2).setResizable(false);
            providerJTable.getColumnModel().getColumn(3).setResizable(false);
        }

        removeAdminJButton.setText("Remove Admin");
        removeAdminJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAdminJButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Add New Admin:");

        jLabel3.setText("Provider Enterprise: ");

        providerNamejComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Username:");

        jLabel5.setText("Password:");

        addAdminJButton.setText("Add Admin");
        addAdminJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addAdminJButtonActionPerformed(evt);
            }
        });

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jLabel6.setText("First Name:");

        jLabel7.setText("Last Name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(removeAdminJButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(backJButton)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(providerNamejComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(userNamejTextField)
                                    .addComponent(passwordJTextField)
                                    .addComponent(firstNameJTextField)
                                    .addComponent(lastNamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(112, 112, 112)
                                .addComponent(addAdminJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeAdminJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(providerNamejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lastNamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(userNamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(passwordJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(addAdminJButton)
                .addGap(18, 18, 18)
                .addComponent(backJButton)
                .addContainerGap(84, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        workContainer.remove(this);
        CardLayout layout = (CardLayout) workContainer.getLayout();
        layout.previous(workContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void removeAdminJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAdminJButtonActionPerformed
        // TODO add your handling code here:
         int row = providerJTable.getSelectedRow();
        if(row<0) {
            JOptionPane.showMessageDialog(null, "Please select a UserAccount from table");
            return;
        }
        
        UserAccount ua = (UserAccount)providerJTable.getValueAt(row, 0);
        HospitalEnterprise hospital = (HospitalEnterprise)providerJTable.getValueAt(row, 2);
         hospital.getUserAccountDirectory().removeUserAccount(ua);
        
        populateTable();
    }//GEN-LAST:event_removeAdminJButtonActionPerformed

    private void addAdminJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addAdminJButtonActionPerformed
        // TODO add your handling code here:
        
        HospitalEnterprise provider = (HospitalEnterprise) providerNamejComboBox.getSelectedItem();
        String username = userNamejTextField.getText();
        if(username.trim().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter a Username!");
            return;
        }
        String password = passwordJTextField.getText();
        if(password.trim().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter a Password!");
            return;
        }
        
        String firstName = firstNameJTextField.getText();
        if(firstName.trim().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter a first Name!");
            return;
        }
        String lastName = lastNamejTextField.getText();
        if(lastName.trim().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter a last Name!");
            return;
        }
        boolean check = checkIfUserAccountExists(username);
        if(check == true)
        {
            JOptionPane.showMessageDialog(null, "Username exists, please choose a differnt username!");
            return;
            
        }
        
        EnterpriseAdminPerson admin = (EnterpriseAdminPerson)provider.getPersonDirectory().createPerson(firstName, lastName, RoleType.EnterpriseAdmin);
        provider.getUserAccountDirectory().createUserAccount(username, password, admin, new EnterpriseAdminRole());
        
        populateTable();
    }//GEN-LAST:event_addAdminJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addAdminJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField firstNameJTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField lastNamejTextField;
    private javax.swing.JTextField passwordJTextField;
    private javax.swing.JTable providerJTable;
    private javax.swing.JComboBox providerNamejComboBox;
    private javax.swing.JButton removeAdminJButton;
    private javax.swing.JTextField userNamejTextField;
    // End of variables declaration//GEN-END:variables
}
