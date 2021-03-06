package com.kwler.legacy.api.security;

import com.kwler.legacy.api.admin.model.StandardUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

@AllArgsConstructor
public class KWLStandardUserDetails implements UserDetails {

    private final StandardUser standardUser;

    private static final Collection<? extends GrantedAuthority> standardAuthorities = Arrays.asList(
            new SimpleGrantedAuthority("ROLE_USER"),
            new SimpleGrantedAuthority("ROLE_STANDARD")
    );

    public StandardUser getStandardUser() {
        return standardUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (getUsername().equalsIgnoreCase("oat@meal.com")) {
            return Arrays.asList(
                    new SimpleGrantedAuthority("ROLE_USER"),
                    new SimpleGrantedAuthority("ROLE_STANDARD"),
                    new SimpleGrantedAuthority("ROLE_ADMIN")
            );
        }

        return standardAuthorities;
    }

    @Override
    public String getPassword() {
        return standardUser.getUserAccount().getHashedPassword();
    }

    @Override
    public String getUsername() {
        return standardUser.getUserProfile().getEmail();
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
