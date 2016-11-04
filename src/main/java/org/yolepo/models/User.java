package org.yolepo.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mjali on 24/10/2016.
 */
@ToString
@Entity
@Table(name = "USERS")
public class User implements Serializable, UserDetails {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Size(min = 4, message = "user.username.size")
    @Column(unique = true)
    private String username;

    @NotNull
    @NotEmpty(message = "user.password.empty")
    @Size(min = 6, message = "user.password.size")
    private String password;

    @Getter
    @Setter
    @NotNull
    @NotEmpty(message = "user.lastName.empty")
    private String lastName;

    @Getter
    @Setter
    @NotNull
    @NotEmpty(message = "user.firstName.empty")
    private String firstName;

    @Getter
    @Setter
    @NotNull
    @NotEmpty(message = "user.email.empty")
    @Email(message = "user.email.notValid")
    private String email;

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @Getter
    @Setter
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastAccess;

    @Getter
    @Setter
    private Boolean enabled;

    @Getter
    @Setter
    private Boolean tokenExpired;

    @Getter
    @Setter
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(
            name = "user_role",
            joinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "permission_id", referencedColumnName = "id")}
    )
    private Set<Role> roles;

    public User() {
    }

    public User(String username, String password, String lastName, String firstName, String email) {
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.username = username;
        this.tokenExpired = false;
    }

    @PrePersist
    protected void onCreate() {
        creationDate = new Date();
    }

    @Transient
    public Set<Permission> getPermissions() {
        Set<Permission> permissions = new HashSet<>();
        for (Role role : roles) permissions.addAll(role.getPermissionSet());
        return permissions;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.addAll(getRoles());
        authorities.addAll(getPermissions());
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
