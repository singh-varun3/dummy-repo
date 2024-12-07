/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Vaccine;

import Business.Person.Patient;
import Business.UserAccount.UserAccount;
import java.util.Date;

/**
 *
 * @author Vaibhav
 */
public class AdministeredVaccine {
    
    private VaccineProduct vaccineProduct;
    private int doseNumber;
    private String siteRoute;
    private String injectionStatus;
    private UserAccount provider; 
    private Date date;
    private Patient patient;
    private String reasonForFailure;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getReasonForFailure() {
        return reasonForFailure;
    }

    public void setReasonForFailure(String reasonForFailure) {
        this.reasonForFailure = reasonForFailure;
    }


    
    

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    
    
    public VaccineProduct getVaccineProduct() {
        return vaccineProduct;
    }

    public void setVaccineProduct(VaccineProduct vaccineProduct) {
        this.vaccineProduct = vaccineProduct;
    }

    public int getDoseNumber() {
        return doseNumber;
    }

    public void setDoseNumber(int doseNumber) {
        this.doseNumber = doseNumber;
    }

    public String getSiteRoute() {
        return siteRoute;
    }

    public void setSiteRoute(String siteRoute) {
        this.siteRoute = siteRoute;
    }

    public String getInjectionStatus() {
        return injectionStatus;
    }

    public void setInjectionStatus(String injectionStatus) {
        this.injectionStatus = injectionStatus;
    }

    public UserAccount getProvider() {
        return provider;
    }

    public void setProvider(UserAccount provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return vaccineProduct.getVaccineDefinition().getVaccineName();
    }
    
    
    
    
}
