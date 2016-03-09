/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.NationalEnterprise;

import Business.Enterprise.Enterprise;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Vaibhav
 */
public class Manufacturer extends Enterprise {
    
    
    public Manufacturer(String name) {
        super(name , EnterpriseType.Manufacturer);
    }
    
    
    
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }

    
    
    
}
