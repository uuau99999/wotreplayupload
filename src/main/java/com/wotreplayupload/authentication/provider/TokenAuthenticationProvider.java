package com.wotreplayupload.authentication.provider;

import com.wotreplayupload.authentication.token.AuthenticationToken;
import com.wotreplayupload.authority.Authority;
import com.wotreplayupload.token.Token;
import com.wotreplayupload.token.TokenRepository;
import com.wotreplayupload.user.User;
import com.wotreplayupload.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class TokenAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenRepository tokenRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        AuthenticationToken authenticationToken = (AuthenticationToken) authentication;
        Token token = tokenRepository.findOne(authenticationToken.getTokenString());
        if (token == null) {
            throw new BadCredentialsException("invalid token");
        }
        return buildAuthentication(token.getUserId());
    }

    private AuthenticationToken buildAuthentication(String userId) {
        User user = userRepository.findOne(userId);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Authority authority : user.getAuthorities()) {
            authorities.add(new SimpleGrantedAuthority(authority.getRole()));
        }
        return new AuthenticationToken(userId, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return AuthenticationToken.class.isAssignableFrom(authentication);
    }
}
