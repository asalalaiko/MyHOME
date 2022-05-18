package by.asalalaiko.myhome.dto;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    ADMIN, USER, MANAGER, OWNER;

    @Override
    public String getAuthority() {
        return  name();
    }
}
