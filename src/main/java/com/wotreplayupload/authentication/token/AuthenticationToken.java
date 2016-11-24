package com.wotreplayupload.authentication.token;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class AuthenticationToken extends AbstractAuthenticationToken {

    private String principal;

    private String tokenString;

    public AuthenticationToken(String tokenString) {
        super(null);
        this.tokenString = tokenString;
    }

    public AuthenticationToken(String userId, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        principal = userId;
        setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }

    public String getTokenString() {
        return tokenString;
    }
}
