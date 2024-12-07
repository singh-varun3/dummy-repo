/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.EnterpriseAdmin;

import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.SatelliteClinicOrganization;
import Business.Person.Person;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vaibhav
 */
public class ManagePersonJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManagePersonJPanel
     */
    private JPanel workContainer;
    private Enterprise enterprise;
    
    public ManagePersonJPanel(JPanel workContainer, Enterprise enterprise ) {
        initComponents();
        this.workContainer = workContainer;
        this.enterprise = enterprise;
        populateTable();
        
        
    }
    
    private void populateTable(){
        
        DefaultTableModel model = (DefaultTableModel) employeesTable.getModel();
        
        model.setRowCount(0);
        
        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList())
        {   
            for(Person person: organization.getPersonDirectory().getPeopleList())
            {
                Object[] row = new Object[5];
            row[0] = person;
            row[1] = person.getEmail();
            row[2] = person.getPhone();
            row[3] = person.getDateOfBirth();
            if(organization instanceof SatelliteClinicOrganization)
            {
                SatelliteClinicOrganization satOrg =(SatelliteClinicOrganization)organization;
                row[4] = satOrg.getSatelliteClincName()+" Satellite Clinic";
            }
            else 
                row[4] = organization;
           
            
            model.addRow(row);
            }
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
        jScrollPane1 = new javax.swing.JScrollPane();
        employeesTable = new javax.swing.JTable();
        createEmployeejButton = new javax.swing.JButton();
        viewjButton = new javax.swing.JButton();
        removejButton = new javax.swing.JButton();
        refreshjButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Persons");

        employeesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Person Name", "email", "Phone Number", "Date of Birth", "Department"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        employeesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(employeesTable);
        if (employeesTable.getColumnModel().getColumnCount() > 0) {
            employeesTable.getColumnModel().getColumn(0).setResizable(false);
            employeesTable.getColumnModel().getColumn(1).setResizable(false);
            employeesTable.getColumnModel().getColumn(2).setResizable(false);
            employeesTable.getColumnModel().getColumn(3).setResizable(false);
            employeesTable.getColumnModel().getColumn(4).setResizable(false);
        }

        createEmployeejButton.setText("Create New Person >>");
        createEmployeejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createEmployeejButtonActionPerformed(evt);
            }
        });

        viewjButton.setText("View / Update Person");
        viewjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewjButtonActionPerformed(evt);
            }
        });

        removejButton.setText("Remove Person");
        removejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removejButtonActionPerformed(evt);
            }
        });

        refreshjButton.setText("Refresh");
        refreshjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refreshjButton))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(viewjButton)
                        .addGap(98, 98, 98)
                        .addComponent(removejButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                        .addComponent(createEmployeejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(refreshjButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createEmployeejButton)
                    .addComponent(viewjButton)
                    .addComponent(removejButton))
                .addContainerGap(56, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void removejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removejButtonActionPerformed
        // TODO add your handling code here:
         int row = employeesTable.getSelectedRow();
        if(row<0) {
            JOptionPane.showMessageDialog(null, "Please select a Employee from table");
            return;
        }
        
        Person person = (Person)employeesTable.getValueAt(row, 0);
        Organization org = (Organization) employeesTable.getValueAt(row, 4);
        
        org.getPersonDirectory().removePerson(person);
        populateTable();
        
        
        
    }//GEN-LAST:event_removejButtonActionPerformed

    private void createEmployeejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createEmployeejButtonActionPerformed
        // TODO add your handling code here:
        System.out.println("CREATE PERSON CURRENT ENTERPRISE : " + enterprise.getName());
        CreatePersonJPanel panel = new CreatePersonJPanel(workContainer, enterprise);
        workContainer.add("CreateEmployeeJPanel", panel);
        CardLayout layout = (CardLayout)workContainer.getLayout();
        layout.next(workContainer);
    }//GEN-LAST:event_createEmployeejButtonActionPerformed

    private void viewjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewjButtonActionPerformed
        // TODO add your handling code here:
        int row = employeesTable.getSelectedRow();
        if(row<0) {
            JOptionPane.showMessageDialog(null, "Please select a Employee from table");
            return; 
        }
        Person person = (Person)employeesTable.getValueAt(row, 0);
        Organization org = (Organization) employeesTable.getValueAt(row, 4);
        
        
        
        ViewPersonJPanel panel = new ViewPersonJPanel(workContainer, person, org);
        workContainer.add("ViewPersonJPanel", panel);
        CardLayout layout = (CardLayout)workContainer.getLayout();
        layout.next(workContainer);
    }//GEN-LAST:event_viewjButtonActionPerformed

    private void refreshjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshjButtonActionPerformed
        // TODO add your handling code here:
        populateTable();
    }//GEN-LAST:event_refreshjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createEmployeejButton;
    private javax.swing.JTable employeesTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshjButton;
    private javax.swing.JButton removejButton;
    private javax.swing.JButton viewjButton;
    // End of variables declaration//GEN-END:variables
}
