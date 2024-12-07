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
import Business.Organization.Organization;
import Business.Organization.SatelliteClinicOrganization;
import Business.UserAccount.UserAccount;
import UserInterface.SatelliteClinic.SatelliteClinicWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author Vaibhav
 */
public class SatelliteClinicProviderRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, Organization organization, Business business,StateNetwork state) {
        return new SatelliteClinicWorkAreaJPanel(userProcessContainer, account, (HospitalEnterprise)enterprise, (SatelliteClinicOrganization)organization, business, state);
    }
    
}
