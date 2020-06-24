package ml.sadriev.session.model;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import ml.sadriev.session.enums.GenderEnum;
import ml.sadriev.session.enums.RolesEnum;


@Data
@Entity
@Table(name = "table_users")
public class Users {

    @Id
    @GeneratedValue(generator = "system-uuid")
    private UUID id;

    @Column(length = 32, unique = true, updatable = false)
    private String nickName;

    @Column(length = 32, updatable = true)
    private String firstName;

    @Column(length = 32, updatable = true)
    private String lastName;

    @Column(unique = true, updatable = true)
    private String email;

    @Column(updatable = true)
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @Column(length = 16, updatable = true)
    private String password;

    @Column(updatable = false, nullable = false, insertable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date creatingUserDate;

    @Column(updatable = true)
    @Enumerated(EnumType.STRING)
    private RolesEnum groups;

    @Column(updatable = true, nullable = false, name = "admin_permission")
    private boolean isAdmin;

    @Column(updatable = true, nullable = false)
    private boolean isLogged;

    @Column(updatable = true, nullable = true)
    private boolean deleted;
}