package data.models;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String FirstName;
    private String LastName;
    private int id;
    private String phoneNumber;
    private String email;
    private final List<Email> inbox = new ArrayList<>();


    public void setToInbox(Email email){
        inbox.add(email);
    }

    public Email getEmailInInbox(int id){
       return inbox.get(id-1);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return this.FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getLastName() {
        return this.LastName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return this.id;
    }

}