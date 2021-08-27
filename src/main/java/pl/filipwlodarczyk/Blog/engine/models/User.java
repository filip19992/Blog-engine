package pl.filipwlodarczyk.Blog.engine.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
public class User implements UserDetails {

    @Id
    @SequenceGenerator(name = "userId_sequence", sequenceName = "userId_sequence", allocationSize = 1)
    @GeneratedValue(generator = "userId_sequence", strategy = GenerationType.AUTO)
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
    private final boolean sex;
    @Column
    private final boolean isAccountNonExpired;
    @Column
    private final boolean isAccountNonLocked;
    @Column
    private final boolean isCredentialsNonExpired;
    @Column
    private final boolean isEnabled;

    @Column
    private final Set<? extends GrantedAuthority> authorities;


    public User(String username,
                String password,
                String email,
                Date dateOfBirth,
                boolean sex,
                boolean isAccountNonExpired,
                boolean isAccountNonLocked,
                boolean isCredentialsNonExpired,
                boolean isEnabled,
                Set<? extends GrantedAuthority> authorities) {
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
