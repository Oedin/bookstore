package net.edinosmanovic.bookstore.models;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by eo on 6/7/17.
 */
public class User {

    @NotNull
    @Size(min=5, max=15)
    private String userId;

    @Email
    private String userEmail;

    @NotNull
    @Size(min=6)
    private String password;


    public User(String userId, String password, String userEmail) {
        this.userId = userId;
        this.password = password;
        this.userEmail = userEmail;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
