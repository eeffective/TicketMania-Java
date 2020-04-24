package TicketMania.Models;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserLoginModel {

    @NotEmpty(message = "Email can't be empty.")
    @Email(message = "Invalid email.")
    private String email;
    @NotEmpty(message = "Password can't be empty.")
    private String password;

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
