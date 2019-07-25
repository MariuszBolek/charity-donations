package pl.charity.service;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CurrentUser extends User {
    private final pl.charity.entity.User user;

    public CurrentUser(String email, String password, Collection<? extends GrantedAuthority> authorities,
                       pl.charity.entity.User user) {
        super(email, password, authorities);
        this.user = user;
    }

    public pl.charity.entity.User getUser() {
        return user;
    }
}
