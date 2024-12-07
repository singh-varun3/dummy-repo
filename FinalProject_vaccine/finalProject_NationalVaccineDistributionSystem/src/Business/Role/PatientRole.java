/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Role;

import Business.Business;
import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Network.StateNetwork;
import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;
import static Business.Organization.Organization.OrganizationType.PatientOrganization;
import Business.Organization.PatientOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.Patient.PatientWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Vaibhav
 */
public class PatientRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, Organization organization, Business business, StateNetwork state) {
        return new PatientWorkAreaJPanel(userProcessContainer, account, (HospitalEnterprise)enterprise, (PatientOrganization)organization, business);
    }
    
}
