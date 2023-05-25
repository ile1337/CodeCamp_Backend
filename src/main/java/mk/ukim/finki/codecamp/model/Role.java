package mk.ukim.finki.codecamp.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;//


public enum Role implements GrantedAuthority{
    ROLE_STUDENT, ROLE_ADMIN, ROLE_PROFESSOR;

    @Override
    public String getAuthority() {
        return name();
    }
}
