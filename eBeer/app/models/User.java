package models;

import play.data.validation.Required;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Ataw on 18/05/2016.
 */
@Entity
public class User extends Actor {

    @Column
    @Required
    private String email;

    @Column
    @Required
    private String username;

    @Column
    @Required
    private String password;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private List<Sale> sales;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return email;
    }
}
