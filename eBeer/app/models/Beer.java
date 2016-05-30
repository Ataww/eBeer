package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * Created by couretn on 19/05/16.
 */
@Entity
public class Beer extends Resource {

    @Column
    private String name;

    // beer's id retrieved from the BreweryDB API.
    @Column
    private String beerId;

    public String getBeerId() {
        return beerId;
    }

    public void setBeerId(String beerId) {
        this.beerId = beerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }


}
