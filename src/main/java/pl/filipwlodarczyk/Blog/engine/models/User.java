package pl.filipwlodarczyk.Blog.engine.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.filipwlodarczyk.Blog.engine.security.ApplicationPermission;
import pl.filipwlodarczyk.Blog.engine.security.ApplicationRole;

import javax.persistence.*;
import java.util.*;

import static pl.filipwlodarczyk.Blog.engine.security.ApplicationRole.*;

@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @SequenceGenerator(name = "userId_sequence", sequenceName = "userId_sequence", allocationSize = 1)
    @GeneratedValue(generator = "userId_sequence", strategy = GenerationType.SEQUENCE)
    private Long userId;
    @Column
    private final String username;
    @Column
    private final String password;
    @Column
    private final String email;
    @Column
    private final Date dateOfBirth;
    @Column
    private final Sex sex;
    private final boolean isAccountNonExpired;
    private final boolean isAccountNonLocked;
    private final boolean isCredentialsNonExpired;
    private final boolean isEnabled;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    private Collection<? extends GrantedAuthority> authorities = new HashSet<>();


    public User(String username,
                String password,
                String email,
                Date dateOfBirth,
                Sex sex,
                boolean isAccountNonExpired,
                boolean isAccountNonLocked,
                boolean isCredentialsNonExpired,
                boolean isEnabled,
                Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }


}
