/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Organization;

import Business.Role.Role;
import Business.Role.SatelliteClinicProviderRole;
import java.util.ArrayList;

/**
 *
 * @author Vaibhav
 */
public class SatelliteClinicOrganization extends Organization{
    
    private String satelliteClincName;
    
    public SatelliteClinicOrganization() {
        super(OrganizationType.SatelliteClinicOrganization.getValue());
    }

    public String getSatelliteClincName() {
        return satelliteClincName;
    }

    public void setSatelliteClincName(String satelliteClincName) {
        this.satelliteClincName = satelliteClincName;
    }
    
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SatelliteClinicProviderRole());
        return roles;
    }
    
}
