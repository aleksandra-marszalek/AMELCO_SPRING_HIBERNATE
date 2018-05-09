package pl.coderslab.dto;

import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class PersonDto {

    private String login;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String gender;
    private String country;
    private String notes;
    private boolean mailingList;
    private List<String> programmingSkills;
    private List<String> hobbies;

    @Override
    public String toString() {
        return "login: "+getLogin() + ", password: " + getPassword() + ", email: " + getEmail() + ", " +
                "\nfirst name: " + getFirstName() + ", last name: " + getLastName() + ", gender: " + getGender() +
                ", country: " + getCountry() + ",\n notes: " + getNotes() + ", mailing list: "+ isMailingList() + "," +
                " programming skills: " + getProgrammingSkills().toString() + ", hobbies: " + getHobbies().toString();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isMailingList() {
        return mailingList;
    }

    public void setMailingList(boolean mailingList) {
        this.mailingList = mailingList;
    }

    public List<String> getProgrammingSkills() {
        return programmingSkills;
    }

    public void setProgrammingSkills(List<String> programmingSkills) {
        this.programmingSkills = programmingSkills;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }
}
