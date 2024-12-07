/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.Business;
import Business.Enterprise.Enterprise;
import Business.Network.StateNetwork;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.EnterpriseAdmin.EnterpriseAdminWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Vaibhav
 */
public class EnterpriseAdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account,Enterprise enterprise, Organization organization, Business business, StateNetwork state) {
        return new EnterpriseAdminWorkAreaJPanel(userProcessContainer, enterprise, account, business);
    }

    
    
}
