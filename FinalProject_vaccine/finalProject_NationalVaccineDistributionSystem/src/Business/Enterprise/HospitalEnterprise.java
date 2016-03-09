/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Enterprise;

import Business.Order.OrderCatalog;
import Business.Role.Role;
import Business.Vaccine.ProviderVaccineInventory;
import java.util.ArrayList;

/**
 *
 * @author Vaibhav
 */
public class HospitalEnterprise extends Enterprise {
    
    private OrderCatalog orderCatalog;
    
    //since the Enterprise is abstact we need constructor to initialize the object
    public HospitalEnterprise(String name) {
        
        super(name, EnterpriseType.Hospital);
        this.orderCatalog = new OrderCatalog();
    }

    public OrderCatalog getOrderCatalog() {
        return orderCatalog;
    }
    
    
    

    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
}
