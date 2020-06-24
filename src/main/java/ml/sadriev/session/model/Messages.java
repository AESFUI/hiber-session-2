package ml.sadriev.session.model;

import java.sql.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "table_messages")
public class Messages {

    @Id
    @GeneratedValue(generator = "system-uuid")
    private UUID id;

    @Column(length = 32, updatable = false)
    private String nickNameFrom;

    @Column(length = 32, updatable = false)
    private String nickNameTo;

    @Column(length = 255, updatable = true)
    private String groupName;

    @Column(unique = false, updatable = false, nullable = false)
    private Date createdDate;

    @Column(unique = false, updatable = false, length = 255, nullable = false)
    private String text;
}
