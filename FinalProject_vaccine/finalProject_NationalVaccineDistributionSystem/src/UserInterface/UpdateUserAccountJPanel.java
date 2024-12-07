/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface;

import Business.Business;
import Business.Enterprise.Enterprise;
import Business.NationalEnterprise.Manufacturer;
import Business.Network.CityNetwork;
import Business.Network.StateNetwork;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Vaibhav
 */
public class UpdateUserAccountJPanel extends javax.swing.JPanel {

    /**
     * Creates new form UpdateUserAccountJPanel
     */
    private JPanel workContainer;
    private UserAccount userAccount;
    private Business business;
    
    public UpdateUserAccountJPanel(JPanel workContainer,UserAccount userAccount, Business business) {
        initComponents();
        this.workContainer = workContainer;
        this.userAccount = userAccount;
        this.business = business;
        firstNamejTextField.setText(userAccount.getPerson().getFirstName());
        lastNamejTextField.setText(userAccount.getPerson().getLastName());
        email1jTextField.setText(userAccount.getPerson().getEmail());
        phonejTextField.setText(String.valueOf(userAccount.getPerson().getPhone()));
        dateOfBirthjDateChooser.setDate(userAccount.getPerson().getDateOfBirth());
        userNamejTextField.setText(userAccount.getUsername());
        passwordjTextField.setText(userAccount.getPassword());
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
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lastNamejTextField = new javax.swing.JTextField();
        firstNamejTextField = new javax.swing.JTextField();
        dateOfBirthjDateChooser = new com.toedter.calendar.JDateChooser();
        phonejTextField = new javax.swing.JTextField();
        email1jTextField = new javax.swing.JTextField();
        passwordjTextField = new javax.swing.JTextField();
        userNamejTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        updateAccountjButton = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Update User Account");

        jLabel2.setText("First Name:");

        jLabel4.setText("Last Name:");

        jLabel5.setText("email:");

        jLabel6.setText("Phone:");

        jLabel7.setText("Date of Birth:");

        jLabel8.setText("UserName:");

        jLabel9.setText("Password:");

        firstNamejTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNamejTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Personal Information:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Account details");

        updateAccountjButton.setText("Update Account");
        updateAccountjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateAccountjButtonActionPerformed(evt);
            }
        });

        jSeparator5.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jSeparator1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(firstNamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(lastNamejTextField)
                                                .addComponent(phonejTextField)
                                                .addComponent(dateOfBirthjDateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                                .addComponent(email1jTextField))))
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(17, 17, 17)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(userNamejTextField)
                                            .addComponent(passwordjTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 328, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(300, 300, 300)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(updateAccountjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstNamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastNamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email1jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(phonejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateOfBirthjDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(27, 27, 27)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateAccountjButton)
                .addContainerGap(81, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void firstNamejTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNamejTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNamejTextFieldActionPerformed

    private void updateAccountjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateAccountjButtonActionPerformed
        // TODO add your handling code here:
        try{
        String firstName = firstNamejTextField.getText();
        String lastName = lastNamejTextField.getText();
        String email = email1jTextField.getText();
        String phoneText = phonejTextField.getText();
        long phone = Long.parseLong(phonejTextField.getText());
        Date dob = dateOfBirthjDateChooser.getDate();
        String username = userNamejTextField.getText();
        String password = passwordjTextField.getText();
        if(firstName.trim().equalsIgnoreCase(""))
        {
             JOptionPane.showMessageDialog(null, "First name empty");
            return;
        }
        userAccount.getPerson().setFirstName(firstName);
        if(lastName.trim().equalsIgnoreCase(""))
        {
             JOptionPane.showMessageDialog(null, "Last name empty");
            return;
        }
        userAccount.getPerson().setLastName(lastName);
         
        userAccount.getPerson().setDateOfBirth(dob);
         if(email.trim().equalsIgnoreCase(""))
        {
             JOptionPane.showMessageDialog(null, "email empty");
            return;
        }
        userAccount.getPerson().setEmail(email);
        if(phoneText.trim().equalsIgnoreCase(""))
        {
             JOptionPane.showMessageDialog(null, "phone empty!");
            return;
        }
        userAccount.getPerson().setPhone(phone);
        if(username.equalsIgnoreCase(""))
        {
             JOptionPane.showMessageDialog(null, "username empty!");
            return;
        }
           boolean check = checkIfUserAccountExists(username);
           if(check == true)
           {
               JOptionPane.showMessageDialog(null, "username exists please enter a new username!");
            return;
               
           }
            
        userAccount.setUsername(username);
        if(password.equalsIgnoreCase(""))
        {
             JOptionPane.showMessageDialog(null, "password empty!");
            return;
        }
        userAccount.setPassword(password);
        
        JOptionPane.showMessageDialog(null, "Account Updated");
        
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Please enter numeric value for Phone");
            return;
        }
        
                
        
        
        
        
        
        
        
    }//GEN-LAST:event_updateAccountjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dateOfBirthjDateChooser;
    private javax.swing.JTextField email1jTextField;
    private javax.swing.JTextField firstNamejTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JTextField lastNamejTextField;
    private javax.swing.JTextField passwordjTextField;
    private javax.swing.JTextField phonejTextField;
    private javax.swing.JButton updateAccountjButton;
    private javax.swing.JTextField userNamejTextField;
    // End of variables declaration//GEN-END:variables
}
