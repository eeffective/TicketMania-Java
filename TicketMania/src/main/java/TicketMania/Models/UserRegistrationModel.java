package TicketMania.Models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserRegistrationModel {
    @NotEmpty(message = "First name can't be empty.")
    private String firstName;
    @NotEmpty(message = "Last name can't be empty.")
    private String lastName;
    @NotEmpty(message = "Email can't be empty.")
    @Email(message = "Invalid email.")
    private String email;
    @NotEmpty(message = "Password can't be empty.")
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
