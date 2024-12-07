/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.FinancialAccount;

import Business.Role.EnterpriseAdminRole;
import Business.Role.Role;

/**
 *
 * @author Vaibhav
 */
public class FinancialAccount {
    
    private double totalBalance;

    
    
    public FinancialAccount() {
        totalBalance = 0.0;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }

    
    public double getTotalBalance() {
        return totalBalance;
    }
    
    
    
    
    
}
