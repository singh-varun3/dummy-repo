/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Organization;

import Business.Role.DistributorRole;
import Business.Role.Role;
import Business.Warehouse.WarehouseDirectory;
import java.util.ArrayList;

/**
 *
 * @author Vaibhav
 */
public class DistributorOrganization extends Organization{
    
    private WarehouseDirectory warehouseDirectory;
    
    public DistributorOrganization() {
        super(OrganizationType.DistributorOrg.getValue());
        warehouseDirectory = new WarehouseDirectory();
    }

    public WarehouseDirectory getWarehouseDir() {
        return warehouseDirectory;
    }
    

    
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new DistributorRole());
        return roles;
    }
    
}
