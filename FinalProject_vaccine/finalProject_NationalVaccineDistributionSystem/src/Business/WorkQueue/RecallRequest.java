/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import Business.Vaccine.AdministeredVaccine;
import java.util.Date;

/**
 *
 * @author Vaibhav
 */
public class RecallRequest extends WorkRequest{
    
    private AdministeredVaccine adVaccine;
    private UserAccount distributorUserAccount;
    private Date distributorRemoveDate;
    private String distributorStatus;
    

    public RecallRequest() {
        
        adVaccine = new AdministeredVaccine();
    }

    public String getDistributorStatus() {
        return distributorStatus;
    }

    public void setDistributorStatus(String distributorStatus) {
        this.distributorStatus = distributorStatus;
    }
    
    
    
    
    public AdministeredVaccine getAdVaccine() {
        return adVaccine;
    }

    public void setAdVaccine(AdministeredVaccine adVaccine) {
        this.adVaccine = adVaccine;
    }

    public UserAccount getDistributorUserAccount() {
        return distributorUserAccount;
    }

    public void setDistributorUserAccount(UserAccount distributorUserAccount) {
        this.distributorUserAccount = distributorUserAccount;
    }

    public Date getDistributorRemoveDate() {
        return distributorRemoveDate;
    }

    public void setDistributorRemoveDate(Date distributorRemoveDate) {
        this.distributorRemoveDate = distributorRemoveDate;
    }
    
    
    

    @Override
    public String toString() {
        return adVaccine.getVaccineProduct().getVaccineDefinition().getVaccineCode();
    }
    
    
    
}
