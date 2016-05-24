package models;

import play.db.jpa.GenericModel;

import javax.persistence.*;

/**
 * Created by couretn on 19/05/16.
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ApplicationEntity extends GenericModel {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
