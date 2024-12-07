/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.SystemAdmin;

import Business.Business;
import Business.UserAccount.UserAccount;
import UserInterface.UpdateUserAccountJPanel;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author Vaibhav
 */
public class SystemAdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form SystemAdminWorkAreaJPanel
     */
     private JPanel userProcessContainer;
    private Business business;
    private UserAccount userAccount;
    
    public SystemAdminWorkAreaJPanel(JPanel userProcessContainer,Business business, UserAccount userAccount ) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;
        this.userAccount = userAccount;
        nameLabel.setText(userAccount.getPerson().getFirstName()+ " "+ userAccount.getPerson().getLastName());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        workContainer = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        mainMenuContainer = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        manageStatesjButton = new javax.swing.JButton();
        manageCityJButton = new javax.swing.JButton();
        manageManufacturersjButton = new javax.swing.JButton();
        manageProvidersjButton = new javax.swing.JButton();
        manageVaccineCatalogjButton = new javax.swing.JButton();
        manageDiseaseCatalogjButton = new javax.swing.JButton();
        manageUserAccountJButton = new javax.swing.JButton();
        manageInsuranceCompanyjButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        profileViewContainer = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        roleLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        updateUserProfilejButton = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jSplitPane1.setDividerLocation(170);

        workContainer.setLayout(new java.awt.CardLayout());
        jSplitPane1.setRightComponent(workContainer);

        jSplitPane2.setDividerLocation(450);
        jSplitPane2.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        mainMenuContainer.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Main Menu:");

        manageStatesjButton.setText("Manage States ");
        manageStatesjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageStatesjButtonActionPerformed(evt);
            }
        });

        manageCityJButton.setText("Manage Citys");
        manageCityJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageCityJButtonActionPerformed(evt);
            }
        });

        manageManufacturersjButton.setText("Manage Manufacturers");
        manageManufacturersjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageManufacturersjButtonActionPerformed(evt);
            }
        });

        manageProvidersjButton.setText("Manage Providers");
        manageProvidersjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageProvidersjButtonActionPerformed(evt);
            }
        });

        manageVaccineCatalogjButton.setText("Manage Vaccine Catalog");
        manageVaccineCatalogjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageVaccineCatalogjButtonActionPerformed(evt);
            }
        });

        manageDiseaseCatalogjButton.setText("Manage Disease Catalog");
        manageDiseaseCatalogjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageDiseaseCatalogjButtonActionPerformed(evt);
            }
        });

        manageUserAccountJButton.setText("Manage User Accounts");
        manageUserAccountJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageUserAccountJButtonActionPerformed(evt);
            }
        });

        manageInsuranceCompanyjButton.setText("Manage Insurance Company");
        manageInsuranceCompanyjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageInsuranceCompanyjButtonActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/SystemAdmin/osa_user_blue_sysadmin.png"))); // NOI18N
        jLabel6.setText("jLabel6");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("SYSTEM");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("ADMIN");

        javax.swing.GroupLayout mainMenuContainerLayout = new javax.swing.GroupLayout(mainMenuContainer);
        mainMenuContainer.setLayout(mainMenuContainerLayout);
        mainMenuContainerLayout.setHorizontalGroup(
            mainMenuContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainMenuContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainMenuContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addComponent(manageVaccineCatalogjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageProvidersjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageManufacturersjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageCityJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageStatesjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageDiseaseCatalogjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageUserAccountJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageInsuranceCompanyjButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(mainMenuContainerLayout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainMenuContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        mainMenuContainerLayout.setVerticalGroup(
            mainMenuContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainMenuContainerLayout.createSequentialGroup()
                .addGroup(mainMenuContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(mainMenuContainerLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manageStatesjButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manageCityJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manageManufacturersjButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manageProvidersjButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manageVaccineCatalogjButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manageDiseaseCatalogjButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manageUserAccountJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(manageInsuranceCompanyjButton)
                .addGap(86, 86, 86))
        );

        jSplitPane2.setTopComponent(mainMenuContainer);

        profileViewContainer.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("User Profile:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Name: ");

        nameLabel.setText("jLabel3");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Role: ");

        roleLabel.setText("System Admin");

        updateUserProfilejButton.setText("Update User Account");
        updateUserProfilejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateUserProfilejButtonActionPerformed(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/UserInterface/userAccount.gif"))); // NOI18N
        jLabel9.setText("jLabel9");

        javax.swing.GroupLayout profileViewContainerLayout = new javax.swing.GroupLayout(profileViewContainer);
        profileViewContainer.setLayout(profileViewContainerLayout);
        profileViewContainerLayout.setHorizontalGroup(
            profileViewContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileViewContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(profileViewContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(profileViewContainerLayout.createSequentialGroup()
                        .addGroup(profileViewContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(profileViewContainerLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(profileViewContainerLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(roleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4)
                            .addGroup(profileViewContainerLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)))
                        .addContainerGap(40, Short.MAX_VALUE))
                    .addGroup(profileViewContainerLayout.createSequentialGroup()
                        .addComponent(updateUserProfilejButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        profileViewContainerLayout.setVerticalGroup(
            profileViewContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(profileViewContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(profileViewContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(profileViewContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(profileViewContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(roleLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateUserProfilejButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jSplitPane2.setRightComponent(profileViewContainer);

        jSplitPane1.setLeftComponent(jSplitPane2);

        add(jSplitPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void manageStatesjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageStatesjButtonActionPerformed
        // TODO add your handling code here:
        ManageStateJPanel panel = new ManageStateJPanel(workContainer, business);
        workContainer.add("ManageStateJPanel", panel);
        CardLayout layout = (CardLayout)workContainer.getLayout();
        layout.next(workContainer);
        
    }//GEN-LAST:event_manageStatesjButtonActionPerformed

    private void manageCityJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageCityJButtonActionPerformed
        // TODO add your handling code here:
        ManageCityJPanel panel = new ManageCityJPanel(workContainer, business);
        workContainer.add("ManageCityJPanel", panel);
        CardLayout layout = (CardLayout)workContainer.getLayout();
        layout.next(workContainer);
        
        
    }//GEN-LAST:event_manageCityJButtonActionPerformed

    private void manageManufacturersjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageManufacturersjButtonActionPerformed
        // TODO add your handling code here:
        ManageManufacturersJPanel panel = new ManageManufacturersJPanel(workContainer, business);
        workContainer.add("ManageManufacturersJPanel", panel);
        CardLayout layout = (CardLayout)workContainer.getLayout();
        layout.next(workContainer);
    }//GEN-LAST:event_manageManufacturersjButtonActionPerformed

    private void manageVaccineCatalogjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageVaccineCatalogjButtonActionPerformed
        // TODO add your handling code here:
        ManageVaccineCatalogJPanel panel = new ManageVaccineCatalogJPanel(workContainer, business);
        workContainer.add("ManageVaccineCatalogJPanel", panel);
        CardLayout layout = (CardLayout)workContainer.getLayout();
        layout.next(workContainer);
    }//GEN-LAST:event_manageVaccineCatalogjButtonActionPerformed

    private void manageDiseaseCatalogjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageDiseaseCatalogjButtonActionPerformed
        // TODO add your handling code here:
        ManageDiseaseCatalogJPanel panel = new ManageDiseaseCatalogJPanel(workContainer, business);
        workContainer.add("ManageDiseaseCatalogJPanel", panel);
        CardLayout layout = (CardLayout)workContainer.getLayout();
        layout.next(workContainer);
    }//GEN-LAST:event_manageDiseaseCatalogjButtonActionPerformed

    private void manageProvidersjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageProvidersjButtonActionPerformed
        // TODO add your handling code here:
        ManageProviderJPanel panel = new ManageProviderJPanel(workContainer, business);
        workContainer.add("ManageProviderJPanel", panel);
        CardLayout layout = (CardLayout)workContainer.getLayout();
        layout.next(workContainer);
    }//GEN-LAST:event_manageProvidersjButtonActionPerformed

    private void manageUserAccountJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageUserAccountJButtonActionPerformed
        // TODO add your handling code here:
        ManageUserAccountJPanel panel = new ManageUserAccountJPanel(workContainer, business);
        workContainer.add("ManageUserAccountJPanel", panel);
        CardLayout layout = (CardLayout)workContainer.getLayout();
        layout.next(workContainer);
    }//GEN-LAST:event_manageUserAccountJButtonActionPerformed

    private void manageInsuranceCompanyjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageInsuranceCompanyjButtonActionPerformed
        // TODO add your handling code here:
        ManageInsuranceCompanyJPanel panel = new ManageInsuranceCompanyJPanel(workContainer, business);
        workContainer.add("ManageInsuranceCompanyJPanel", panel);
        CardLayout layout = (CardLayout)workContainer.getLayout();
        layout.next(workContainer);
        
        
    }//GEN-LAST:event_manageInsuranceCompanyjButtonActionPerformed

    private void updateUserProfilejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateUserProfilejButtonActionPerformed
        // TODO add your handling code here:
        UpdateUserAccountJPanel panel = new UpdateUserAccountJPanel(workContainer, userAccount, business);
        workContainer.add("UpdateUserAccountJPanel", panel);
        CardLayout layout = (CardLayout)workContainer.getLayout();
        layout.next(workContainer);
        
        
        
    }//GEN-LAST:event_updateUserProfilejButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JPanel mainMenuContainer;
    private javax.swing.JButton manageCityJButton;
    private javax.swing.JButton manageDiseaseCatalogjButton;
    private javax.swing.JButton manageInsuranceCompanyjButton;
    private javax.swing.JButton manageManufacturersjButton;
    private javax.swing.JButton manageProvidersjButton;
    private javax.swing.JButton manageStatesjButton;
    private javax.swing.JButton manageUserAccountJButton;
    private javax.swing.JButton manageVaccineCatalogjButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel profileViewContainer;
    private javax.swing.JLabel roleLabel;
    private javax.swing.JButton updateUserProfilejButton;
    private javax.swing.JPanel workContainer;
    // End of variables declaration//GEN-END:variables
}
