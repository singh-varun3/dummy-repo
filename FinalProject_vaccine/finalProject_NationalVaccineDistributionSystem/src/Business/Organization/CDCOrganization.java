/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Organization;

import Business.Order.OrderCatalog;
import Business.Role.CDCEmployeeRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Vaibhav
 */
public class CDCOrganization extends Organization{
    
    private OrderCatalog distributorOrders;
    public CDCOrganization() {
        super(OrganizationType.CDCOrg.getValue());
        distributorOrders = new OrderCatalog();
    }

    public OrderCatalog getDistributorOrders() {
        return distributorOrders;
    }

    public void setDistributorOrders(OrderCatalog distributorOrders) {
        this.distributorOrders = distributorOrders;
    }
    
    
    
        
    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roles = new ArrayList<>();
        roles.add(new CDCEmployeeRole());
        return roles;
    }
    
}
