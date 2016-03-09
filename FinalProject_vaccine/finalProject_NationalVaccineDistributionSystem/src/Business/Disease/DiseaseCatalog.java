/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Disease;

import java.util.ArrayList;

/**
 *
 * @author Vaibhav
 */
public class DiseaseCatalog {
    
    private ArrayList<Disease> diseaseCatalog;

    public DiseaseCatalog() {
        
        diseaseCatalog = new ArrayList<>();
    }

    public ArrayList<Disease> getDiseaseCatalog() {
        return diseaseCatalog;
    }

    public void setDiseaseCatalog(ArrayList<Disease> diseaseCatalog) {
        this.diseaseCatalog = diseaseCatalog;
    }
    
    
    public Disease addNewDiseaseDefinition(){
        
        Disease newDisease = new Disease();
        diseaseCatalog.add(newDisease);
        return newDisease;        
        
    }
    
    
    public void removeDiseaseDefinition(Disease disease){
        
        diseaseCatalog.remove(disease);
    }
    
    
}
