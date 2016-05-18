package models;

import play.data.validation.Required;

import javax.persistence.Column;
import javax.persistence.Entity;

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

}
