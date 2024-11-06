
package puj.web.clinicahaven.security;


import java.security.*;
import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTGenerator {

    public static final long EXPIRATION_TIME = 3600000; // 1 hora
    private static final Key key =  Keys.secretKeyFor(SignatureAlgorithm.HS512);
    public String generateToken(Authentication authentication){
        /*Datos necesarios para la crreacion */
        String username = authentication.getName(); 
        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + EXPIRATION_TIME);
        /*Crear El JWT*/ 
        String token = Jwts.builder().setSubject(username)
        .setIssuedAt(currentDate).setExpiration(expireDate)
        .signWith(key,SignatureAlgorithm.HS512).compact();
    
    return token;
    }

    public String extractUsername(String token){
    return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
    }

    /* */
    public boolean validateToken(String token){
        try{
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        }catch(Exception e){
            return false;
        }
    }


    
}
