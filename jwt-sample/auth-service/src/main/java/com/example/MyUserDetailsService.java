package com.example;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by msnikitin on 24.04.2017.
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        switch (username) {
            case "reader":
                return new UserDetails() {
                    @Override
                    public Collection<? extends GrantedAuthority> getAuthorities() {
                        Collection<GrantedAuthority> authorities = new ArrayList<>();
                        authorities.add((GrantedAuthority) () -> "FOO_READ");
                        authorities.add((GrantedAuthority) () -> "ACTUATOR");
                        return authorities;
                    }

                    @Override
                    public String getPassword() {
                        return "password";
                    }

                    @Override
                    public String getUsername() {
                        return "reader";
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
                };
            case "writer":
                return new UserDetails() {
                    @Override
                    public Collection<? extends GrantedAuthority> getAuthorities() {
                        Collection<GrantedAuthority> authorities = new ArrayList<>();
                        authorities.add((GrantedAuthority) () -> "FOO_READ");
                        authorities.add((GrantedAuthority) () -> "FOO_WRITE");
                        return authorities;
                    }

                    @Override
                    public String getPassword() {
                        return "password";
                    }

                    @Override
                    public String getUsername() {
                        return "writer";
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
                };
        }

        throw new UsernameNotFoundException("get out!");
    }
}
