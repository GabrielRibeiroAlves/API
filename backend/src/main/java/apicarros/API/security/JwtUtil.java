package apicarros.API.security;

import apicarros.API.entity.Pessoa;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private String chaveSecreta = "chaveSecretaParaGerarToken";
    private int validadeToken= 900000;
    private static final Logger logger= LoggerFactory.getLogger(JwtUtil.class);

    public String gerarTokenUsername(Pessoa pessoa)
     {
        return Jwts.builder().setSubject(pessoa.getUsername())
                .setIssuedAt(new Date(new Date().getTime()+validadeToken))
                .signWith(SignatureAlgorithm.HS512,chaveSecreta).compact();
    }

    public String getEmailToken(String token)
    {
       return Jwts.parser().setSigningKey(chaveSecreta).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validaToken(String token)
    {
        try {
            Jwts.parser().setSigningKey(chaveSecreta).parseClaimsJws(token);
            return true;
        } catch (SignatureException e)
        {
            logger.error("Assinatura invalida",e.getMessage());
        }catch (ExpiredJwtException e)
        {
            logger.error("Token expirado",e.getMessage());
        }catch (UnsupportedJwtException e)
        {
            logger.error("Token nao suportado",e.getMessage());
        }
        return false;
    }
}
