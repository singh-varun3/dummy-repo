/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Organization.Organization.OrganizationType;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }
    
    public Organization createOrganization(OrganizationType type){
        Organization organization = null;
        if (type.getValue().equals(OrganizationType.EnterpriseAdminOrg.getValue())){
            organization = new EnterpriseAdminOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(OrganizationType.CDCOrg.getValue())){
            organization = new CDCOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(OrganizationType.DistributorOrg.getValue())){
            organization = new DistributorOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(OrganizationType.HospitalOrg.getValue())){
            organization = new HospitalOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(OrganizationType.ManufactureOrg.getValue())){
            organization = new ManufactureOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(OrganizationType.PatientOrganization.getValue())){
            organization = new PatientOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(OrganizationType.PublicHealthDepartmentOrg.getValue())){
            organization = new PHDImmunizationOrganization();
            organizationList.add(organization);
        }
        else if (type.getValue().equals(OrganizationType.SatelliteClinicOrganization.getValue())){
            organization = new SatelliteClinicOrganization();
            organizationList.add(organization);
        }
        
        
        return organization;
    }
}