/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.FinancialAccount;

import Business.Person.Patient;
import static Business.Role.Role.RoleType.Patient;

/**
 *
 * @author Vaibhav
 */
public class PatientCovered {
    
    private Patient patient;
    private double coveredAmount;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public double getCoveredAmount() {
        return coveredAmount;
    }

    public void setCoveredAmount(double coveredAmount) {
        this.coveredAmount = coveredAmount;
    }
    
    
    
    
    
    
    
}
