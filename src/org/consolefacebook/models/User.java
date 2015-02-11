package org.consolefacebook.models;

/**
 * Created by bakhtiar.galib on 2/8/15.
 */
public class User {

    //user login info
   private int userId;
   private String username;
   private String email;
   private String password;
   private boolean active;

   //user details
   private String firstName;
   private String lastName;
   private String DOB;

    public User(){}

    public User(int userId, String username, String email, String password, boolean active, String firstName, String lastName, String DOB) {

        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.active = active;
        this.firstName = firstName;
        this.lastName = lastName;
        this.DOB = DOB;
    }

    public static User build(int userId, String username, String email, String password, boolean active, String firstName, String lastName, String DOB) {

        return new User(userId,username,email,password,active,firstName,lastName,DOB);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String toString(){
        String userString = "ID :"+userId+"\n"+"USERNAME :"+username+"\n"+"FIRSTNAME :"+firstName+"\n"+
                "LASTNAME :"+lastName+"\n"+"EMAIL :"+email+"\n"+"PASSWORD :"+password+"\n"+
                "DOB :"+DOB+"\n"+"STATUS :"+active+"\n";
        return userString;
    }
}
