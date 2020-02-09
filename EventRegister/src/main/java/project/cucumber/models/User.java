package project.cucumber.models;
import java.util.*;

public class User {

    public User() {
    }

    private String username;

    private String password;

    private String email;

    private String role;

    public Set<Event> event;

    public String getUserName() {
       return this.username;
    }

    public void setUserName(String value) {
      this.username = value;
    }

    public String getPassword() {
       return this.password;
    }

    public void setPassword(String value) {
       this.password = value;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String value) {
        this.email = value;
    }

    public String getRole() {
       return this.role;
    }

    public void setRole(String value) {
       this.role = value;
    }

}