/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Disease.DiseaseCatalog;
import Business.FinancialAccount.Insurance;
import Business.NationalEnterprise.CDC;
import Business.NationalEnterprise.Distributor;
import Business.NationalEnterprise.Manufacturer;
import Business.NationalEnterprise.ManufacturerDirectory;
import Business.Network.StateNetwork;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.Vaccine.VaccineCatalog;
import java.util.ArrayList;



/**
 *
 * @author Administrator
 */
public class Business extends Organization{
    
    private static Business business;
    
    private ArrayList<StateNetwork> stateList;
    private CDC cdc;
    //private Manufacturer manufacturer;
    private ManufacturerDirectory manufacturerDirectory;
    private Distributor distributor;
    private VaccineCatalog vaccineCatalog;
    private DiseaseCatalog diseaseCatalog;
    private ArrayList<Insurance> insuranceCompanyList;
  
    
    public static Business getInstance(){
        if (business == null){
            business = new Business();
        }
        return business;
        
    }

    private Business() {
        super(null); //as constructor of organization expects name
      
      this.stateList = new ArrayList<StateNetwork>();
      cdc = new CDC("CDC");
      manufacturerDirectory = new ManufacturerDirectory();
      //manufacturer = new Manufacturer("Manufacturer");
      distributor = new Distributor("National Vaccine Distributor");
      vaccineCatalog = new VaccineCatalog();
      diseaseCatalog = new DiseaseCatalog();
      insuranceCompanyList = new ArrayList<Insurance>();
    }

    public static Business getBusiness() {
        return business;
    }

    public VaccineCatalog getVaccineCatalog() {
        return vaccineCatalog;
    }

    public DiseaseCatalog getDiseaseCatalog() {
        return diseaseCatalog;
    }

    public ArrayList<Insurance> getInsuranceCompanyList() {
        return insuranceCompanyList;
    }

    public void setInsuranceCompanyList(ArrayList<Insurance> insuranceCompanyList) {
        this.insuranceCompanyList = insuranceCompanyList;
    }

    

    public ArrayList<StateNetwork> getStateList() {
        return stateList;
    }

    public CDC getCdc() {
        return cdc;
    }

    public ManufacturerDirectory getManufacturerDirectory() {
        return manufacturerDirectory;
    }

    public Distributor getDistributor() {
        return distributor;
    }
    /*
    public Manufacturer getManufacturer() {
        return manufacturer;
    }
    
    */
    public Insurance addNewInsuranceCompany(){
        Insurance company = new Insurance();
        insuranceCompanyList.add(company);
       return company;
        
        
    }
    
    public void removeInsuranceCompany(Insurance company){
        insuranceCompanyList.remove(company);
        
    }
    
    
    
    
    public StateNetwork addNewState(String name){
        
        StateNetwork state = new StateNetwork();
        state.setStateName(name);
        stateList.add(state);
        return state;
    }
    
    public void removeState(StateNetwork state){
        
        stateList.remove(state);
    }
    
    

    @Override
    public ArrayList<Role> getSupportedRole() {
       ArrayList<Role> roleList = new ArrayList<Role>();
       roleList.add(new SystemAdminRole());
       return roleList;
    }

   
}