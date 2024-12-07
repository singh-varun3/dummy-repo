/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Role;

import Business.Business;
import Business.Enterprise.Enterprise;
import Business.NationalEnterprise.CDC;
import Business.Network.StateNetwork;
import Business.Organization.CDCOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.CDC.CDCEmployeeWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Vaibhav
 */
public class CDCEmployeeRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, Organization organization, Business business, StateNetwork state) {
        return new CDCEmployeeWorkAreaJPanel(userProcessContainer, account, (CDC)enterprise, (CDCOrganization)organization, business);
    }
    
}
