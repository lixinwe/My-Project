package com.my.project.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Jwt tools class
 *
 * @author
 */
@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

    @Autowired
    private JwtProperties jwtProperties;

    /**
     * generate jwt token
     */
    public String generateToken(Long userId) {
        return Jwts.builder()
            .setHeaderParam("typ", "JWT")
            .setSubject(userId+"")
            .setIssuedAt(new Date())
            .setExpiration(DateTime.now().plusSeconds(jwtProperties.getExpire()).toDate())
            .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecret())
            .compact();
    }

    public Claims getClaimByToken(String token) {
        try {
            return Jwts.parser()
                .setSigningKey(jwtProperties.getSecret())
                .parseClaimsJws(token)
                .getBody();
        }catch (Exception e){
            logger.debug("validate is token error, token = " + token, e);
            return null;
        }
    }

    /**
     * token check be overdue
     * @return  true：be overdue
     */
    public boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }
}
