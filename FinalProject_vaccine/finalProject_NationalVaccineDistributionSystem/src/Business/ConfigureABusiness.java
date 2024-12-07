/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Enterprise.Enterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.NationalEnterprise.CDC;
import Business.NationalEnterprise.Manufacturer;
import Business.Network.CityNetwork;
import Business.Network.StateNetwork;
import Business.Organization.EnterpriseAdminOrganization;
import Business.Organization.HospitalOrganization;
import Business.Organization.Organization;
import Business.Organization.Organization.OrganizationType;
import static Business.Organization.Organization.OrganizationType.SatelliteClinicOrganization;
import Business.Organization.PatientOrganization;
import Business.Organization.SatelliteClinicOrganization;
import Business.Person.CDCEmployee;
import Business.Person.Distributor;
import Business.Person.EnterpriseAdminPerson;
import Business.Person.ManufacturerEmployee;
import Business.Person.Patient;
import Business.Person.Person;
import Business.Person.Provider;
import Business.Person.PublicHealthDepartmentEmployee;
import Business.Person.SatelliteClinicProvider;
import Business.Role.CDCEmployeeRole;
import Business.Role.DistributorRole;
import Business.Role.EnterpriseAdminRole;
import Business.Role.ManufacturerRole;
import Business.Role.PatientRole;
import Business.Role.ProviderRole;
import Business.Role.PublicHealthDepartmentRole;
import Business.Role.Role.RoleType;
import Business.Role.SatelliteClinicProviderRole;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author raunak
 */
public class ConfigureABusiness {
    
    public static Business configure(){
        
        Business business = Business.getInstance();
        
        //create a CDC Admin person
        EnterpriseAdminPerson cdcAdmin= (EnterpriseAdminPerson) business.getCdc().getPersonDirectory().createPerson("CDCAdmin", null,RoleType.EnterpriseAdmin);
        
        //create creds for CDC Admin
        business.getCdc().getUserAccountDirectory().createUserAccount("cdc", "cdc", cdcAdmin, new EnterpriseAdminRole());
        
        //create CDC Employee
        CDCEmployee cdcEmployee = (CDCEmployee)business.getDistributor().getPersonDirectory().createPerson("CDCEmployee_first", "CDCEmployee_last", RoleType.CDCEmployee);
        
        //create creds for CDC employee
        business.getCdc().getUserAccountDirectory().createUserAccount("cdcemp", "cdcemp", cdcEmployee, new CDCEmployeeRole());
        
        //create a Distributor Admin person
        EnterpriseAdminPerson distributorAdmin= (EnterpriseAdminPerson) business.getDistributor().getPersonDirectory().createPerson("DistributorAdmin", null,RoleType.EnterpriseAdmin);
        
        //create creds for Distributor
        business.getDistributor().getUserAccountDirectory().createUserAccount("distributor", "distributor", distributorAdmin, new EnterpriseAdminRole());
        
        //create Distributor Employee
        Distributor distributorEmp = (Distributor)business.getDistributor().getPersonDirectory().createPerson("dist_first", "dist_last", RoleType.Distributor);
        
        //create creds for distributor employee
        business.getDistributor().getUserAccountDirectory().createUserAccount("distemp", "distemp", distributorEmp, new DistributorRole());
        
        //create a manufacturer
        Manufacturer manufacturer = business.getManufacturerDirectory().addNewManufacturer("Novartis");
        //create Manufacture Admin
        EnterpriseAdminPerson manufacturerAdmin = (EnterpriseAdminPerson)manufacturer.getPersonDirectory().createPerson("ManufacturerAdmin", null, RoleType.EnterpriseAdmin);
        
        //create manufacture admin creds
        manufacturer.getUserAccountDirectory().createUserAccount("manuadmin", "manuadmin", manufacturerAdmin, new EnterpriseAdminRole());
        
        //create manufacturer employee 
        ManufacturerEmployee manufactureEmp = (ManufacturerEmployee)manufacturer.getPersonDirectory().createPerson("manuemp", null, RoleType.Manufacturer);
        
        //create manufacturer emp creds
        manufacturer.getUserAccountDirectory().createUserAccount("manuemp", "manuemp", manufactureEmp, new ManufacturerRole());
        
                
                
        
        
        
        //create the State
        StateNetwork state = business.addNewState("MA");
        state.setStatePopulation(100000);
        state.setVaccinesLeftForState(state.getStatePopulation());
        state.getPublicHealthDepartment().setName(state.getStateName());
        //create a PHD admin
        EnterpriseAdminPerson phdAdmin = (EnterpriseAdminPerson)state.getPublicHealthDepartment().getPersonDirectory().createPerson("PHD Admin", null, RoleType.EnterpriseAdmin);
        
        //create PHD admin creds
        state.getPublicHealthDepartment().getUserAccountDirectory().createUserAccount("phdadmin", "phdadmin", phdAdmin, new EnterpriseAdminRole());
        
        //create a PHD employee
        PublicHealthDepartmentEmployee phdEmp = (PublicHealthDepartmentEmployee)state.getPublicHealthDepartment().getPersonDirectory().createPerson("phdEmp", null, RoleType.PublicHealthDepartment);
        
        //create creds for PHD employee
        state.getPublicHealthDepartment().getUserAccountDirectory().createUserAccount("phdemp", "phdemp", phdEmp, new PublicHealthDepartmentRole());
        
        //create the City
        CityNetwork city = state.addNewCity("Boston");
        
        //create the hospital in that network /enterprise dir
        
        HospitalEnterprise hospital = (HospitalEnterprise)city.getEnterpriseDirectory().addEnterprise("Massachusetts General Hospital", Enterprise.EnterpriseType.Hospital);
                     
        //create admin organization
        EnterpriseAdminOrganization adminOrg = (EnterpriseAdminOrganization)hospital.getOrganizationDirectory().createOrganization(OrganizationType.EnterpriseAdminOrg);
        
        //create providerAdmin
        EnterpriseAdminPerson hospitalAdmin = (EnterpriseAdminPerson)adminOrg.getPersonDirectory().createPerson("HospitalAdmin", null, RoleType.EnterpriseAdmin);
        
        //create providerAdmin creds
        adminOrg.getUserAccountDirectory().createUserAccount("hospadmin", "hospadmin", hospitalAdmin, new EnterpriseAdminRole());
        
        //create provider organization
        HospitalOrganization hospitalOrg = (HospitalOrganization) hospital.getOrganizationDirectory().createOrganization(OrganizationType.HospitalOrg);
        
        //create provider
        Provider provider = (Provider)hospitalOrg.getPersonDirectory().createPerson("doctor", null, RoleType.Provider);
        
        //create creds for Provider
        hospitalOrg.getUserAccountDirectory().createUserAccount("provider", "provider", provider, new ProviderRole());
        
        //create Patient organization
        PatientOrganization patientOrg = (PatientOrganization) hospital.getOrganizationDirectory().createOrganization(OrganizationType.PatientOrganization);
        
        //create patient
        Patient patient = (Patient) patientOrg.getPersonDirectory().createPerson("patient 1", null, RoleType.Patient);
        
        //create patient creds
        patientOrg.getUserAccountDirectory().createUserAccount("patient", "patient", patient, new PatientRole());
        
        //create Satellite Clinic organization
        SatelliteClinicOrganization satelliteOrg = (SatelliteClinicOrganization)hospital.getOrganizationDirectory().createOrganization(OrganizationType.SatelliteClinicOrganization);
        
        //create a satellite clinic provider
        SatelliteClinicProvider satProvider = (SatelliteClinicProvider)satelliteOrg.getPersonDirectory().createPerson("satelliteOrg", null, RoleType.SatelliteClinicProvider);
        
        //create the creds for satProvider
        satelliteOrg.getUserAccountDirectory().createUserAccount("satprovider", "satprovider", satProvider, new SatelliteClinicProviderRole());
        
        
        //create the organization
        //Organization organization = enterprise.getOrganizationDirectory().createOrganization(Organization.OrganizationType.EnterpriseAdminOrg);
        
        //create the Person 
        EnterpriseAdminPerson person = (EnterpriseAdminPerson)business.getPersonDirectory().createPerson("Vaibhav", "Mistry", RoleType.EnterpriseAdmin);
        
        //create the user account
        //create the system admin
        UserAccount sysAdmin = business.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", person, new SystemAdminRole());
        
       //create the enterprise Admin
       // UserAccount enterpriseAdmin = enterprise.getUserAccountDirectory().createUserAccount("admin", "admin", person, new EnterpriseAdminRole());
        
        //create doctor user account
      //  UserAccount docAdmin = organization.getUserAccountDirectory().createUserAccount("doc", "doc", employee, new DoctorRole());
        
        
        
        return business;
    }
    
}
