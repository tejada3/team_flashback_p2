package com.revature.flash_back_api.web.util.security;


import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenGenerator {

    private final JwtConfig jwtConfig;

    @Autowired
    public TokenGenerator(JwtConfig jwtConfig) { this.jwtConfig = jwtConfig; }

    // TODO: Put a Principal data transfer object here!
    public String createToken() {

        long now = System.currentTimeMillis();

        JwtBuilder tokenBuilder = Jwts.builder()
                .setId()
                .setSubject()
                .setIssuer("revature")
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + jwtConfig.getExpiration()))
                .signWith(jwtConfig.getSigAlg(), jwtConfig.getSigningKey());

        return jwtConfig.getPrefix() + tokenBuilder.compact();
    }

    public String getJwtHeader() { return jwtConfig.getHeader(); }

    public JwtConfig getJwtConfig() { return jwtConfig; }
}
