/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.FinancialAccount;

/**
 *
 * @author Vaibhav
 */
public class PatientFinancialAccount {
    private double totalBalance;
    private boolean isInsured;
    private Insurance insurance;
    private double coveredAmount;

    public PatientFinancialAccount() {
        totalBalance = 0.0;
        
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }
    
    
    
    public double getTotalBalance() {
        return totalBalance;
    }
    
    public void creditAccount(double amount){
        
      this.totalBalance = totalBalance + amount;
        
        
    }

    public boolean isIsInsured() {
        return isInsured;
    }

    public void setIsInsured(boolean isInsured) {
        this.isInsured = isInsured;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public double getCoveredAmount() {
        return coveredAmount;
    }

    public void setCoveredAmount(double coveredAmount) {
        this.coveredAmount = coveredAmount;
    }
    
    public void debitAccount(double amount){
        this.totalBalance = totalBalance - amount;
    }
}
