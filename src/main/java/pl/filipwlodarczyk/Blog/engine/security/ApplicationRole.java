package pl.filipwlodarczyk.Blog.engine.security;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static pl.filipwlodarczyk.Blog.engine.security.ApplicationPermission.*;

public enum ApplicationRole {
    ADMIN(Sets.newHashSet(USER_READ, USER_WRITE));

    private final Set<ApplicationPermission> applicationPermissions;

    ApplicationRole(Set<ApplicationPermission> applicationPermissions) {
        this.applicationPermissions = applicationPermissions;
    }

    public Set<ApplicationPermission> getApplicationPermissions() {
        return applicationPermissions;
    }

    public Set<SimpleGrantedAuthority>getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getApplicationPermissions().stream()
                .map(applicationPermissions -> new SimpleGrantedAuthority(applicationPermissions.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
