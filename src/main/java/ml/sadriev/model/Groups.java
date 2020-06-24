package ml.sadriev.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "table_groups")
public class Groups {

    @Id
    @GeneratedValue(generator = "system-uuid")
    private UUID id;

    @Column(length = 255, unique = true, updatable = true)
    private String groupName;

    @Column(updatable = true, nullable = true, unique = false)
    private String users;

    @Column(nullable = false, updatable = true)
    private boolean active;
}
