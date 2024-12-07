/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.Provider;

import Business.Business;
import Business.Enterprise.HospitalEnterprise;
import Business.FinancialAccount.Insurance;
import Business.Network.StateNetwork;
import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;
import Business.Person.Patient;
import static Business.Role.Role.RoleType.Patient;
import Business.UserAccount.UserAccount;
import Business.Vaccine.AdministeredVaccine;
import Business.Vaccine.VaccineProduct;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Vaibhav
 */
public class AdministerVaccineToPatientJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdministerVaccineToPatientJPanel
     */
    private JPanel workContainer;

    private HospitalEnterprise hospital;
    private UserAccount userAccount;
    private HospitalOrganization hospitalOrg;
    private Business business;
    private Patient patient;
    private StateNetwork state;
    
    public AdministerVaccineToPatientJPanel(JPanel workContainer, HospitalEnterprise hospital,HospitalOrganization hospitalOrg,UserAccount userAccount , Business business,Patient patient, StateNetwork state) {
        initComponents();
        this.workContainer = workContainer;
        this.userAccount = userAccount;
        this.hospital = hospital;
        this.business = business;
        this.hospitalOrg = hospitalOrg;
        this.patient = patient;
        this.state = state;
        givenByjTextField.setText(userAccount.getPerson().getFirstName()+" "+userAccount.getPerson().getLastName());
        patientNamejTextField.setText(patient.getFirstName() + " " + patient.getLastName());
        vaccineCodejComboBox.removeAllItems();
        brandjComboBox.removeAllItems();
        batchNumberjComboBox.removeAllItems();
        
        populateVaccineCodeComboBox();
        
    }
    
    private void populateVaccineCodeComboBox()
    {
       vaccineCodejComboBox.removeAllItems();
       
       ArrayList<String> vprodList = new ArrayList<String>();
       
       
       for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
       {
           if(org instanceof HospitalOrganization)
           {
               HospitalOrganization hospOrg = (HospitalOrganization)org;
               for(VaccineProduct product: hospOrg.getClinic().getVaccineInventoryClinic())
               {
                   if(vprodList.contains(product.getVaccineDefinition().getVaccineCode())== false)
                   {
                       vaccineCodejComboBox.addItem(product);
                       vprodList.add(product.getVaccineDefinition().getVaccineCode());
                   }
                   
               }
           }
       }
        
    }
    
    private void populateBrandComboBox(VaccineProduct vaccine)
    {
        brandjComboBox.removeAllItems();
         String vaccineCode = vaccine.getVaccineDefinition().getVaccineCode();
            ArrayList<String> brandList = new ArrayList<String>();
         for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
       {
           if(org instanceof HospitalOrganization)
           {
               HospitalOrganization hospOrg = (HospitalOrganization)org;
               for(VaccineProduct product: hospOrg.getClinic().getVaccineInventoryClinic())
               {
                   if(product.getVaccineDefinition().getVaccineCode().equalsIgnoreCase(vaccineCode) && brandList.contains(product.getManufacturerName())==false )
                   {
                       brandjComboBox.addItem(product.getManufacturerName());
                       brandList.add(product.getManufacturerName());
                   }
               }
           }
       }
        
        
        
        
        
    }
    
    
    private void populateBatchComboBox(String brandName){
        
        batchNumberjComboBox.removeAllItems();
        VaccineProduct vp = (VaccineProduct)vaccineCodejComboBox.getSelectedItem();
        String vaccineCode = vp.getVaccineDefinition().getVaccineCode();
        
        for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
       {
           if(org instanceof HospitalOrganization)
           {
               HospitalOrganization hospOrg = (HospitalOrganization)org;
               for(VaccineProduct product: hospOrg.getClinic().getVaccineInventoryClinic())
               {
                   if(product.getManufacturerName().equalsIgnoreCase(brandName) && product.getVaccineDefinition().getVaccineCode().equalsIgnoreCase(vaccineCode))
                   {
                       batchNumberjComboBox.addItem(product.getBatchId());
                   }
               }
           }
       }
        
        
    }
    
    private void populateTextFields()
    {
        VaccineProduct prod = (VaccineProduct)vaccineCodejComboBox.getSelectedItem();
        if(prod == null)
        {
            return;
        }
        String vaccineCode = prod.getVaccineDefinition().getVaccineCode();
        
        
        String brand = (String)brandjComboBox.getSelectedItem();
        
        String batchID = (String)batchNumberjComboBox.getSelectedItem();
        
        for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
       {
           if(org instanceof HospitalOrganization)
           {
               HospitalOrganization hospOrg = (HospitalOrganization)org;
               for(VaccineProduct product: hospOrg.getClinic().getVaccineInventoryClinic())
               {
                   if(product.getManufacturerName().equalsIgnoreCase(brand) && product.getBatchId().equalsIgnoreCase(batchID) && product.getVaccineDefinition().getVaccineCode().equalsIgnoreCase(vaccineCode))
                   {
                       manufactureDatejTextField.setText(String.valueOf(product.getManufactureDate()));
        expiryDatejTextField.setText(String.valueOf(product.getDateOfExpiry()));
        visDatejTextField.setText(String.valueOf(product.getVaccineDefinition().getDateOnVIS()));
                       return;
                   }
               }
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        patientNamejTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        datejDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        vaccineCodejComboBox = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        doseNumberjTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        manufactureDatejTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        expiryDatejTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        batchNumberjComboBox = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        visDatejTextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        leftArmjRadioButton = new javax.swing.JRadioButton();
        rightArmjRadioButton = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        successjRadioButton = new javax.swing.JRadioButton();
        failjRadioButton = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        givenByjTextField = new javax.swing.JTextField();
        administerVaccinejButton = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        brandjComboBox = new javax.swing.JComboBox();
        backJButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Administer Vaccine : Page 2");

        jLabel2.setText("Patient: ");

        patientNamejTextField.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Vaccine Details:");

        jLabel4.setText("Date:");

        jLabel5.setText("Vaccine Code:");

        vaccineCodejComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        vaccineCodejComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vaccineCodejComboBoxActionPerformed(evt);
            }
        });

        jLabel6.setText("Dose Number:");

        jLabel7.setText("Manufacture Date:");

        manufactureDatejTextField.setEnabled(false);

        jLabel8.setText("Expiry Date:");

        expiryDatejTextField.setEnabled(false);

        jLabel9.setText("Batch Number :");

        batchNumberjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        batchNumberjComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batchNumberjComboBoxActionPerformed(evt);
            }
        });

        jLabel10.setText("Date on VIS:");

        visDatejTextField.setEnabled(false);

        jLabel11.setText("Site/Route:");

        buttonGroup1.add(leftArmjRadioButton);
        leftArmjRadioButton.setText("Left Arm");

        buttonGroup1.add(rightArmjRadioButton);
        rightArmjRadioButton.setText("Right Arm");

        jLabel12.setText("Injection Status:");

        buttonGroup2.add(successjRadioButton);
        successjRadioButton.setText("Success");

        buttonGroup2.add(failjRadioButton);
        failjRadioButton.setText("Fail");

        jLabel13.setText("Given By:");

        givenByjTextField.setEnabled(false);

        administerVaccinejButton.setText("Administer Vaccine");
        administerVaccinejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                administerVaccinejButtonActionPerformed(evt);
            }
        });

        jLabel14.setText("Brand:");

        brandjComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        brandjComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brandjComboBoxActionPerformed(evt);
            }
        });

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
                    .addComponent(jSeparator3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel10)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(visDatejTextField))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(expiryDatejTextField))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel14)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(brandjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(failjRadioButton)
                                            .addComponent(successjRadioButton)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(datejDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(vaccineCodejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(batchNumberjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(doseNumberjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(givenByjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(leftArmjRadioButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rightArmjRadioButton))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(manufactureDatejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(141, 141, 141)
                                .addComponent(administerVaccinejButton, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(backJButton3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(patientNamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 120, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(patientNamejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(datejDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(vaccineCodejComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(batchNumberjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(brandjComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(doseNumberjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(expiryDatejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(manufactureDatejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(visDatejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(leftArmjRadioButton)
                    .addComponent(rightArmjRadioButton))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(successjRadioButton)
                    .addComponent(jLabel13)
                    .addComponent(givenByjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(failjRadioButton)
                .addGap(18, 18, 18)
                .addComponent(administerVaccinejButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(backJButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void vaccineCodejComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vaccineCodejComboBoxActionPerformed
        // TODO add your handling code here:
        brandjComboBox.removeAllItems();
        VaccineProduct prod = (VaccineProduct)vaccineCodejComboBox.getSelectedItem();
        if(prod == null)
        {
            return;
        }
        populateBrandComboBox(prod);
        
        
        
        
        
    }//GEN-LAST:event_vaccineCodejComboBoxActionPerformed

    private void administerVaccinejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_administerVaccinejButtonActionPerformed
        // TODO add your handling code here:
        
        //capture all info
        try
        {
            //get the vaccine product
            
             VaccineProduct vp = (VaccineProduct)vaccineCodejComboBox.getSelectedItem();
        String vaccineCode = vp.getVaccineDefinition().getVaccineCode();
        
        String brand = (String)brandjComboBox.getSelectedItem();
        
        String batchID = (String)batchNumberjComboBox.getSelectedItem();
        VaccineProduct prod = null;
        for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
       {
           if(org instanceof HospitalOrganization && prod== null)
           {
               HospitalOrganization hospOrg = (HospitalOrganization)org;
               for(VaccineProduct product: hospOrg.getClinic().getVaccineInventoryClinic())
               {
                   if(product.getManufacturerName().equalsIgnoreCase(brand) && product.getBatchId().equalsIgnoreCase(batchID) && product.getVaccineDefinition().getVaccineCode().equalsIgnoreCase(vaccineCode))
                   {
                      prod=product;
                      break;
                   }
               }
           }
       }
            
            
            
        Date administeredDate = datejDateChooser.getDate();
        
        
        //String vaccineCode = prod.getVaccineDefinition().getVaccineCode();
        //String batchID = (String)batchNumberjComboBox.getSelectedItem();
        String siteRoute = null;
        String status = null;
        if(leftArmjRadioButton.isSelected())
        {
            siteRoute = new String("Left");
        }
        else
        {
            siteRoute = new String("Right");
        }
        
        if(successjRadioButton.isSelected())
        {
            status = new String("Success");
            
        }
        else
        {
            status = new String ("Fail");
            
        }
        
        //create a new administered vaccine 
        AdministeredVaccine administeredVaccine = null;
        for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
        {
            if(org instanceof HospitalOrganization)
            {
                HospitalOrganization hospOrg = (HospitalOrganization)org;
                administeredVaccine = hospOrg.getClinic().addNewAdministeredVaccine();
            }
        }
        
        //get same vaccine Product
        for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
        {
            if(org instanceof HospitalOrganization)
            {
                HospitalOrganization hospOrg = (HospitalOrganization)org;
                for(VaccineProduct product : hospOrg.getClinic().getVaccineInventoryClinic())
                {
                    if(product.getVaccineDefinition().getVaccineCode().equalsIgnoreCase(vaccineCode) && product.getBatchId().equalsIgnoreCase(batchID))
                    {administeredVaccine.setVaccineProduct(product);
                    break;
                    }
                        
                }
            }
        }
        
        //decrease the vaccine quantity from vaccine inventory
       for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
        {
            if(org instanceof HospitalOrganization)
            {
                HospitalOrganization hospOrg = (HospitalOrganization)org;
                for(VaccineProduct p: hospOrg.getClinic().getVaccineInventoryClinic())
                {
                    
                    
                    if(p.equals(administeredVaccine.getVaccineProduct()))
                    {   
                        if(p.getAvailablity()<0)
                        {
                            JOptionPane.showMessageDialog(null, "Not enough quantity of vaccine!");
                        }
                        else
                        {p.setAvailablity(p.getAvailablity()-1);
                        }
                    }
                }
                        
                }
            }
        
        
        int dose = Integer.parseInt(doseNumberjTextField.getText());
        administeredVaccine.setDoseNumber(dose);
        administeredVaccine.setInjectionStatus(status);
        administeredVaccine.setProvider(userAccount);
        administeredVaccine.setSiteRoute(siteRoute);
        administeredVaccine.setDate(administeredDate);
        administeredVaccine.setPatient(patient);
        if(status.equalsIgnoreCase("Fail"))
        {
            administeredVaccine.setReasonForFailure("Injection failure");
        }
        
        
        
        
        
        //if vaccine not funded
        boolean isFunded = true;
       if(administeredVaccine.getVaccineProduct().getVaccineDefinition().isFederalFunded() == false &&administeredVaccine.getVaccineProduct().getVaccineDefinition().isVaccineFundedByMentionedState(state) == false) 
       {
           isFunded = false;
       }
        
        //check if the patient is insured and under covered amount. If Insured, dedcut from his insurance company
       if(isFunded == false)
       {
           if(patient.getPatientFinancialAccount().isIsInsured() && (patient.getPatientFinancialAccount().getCoveredAmount() > administeredVaccine.getVaccineProduct().getVaccinePrice()))
       {
           Insurance company = patient.getPatientFinancialAccount().getInsurance();
           for(Insurance insurance: business.getInsuranceCompanyList())
           {
               if(insurance.equals(company))
               {
                   insurance.getFinancialAccount().setTotalBalance(insurance.getFinancialAccount().getTotalBalance()-administeredVaccine.getVaccineProduct().getVaccinePrice());
                   hospital.getFinancialAccount().setTotalBalance(hospital.getFinancialAccount().getTotalBalance()+administeredVaccine.getVaccineProduct().getVaccinePrice());
               }
           }
       }
       else
       {
           patient.getPatientFinancialAccount().setTotalBalance(patient.getPatientFinancialAccount().getTotalBalance()-administeredVaccine.getVaccineProduct().getVaccinePrice());
           hospital.getFinancialAccount().setTotalBalance(hospital.getFinancialAccount().getTotalBalance()+administeredVaccine.getVaccineProduct().getVaccinePrice());
       }
       }
       
       
        //store the administered vaccine in clinc list
        for(Organization org: hospital.getOrganizationDirectory().getOrganizationList())
        {
            if(org instanceof HospitalOrganization)
            {
                HospitalOrganization hospOrg = (HospitalOrganization)org;
                AdministeredVaccine v = hospOrg.getClinic().addNewAdministeredVaccine();
                v = administeredVaccine;
            }
        }
       //add the vaccine to patient List
        AdministeredVaccine av = patient.addNewAdministeredVaccine();
        av=administeredVaccine;
       
       
        JOptionPane.showMessageDialog(null, "Vaccine Administered!");
        //if not insured deduct from his account
        
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, "Please enter numeric data in dose field");
            return;
        }
        


    }//GEN-LAST:event_administerVaccinejButtonActionPerformed

    private void brandjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brandjComboBoxActionPerformed
        // TODO add your handling code here:
        batchNumberjComboBox.removeAllItems();
        String brand = (String)brandjComboBox.getSelectedItem();
        if(brand == null)
        {
            return;
        }
        
        populateBatchComboBox(brand);
        
        
    }//GEN-LAST:event_brandjComboBoxActionPerformed

    private void batchNumberjComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batchNumberjComboBoxActionPerformed
        // TODO add your handling code here:
        populateTextFields();
    }//GEN-LAST:event_batchNumberjComboBoxActionPerformed

    private void backJButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton3ActionPerformed
        // TODO add your handling code here:
        workContainer.remove(this);
        CardLayout layout = (CardLayout) workContainer.getLayout();
        layout.previous(workContainer);
    }//GEN-LAST:event_backJButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton administerVaccinejButton;
    private javax.swing.JButton backJButton3;
    private javax.swing.JComboBox batchNumberjComboBox;
    private javax.swing.JComboBox brandjComboBox;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private com.toedter.calendar.JDateChooser datejDateChooser;
    private javax.swing.JTextField doseNumberjTextField;
    private javax.swing.JTextField expiryDatejTextField;
    private javax.swing.JRadioButton failjRadioButton;
    private javax.swing.JTextField givenByjTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JRadioButton leftArmjRadioButton;
    private javax.swing.JTextField manufactureDatejTextField;
    private javax.swing.JTextField patientNamejTextField;
    private javax.swing.JRadioButton rightArmjRadioButton;
    private javax.swing.JRadioButton successjRadioButton;
    private javax.swing.JComboBox vaccineCodejComboBox;
    private javax.swing.JTextField visDatejTextField;
    // End of variables declaration//GEN-END:variables
}
