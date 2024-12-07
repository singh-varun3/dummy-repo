/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Vaccine;

import Business.Disease.Disease;
import Business.Network.StateNetwork;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Vaibhav
 */
public class Vaccine {
    
    private String vaccineCode;
    private String vaccineName;
    private Date dateOnVIS;
    private Date lastUpdatedVIS;
    private boolean federalFunded;
    private boolean stateFunded;
    private StateNetwork state;
    private Disease disease;
    private ArrayList<StateNetwork> fundedStateList;
    

    public Vaccine() {
        federalFunded = false;
        stateFunded = false;
        this.fundedStateList = new ArrayList<>();
    }

    public StateNetwork getState() {
        return state;
    }

    public void setState(StateNetwork state) {
        this.state = state;
    }

    public ArrayList<StateNetwork> getFundedStateList() {
        return fundedStateList;
    }
    
    public StateNetwork addState(StateNetwork funState)
    {   
        if(fundedStateList != null)
        { fundedStateList.add(funState);
        return funState;
        }
        return null;
    }
   
    
    public StateNetwork addNewFundedState(){
        StateNetwork fstate = new StateNetwork();
        fundedStateList.add(fstate);
        return fstate;
        
    }
    
    public void removeFundedState(StateNetwork fstate){
        fundedStateList.remove(fstate);
    }
    
    public boolean isVaccineFundedByMentionedState(StateNetwork fstate){
        
        for(StateNetwork fundedstate: fundedStateList){
            if(fundedstate.equals(fstate))                    
            {
                return true;
                
            }
        }
        return false;
    }
    

    public Disease getDisease() {
        return disease;
    }

    public void setDisease(Disease disease) {
        this.disease = disease;
    }
    
    

    public String getVaccineCode() {
        return vaccineCode;
    }

    public void setVaccineCode(String vaccineCode) {
        this.vaccineCode = vaccineCode;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public Date getDateOnVIS() {
        return dateOnVIS;
    }

    public void setDateOnVIS(Date dateOnVIS) {
        this.dateOnVIS = dateOnVIS;
    }

    public Date getLastUpdatedVIS() {
        return lastUpdatedVIS;
    }

    public void setLastUpdatedVIS(Date lastUpdatedVIS) {
        this.lastUpdatedVIS = lastUpdatedVIS;
    }

    
    

    public boolean isFederalFunded() {
        return federalFunded;
    }

    public void setFederalFunded(boolean federalFunded) {
        this.federalFunded = federalFunded;
    }

    public boolean isStateFunded() {
        return stateFunded;
    }

    public void setStateFunded(boolean stateFunded) {
        this.stateFunded = stateFunded;
    }
    
    
    
    @Override
    public String toString() {
        return vaccineCode;
    }
    
    
    
    
}
