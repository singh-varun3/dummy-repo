/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Network;

import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDirectory;
import Business.Enterprise.HospitalEnterprise;
import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;

/**
 *
 * @author Vaibhav
 */
public class CityNetwork {
    
    private EnterpriseDirectory enterpriseDirectory;
    private String cityName;

    public CityNetwork() {
        this.enterpriseDirectory = new EnterpriseDirectory();
        
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }

    public String getName() {
        return cityName;
    }

    public void setName(String name) {
        this.cityName = name;
    }

    @Override
    public String toString() {
        return cityName; 
    }
    
    public int getTotalVaccinesAdministeredInCity()
    {
        int total = 0;
        if(enterpriseDirectory != null)
        {
            for(Enterprise enterprise: enterpriseDirectory.getEnterpriseList())
            {
                if( enterprise instanceof HospitalEnterprise)
                {
                    HospitalEnterprise hospital = (HospitalEnterprise)enterprise;
                    for(Organization org : hospital.getOrganizationDirectory().getOrganizationList())
                    {
                        if(org instanceof HospitalOrganization)
                        {
                            HospitalOrganization hospOrg = (HospitalOrganization)org;
                            total = total + hospOrg.getClinic().getTotalVaccinesAdministered();
                        }
                    }
                }
            }
        }
        
    
    return total;
    
}
    
    public int getTotalFailedVaccinesInCity()
    {
        int total = 0;
        if(enterpriseDirectory != null)
        {
            for(Enterprise enterprise: enterpriseDirectory.getEnterpriseList())
            {
                if( enterprise instanceof HospitalEnterprise)
                {
                    HospitalEnterprise hospital = (HospitalEnterprise)enterprise;
                    for(Organization org : hospital.getOrganizationDirectory().getOrganizationList())
                    {
                        if(org instanceof HospitalOrganization)
                        {
                            HospitalOrganization hospOrg = (HospitalOrganization)org;
                            total = total + hospOrg.getClinic().getTotalFailedVaccines();
                        }
                    }
                }
            }
        }
        
    
    return total;
    
}
    
    public int getTotalVaccinesDistributedInCity()
    {
        int total = 0;
        if(enterpriseDirectory != null)
        {
            for(Enterprise enterprise: enterpriseDirectory.getEnterpriseList())
            {
                if( enterprise instanceof HospitalEnterprise)
                {
                    HospitalEnterprise hospital = (HospitalEnterprise)enterprise;
                    for(Organization org : hospital.getOrganizationDirectory().getOrganizationList())
                    {
                        if(org instanceof HospitalOrganization)
                        {
                            HospitalOrganization hospOrg = (HospitalOrganization)org;
                            total = total + hospOrg.getClinic().getTotalVaccinesStored();
                        }
                    }
                }
            }
        }
        
    
    return total;
    
}
    
    
}
