package ml.sadriev.session.model;

import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

    @Column(length = 32, unique = true, updatable = false, nullable = false)
    private String nickName;

    @Column(length = 32, updatable = true, nullable = false)
    private String firstName;

    @Column(length = 32, updatable = true)
    private String lastName;

    @Column(unique = true, updatable = true, nullable = false)
    private String email;

    @Column(updatable = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @Column(length = 16, updatable = true, nullable = false)
    private String password;

    @Column(updatable = false, nullable = false, insertable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date creatingUserDate;

    @Column(updatable = true)
    @Enumerated(EnumType.STRING)
    private RolesEnum role;

    @Column(updatable = true, nullable = false, name = "admin_permission")
    private boolean isAdmin;

    @Column(updatable = true, nullable = false)
    private boolean isLogged;

    @Column(updatable = true, nullable = true)
    private boolean deleted;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "users_groups",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<Groups> groups;
}