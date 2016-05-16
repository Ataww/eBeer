package models;

import javax.persistence.*;

/**
 * Created by Ataw on 11/05/2016.
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ApplicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ENTITY_ID")
    private long id;

    public ApplicationEntity() {
    }

    public long getId() {
        return id;
    }
}
