/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class PersonDirectory {
    
    private ArrayList<Person> personList;

    public PersonDirectory() {
        personList = new ArrayList<>();
    }

    public ArrayList<Person> getPeopleList() {
        return personList;
    }
    
    public Person createPerson(String firstName, String lastName, Role.RoleType type){
        
        Person person = null;
        
        //based on the role, create the person
        
        if(type == Role.RoleType.EnterpriseAdmin){
            
            person = new EnterpriseAdminPerson();
            personList.add(person);
        }
        else if (type == Role.RoleType.CDCEmployee){
           person = new CDCEmployee();
            personList.add(person); 
        }
        else if (type == Role.RoleType.Distributor){
           person = new Distributor();
            personList.add(person); 
        }
        else if (type == Role.RoleType.Manufacturer){
           person = new ManufacturerEmployee();
            personList.add(person); 
        }
        else if (type == Role.RoleType.Patient){
           person = new Patient();
            personList.add(person); 
        }
        else if (type == Role.RoleType.Provider){
           person = new Provider();
            personList.add(person); 
        }
         else if (type == Role.RoleType.PublicHealthDepartment){
           person = new PublicHealthDepartmentEmployee();
            personList.add(person); 
        }
         else if (type == Role.RoleType.SatelliteClinicProvider){
           person = new SatelliteClinicProvider();
            personList.add(person); 
        }
        
        person.setFirstName(firstName);
        person.setLastName(lastName);
             
        
        return person;
    }
    
    public void removePerson(Person person){
        
        personList.remove(person);
    }
    
    
    
}