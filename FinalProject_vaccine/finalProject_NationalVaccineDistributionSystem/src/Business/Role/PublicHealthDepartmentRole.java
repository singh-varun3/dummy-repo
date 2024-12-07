/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Role;

import Business.Business;
import Business.Enterprise.Enterprise;
import Business.Enterprise.PublicHealthDepartment;
import Business.Network.StateNetwork;
import Business.Organization.Organization;
import Business.Organization.PHDImmunizationOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.PublicHealthDepartment.PublicHealthDepartmentEmployeeWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Vaibhav
 */
public class PublicHealthDepartmentRole extends Role {

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, Organization organization, Business business, StateNetwork state) {
        return new PublicHealthDepartmentEmployeeWorkAreaJPanel(userProcessContainer, account, (PublicHealthDepartment)enterprise, (PHDImmunizationOrganization)organization, business, state);
    }
    
}
