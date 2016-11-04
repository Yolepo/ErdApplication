package org.yolepo.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mjali on 24/10/2016.
 */
@ToString
@Entity
@Table(name = "PERMISSIONS")
public class Permission implements Serializable, GrantedAuthority {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(unique = true)
    private String name;

    public Permission() {
    }

    public Permission(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
