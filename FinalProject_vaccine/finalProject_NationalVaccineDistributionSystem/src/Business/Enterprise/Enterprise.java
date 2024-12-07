/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Enterprise;

import Business.FinancialAccount.FinancialAccount;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;

/**
 *
 * @author Vaibhav
 */
public abstract class  Enterprise extends Organization{
    
    private String enterpriseName;
    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;
    private FinancialAccount financialAccount;
    
    
    public Enterprise (String name, EnterpriseType type){
        super(name);
        this.organizationDirectory = new OrganizationDirectory();
        this.enterpriseType = type;
        this.financialAccount = new FinancialAccount();
        
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public FinancialAccount getFinancialAccount() {
        return financialAccount;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }
    
    
    
    public enum EnterpriseType
    {
        Hospital ("Hospital"),
        CDC("CDC"),
        Manufacturer("Manufacturer"),
        Distributor("Distributor"),
        PublicHealthDepartment("Public Health Department");
        private String value;
        
        private EnterpriseType(String value){
            this.value = value;
        }
        
        public String getValue(){
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
        
        
        
    }
    
    
}
