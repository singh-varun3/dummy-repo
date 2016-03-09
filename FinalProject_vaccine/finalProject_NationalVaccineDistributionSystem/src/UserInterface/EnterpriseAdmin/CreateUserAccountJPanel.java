/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.EnterpriseAdmin;

import Business.Business;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.NationalEnterprise.Manufacturer;
import Business.Network.CityNetwork;
import Business.Network.StateNetwork;
import Business.Organization.CDCOrganization;
import Business.Organization.DistributorOrganization;
import Business.Organization.HospitalOrganization;
import Business.Organization.ManufactureOrganization;
import Business.Organization.Organization;
import Business.Organization.PHDImmunizationOrganization;
import Business.Organization.SatelliteClinicOrganization;
import Business.Person.Person;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Vaibhav
 */
public class CreateUserAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CreateUserAccountJPanel
     */
    private JPanel workContainer;
    private Enterprise enterprise;
    private ManageUserAccountJPanel panel;
    private Business business;
    public CreateUserAccountJPanel(JPanel workContainer, Enterprise enterprise, ManageUserAccountJPanel panel, Business business) {
        initComponents();
        this.workContainer = workContainer;
        this.enterprise = enterprise;
        this.business = business;
        populateOrganizationComboBox();
        this.panel = panel;
        satelliteClinicjLabel.setVisible(false);
            satelliteClinicjTextField.setVisible(false);
        if(enterprise instanceof HospitalEnterprise)
        {
            satelliteClinicjLabel.setVisible(true);
            satelliteClinicjTextField.setVisible(true);
        }
    }
    
    private void populateOrganizationComboBox(){
        
        organizationjComboBox.removeAllItems();

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            organizationjComboBox.addItem(organization);
        }
    }
    
    public void populatePersonComboBox(Organization organization){
        personjComboBox.removeAllItems();
        
        for (Person person : organization.getPersonDirectory().getPeopleList()){
            personjComboBox.addItem(person);
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
    
    
    
    private void populateRoleComboBox(Organization organization){
        rolejComboBox.removeAllItems();
        for (Role role : organization.getSupportedRole()){
            rolejComboBox.addItem(role);
        }
        /*
        if(organization instanceof CDCOrganization)
            rolejComboBox.addItem(Role.RoleType.CDCEmployee);
        if(organization instanceof ManufactureOrganization)
            rolejComboBox.addItem(Role.RoleType.Manufacturer);
        if(organization instanceof DistributorOrganization)
            rolejComboBox.addItem(Role.RoleType.Distributor);
        if(organization instanceof PHDImmunizationOrganization)
            rolejComboBox.addItem(Role.RoleType.PublicHealthDepartment);
        if(organization instanceof HospitalOrganization)
        {
            rolejComboBox.addItem(Role.RoleType.Provider);
            rolejComboBox.addItem(Role.RoleType.SatelliteClinicProvider);
            rolejComboBox.addItem(Role.RoleType.Patient);
            
        }
        */
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
        organizationjComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        personjComboBox = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        rolejComboBox = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        userNamejTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        passwordjTextField = new javax.swing.JTextField();
        createUserAccountjButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        satelliteClinicjLabel = new javax.swing.JLabel();
        satelliteClinicjTextField = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Create User Account");

        jLabel2.setText("Organization:");

        organizationjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        organizationjComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                organizationjComboBoxActionPerformed(evt);
            }
        });

        jLabel3.setText("Person:");

        personjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Role:");

        rolejComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Username:");

        jLabel6.setText("Password:");

        createUserAccountjButton.setText("Create User Account");
        createUserAccountjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createUserAccountjButtonActionPerformed(evt);
            }
        });

        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        satelliteClinicjLabel.setText("Satellite Clinic Name:");

        satelliteClinicjTextField.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backJButton)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(satelliteClinicjLabel)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(createUserAccountjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(personjComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(rolejComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(userNamejTextField)
                                    .addComponent(passwordjTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                    .addComponent(organizationjComboBox, 0, 174, Short.MAX_VALUE)
                                    .addComponent(satelliteClinicjTextField))))
                        .addGap(0, 255, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(organizationjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(satelliteClinicjLabel)
                            .addComponent(satelliteClinicjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(personjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rolejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userNamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(passwordjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addComponent(createUserAccountjButton)))
                .addGap(15, 15, 15)
                .addComponent(backJButton)
                .addContainerGap(91, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        workContainer.remove(this);
        CardLayout layout = (CardLayout) workContainer.getLayout();
        layout.previous(workContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void organizationjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_organizationjComboBoxActionPerformed
        // TODO add your handling code here:
         Organization organization = (Organization) organizationjComboBox.getSelectedItem();
        if (organization != null){
            populatePersonComboBox(organization);
            populateRoleComboBox(organization);
             if(organization instanceof SatelliteClinicOrganization)
        {   SatelliteClinicOrganization satOrg = (SatelliteClinicOrganization)organization;
            satelliteClinicjTextField.setText(satOrg.getSatelliteClincName());
        }
             else
                 satelliteClinicjTextField.setText("");
        }
        
        
    }//GEN-LAST:event_organizationjComboBoxActionPerformed

    private void createUserAccountjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createUserAccountjButtonActionPerformed
        // TODO add your handling code here:
        
        String userName = userNamejTextField.getText();
        if(userName.trim().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter username");
            return;
        }
        String password = passwordjTextField.getText();
         if(password.trim().equalsIgnoreCase(""))
        {
            JOptionPane.showMessageDialog(null, "Please enter passwords");
            return;
        }
        Organization organization = (Organization) organizationjComboBox.getSelectedItem();
        Person person = (Person) personjComboBox.getSelectedItem();
        Role role = (Role) rolejComboBox.getSelectedItem();
       
        boolean check = checkIfUserAccountExists(userName);
        
        if(check == true)
            {
                JOptionPane.showMessageDialog(null, "Username Exists please choose another username");
            return;
            }
        
        
        
        for(UserAccount ua: organization.getUserAccountDirectory().getUserAccountList())
        {   
            if(ua.getPerson().equals(person))
            {
                JOptionPane.showMessageDialog(null, "Credentials for the person already exists!");
            return;
            }
        }  
        organization.getUserAccountDirectory().createUserAccount(userName, password, person, role);
        
        panel.populateTable();
        JOptionPane.showMessageDialog(null, "User Account Created!");
    }//GEN-LAST:event_createUserAccountjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton createUserAccountjButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JComboBox organizationjComboBox;
    private javax.swing.JTextField passwordjTextField;
    private javax.swing.JComboBox personjComboBox;
    private javax.swing.JComboBox rolejComboBox;
    private javax.swing.JLabel satelliteClinicjLabel;
    private javax.swing.JTextField satelliteClinicjTextField;
    private javax.swing.JTextField userNamejTextField;
    // End of variables declaration//GEN-END:variables
}
