package cs544.auth.model;

import org.springframework.security.core.GrantedAuthority;

public enum AppUserRole implements GrantedAuthority {
    ADMIN, TEACHER,STUDENT;

    public String getAuthority() {
        return name();
    }

}
