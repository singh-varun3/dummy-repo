/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Disease;

import java.util.Date;

/**
 *
 * @author Vaibhav
 */
public class Disease {
    
    private String diseaseICD10Code;
    private String diseaseName;
    private Date lastUpdated;

    public String getDiseaseICD10Code() {
        return diseaseICD10Code;
    }

    public void setDiseaseICD10Code(String diseaseICD10Code) {
        this.diseaseICD10Code = diseaseICD10Code;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public String toString() {
        return diseaseICD10Code;
    }
    
    
    
}
