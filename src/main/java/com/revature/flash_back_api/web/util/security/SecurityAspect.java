package com.revature.flash_back_api.web.util.security;

import com.revature.flash_back_api.web.dtos.Principal;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Aspect
@Component
public class SecurityAspect {

    private final Logger logger = LoggerFactory.getLogger(SecurityAspect.class);

    private final JwtConfig jwtConfig;

    public SecurityAspect(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    @Around("@annotation(com.revature.flash_back_api.web.util.security.Secured)")
    public Object secureEndpoint(ProceedingJoinPoint pjp) throws Throwable {

        // This casts the method signature of pjp to a method using the Java reflect API.
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        // Grabs the data from the secured annotation inside of the above class method.
        Secured securedAnno = method.getAnnotation(Secured.class);
        // Leverages AOP to grab the allowed roles from the specific annotated secured course.
        List<String> allowedRoles = Arrays.asList(securedAnno.allowedRoles());

        HttpServletRequest req = (Objects.requireNonNull((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())).getRequest();

        // If they are valid and a part of the role list, allow the user through.
        Principal principal = parseToken(req).orElseThrow(() -> new AuthenticationException("Request originates from an unauthenticated source."));

        // TODO: Make Authorization Exception and place it here!
        if (!allowedRoles.contains(principal.getRole())) {
//            throw new "A forbidden request was made by: " + principal.getUsername()
        }

        return pjp.proceed();
    }

    public Optional<Principal> parseToken(HttpServletRequest req) {

        try {
            String header = req.getHeader(jwtConfig.getHeader());
            System.out.println("Header value: " + header);

            if (header == null || !header.startsWith(jwtConfig.getPrefix())) {
                System.out.println("Request originates from an unauthenticated source!");
                logger.warn("Request originates from an unauthenticated source!");
                return Optional.empty(); // end early
            }

            String token = header.replaceAll(jwtConfig.getPrefix(), "");

            Claims jwtClaims = Jwts.parser()
                    .setSigningKey(jwtConfig.getSigningKey())
                    .parseClaimsJws(token)
                    .getBody();

            return Optional.of(new Principal(jwtClaims));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return Optional.empty();
        }
    }
}
