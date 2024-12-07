/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.FinancialAccount;

import Business.Person.Patient;
import java.util.ArrayList;

/**
 *
 * @author Vaibhav
 */
public class Insurance {
    
    private String name;
    private FinancialAccount financialAccount;
    private ArrayList<PatientCovered> patientList;
    

    public Insurance() {
        patientList = new ArrayList<>();
        financialAccount = new FinancialAccount();
        financialAccount.setTotalBalance(0.0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FinancialAccount getFinancialAccount() {
        return financialAccount;
    }

    public void setFinancialAccount(FinancialAccount financialAccount) {
        this.financialAccount = financialAccount;
    }

    public ArrayList<PatientCovered> getPatientList() {
        return patientList;
    }

    public void setPatientList(ArrayList<PatientCovered> patientList) {
        this.patientList = patientList;
    }

    

    
    
    public PatientCovered addPatient(Patient patient, double coveredAmount){
        PatientCovered pc = new PatientCovered();
        pc.setCoveredAmount(coveredAmount);
        pc.setPatient(patient);
        
        patientList.add(pc);
        return pc;
        
    }
    
    public void removePatient(Patient patient){
        
        for(PatientCovered pc: patientList)
        {
            if(pc.getPatient().equals(patient))
            {
                patientList.remove(pc);
            }
        }
        
        
    }

    @Override
    public String toString() {
        return name;
    }
    
    
    
}
