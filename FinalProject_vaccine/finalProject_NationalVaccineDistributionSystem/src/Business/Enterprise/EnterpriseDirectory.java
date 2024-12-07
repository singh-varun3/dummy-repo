/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Enterprise;

import Business.NationalEnterprise.CDC;
import Business.NationalEnterprise.Distributor;
import Business.NationalEnterprise.Manufacturer;
import java.util.ArrayList;

/**
 *
 * @author Vaibhav
 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory() {
        enterpriseList = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    //add enterprise 
    public Enterprise addEnterprise(String name, Enterprise.EnterpriseType type){
        
        Enterprise enterprise = null;
        
        //based on the enterprise type, creae the enterprise
        
        if(type == Enterprise.EnterpriseType.Hospital){
            
            enterprise = new HospitalEnterprise(name);
            enterpriseList.add(enterprise);
        }
        else if(type == Enterprise.EnterpriseType.CDC){
            
            enterprise = new CDC(name);
            enterpriseList.add(enterprise);
        }
        else if(type == Enterprise.EnterpriseType.Distributor){
            
            enterprise = new Distributor(name);
            enterpriseList.add(enterprise);
        }
        else if(type == Enterprise.EnterpriseType.Manufacturer){
            
            enterprise = new Manufacturer(name);
            enterpriseList.add(enterprise);
        }
        else if(type == Enterprise.EnterpriseType.PublicHealthDepartment){
            
            enterprise = new PublicHealthDepartment(name);
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }
    
    public void removeEnterprise(Enterprise enterprise){
        
        enterpriseList.remove(enterprise);
    }
    
}
