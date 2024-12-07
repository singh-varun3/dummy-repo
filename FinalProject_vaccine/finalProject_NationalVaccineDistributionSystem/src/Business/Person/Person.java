/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Person;

import java.util.Date;

/**
 *
 * @author raunak
 */
public abstract class Person {
    
    private String firstName;
    private String lastName;
    private String email;
    private long phone;
    private Date dateOfBirth;

    

   

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

   

    @Override
    public String toString() {
        return firstName+ " "+lastName;
    }
    
    
}
