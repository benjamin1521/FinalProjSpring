package ua.training.entities.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    Client, Inspector, Admin;

    @Override
    public String getAuthority() {
        return name();
    }
}
