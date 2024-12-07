/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Person;

import Business.FinancialAccount.PatientFinancialAccount;
import Business.Vaccine.AdministeredVaccine;
import java.util.ArrayList;

/**
 *
 * @author Vaibhav
 */
public class Patient extends Person {
    
     private int id;
    private static int count = 1;
    private PatientFinancialAccount patientFinancialAccount;
    private ArrayList<AdministeredVaccine> administeredVaccineList ;
    

    public Patient() {
        id = count;
        count++;
        patientFinancialAccount = new PatientFinancialAccount();
        administeredVaccineList = new ArrayList<>();
    }

    public ArrayList<AdministeredVaccine> getAdministeredVaccineList() {
        return administeredVaccineList;
    }
    
    public AdministeredVaccine addNewAdministeredVaccine(){
        AdministeredVaccine vaccine = new AdministeredVaccine();
        administeredVaccineList.add(vaccine);
        return vaccine;
        
    }
    
    public int getId() {
        return id;
    }

    public PatientFinancialAccount getPatientFinancialAccount() {
        return patientFinancialAccount;
    }

    public void setPatientFinancialAccount(PatientFinancialAccount patientFinancialAccount) {
        this.patientFinancialAccount = patientFinancialAccount;
    }
    
    
    
        @Override
    public String toString(){
        return this.getFirstName()+ " " + this.getLastName();
    }
    
    
    
    
}
