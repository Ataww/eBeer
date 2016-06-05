package models;

import play.db.jpa.GenericModel;

import javax.persistence.*;

/**
 * <p>
 * Root class for entities. Contains a generic db id and set the JPA inheritance strategy up.
 * </p>
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
