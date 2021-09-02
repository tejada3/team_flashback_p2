package com.revature.flash_back_api.web.util;

import com.revature.flash_back_api.web.dtos.Principal;
import com.revature.flash_back_api.web.util.security.JwtConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// TODO: Make this filter!
public class AuthFilter extends HttpFilter {

    private final Logger logger = LoggerFactory.getLogger(AuthFilter.class);

    private final JwtConfig jwtConfig;

    public AuthFilter(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        parseToken(req);
        chain.doFilter(req, res);
    }

    public void parseToken(HttpServletRequest req) {

        try {
            String header = req.getHeader(jwtConfig.getHeader());
            System.out.println("Header value: " + header);

            if (header == null || !header.startsWith(jwtConfig.getPrefix())) {
                System.out.println("Request originates from an unauthenticated source!");
                logger.warn("Request originates from an unauthenticated source!");
                return; // end early
            }

            String token = header.replaceAll(jwtConfig.getPrefix(), "");

            Claims jwtClaims = Jwts.parser()
                    .setSigningKey(jwtConfig.getSigningKey())
                    .parseClaimsJws(token)
                    .getBody();

            req.setAttribute("principal", new Principal(jwtClaims));
            System.out.println("Principal added as attribute to request!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
