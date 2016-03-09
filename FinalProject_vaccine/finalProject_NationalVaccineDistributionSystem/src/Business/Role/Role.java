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
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public abstract class Role {
    
    public enum RoleType{
        EnterpriseAdmin("Enterprise Admin"),
        CDCEmployee("CDC Employee"),
        Distributor("Distributor"),
        Provider("Provider"),
        Manufacturer("Manufacturer"),
        Patient("Patient"),
        PublicHealthDepartment("Public Health Department"),
        SatelliteClinicProvider("Satellite Clinc Provider");
        
        private String value;
        private RoleType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
    
    public abstract JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Enterprise enterprise, Organization organization, Business business, StateNetwork state);

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
    
}