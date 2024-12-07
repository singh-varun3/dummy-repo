/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Network;

import Business.Enterprise.PublicHealthDepartment;
import java.util.ArrayList;

/**
 *
 * @author Vaibhav
 */
public class StateNetwork {
    
    private ArrayList<CityNetwork> cityList;
    private PublicHealthDepartment publicHealthDepartment;
    private String stateName;
    private int statePopulation;
    private int vaccinesLeftForState;
    
    public StateNetwork() {
        
        this.cityList = new ArrayList<>();
        publicHealthDepartment = new PublicHealthDepartment(stateName);
        statePopulation = 0;
        vaccinesLeftForState = statePopulation;
    }

    public int getStatePopulation() {
        return statePopulation;
    }

    public void setStatePopulation(int statePopulation) {
        this.statePopulation = statePopulation;
    }

    public int getVaccinesLeftForState() {
        return vaccinesLeftForState;
    }

    public void setVaccinesLeftForState(int vaccinesLeftForState) {
        this.vaccinesLeftForState = vaccinesLeftForState;
    }
    
    
    
    
    public ArrayList<CityNetwork> getCityList() {
        return cityList;
    }

    public void setCityList(ArrayList<CityNetwork> cityList) {
        this.cityList = cityList;
    }

    public PublicHealthDepartment getPublicHealthDepartment() {
        return publicHealthDepartment;
    }

    public void setPublicHealthDepartment(PublicHealthDepartment publicHealthDepartment) {
        this.publicHealthDepartment = publicHealthDepartment;
    }
    
           
    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    
    public CityNetwork addNewCity(String name){
        
        CityNetwork newCity = new CityNetwork();
        newCity.setName(name);
        cityList.add(newCity);
        return newCity;
        
    }
    
    public void removeCity(CityNetwork city){
        
        cityList.remove(city);
    }
    
    public int getTotalVaccinesAdministeredInState(){
        int total = 0;
        if(cityList != null)
        {
            for(CityNetwork city: cityList)
            {
                total= total+city.getTotalVaccinesAdministeredInCity();
            }
        }
        return total;
        
        
        
    }
    
     public int getTotalFailedVaccinesInState(){
        int total = 0;
        if(cityList != null)
        {
            for(CityNetwork city: cityList)
            {
                total= total+city.getTotalFailedVaccinesInCity();
            }
        }
        return total;
        
        
        
    }
     
      public int getTotalVaccinesDistributedInState(){
        int total = 0;
        if(cityList != null)
        {
            for(CityNetwork city: cityList)
            {
                total= total+city.getTotalVaccinesDistributedInCity();
            }
        }
        return total;
        
        
        
    }
    
    

    @Override
    public String toString() {
        return stateName;
    }
    
    
    
    
}
