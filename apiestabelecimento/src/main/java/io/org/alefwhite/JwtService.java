package io.org.alefwhite;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.org.alefwhite.domains.entity.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    @Value("${security.jwt.expiracao}")
    private String expiracao;

    @Value("${security.jwt.chave-assinatura}")
    private String chaveAssinatura;

    public String gerarToken(Usuario usuario) {
        long expString = Long.valueOf(expiracao);
        LocalDateTime dataHoraExpiracao = LocalDateTime.now().plusMinutes(expString);
        Instant instant = dataHoraExpiracao.atZone(ZoneId.systemDefault()).toInstant();
        Date data = Date.from(instant);

        Map<String, Object> claims = new HashMap<>();
        claims.put("email_usuario", usuario.getEmail());
        claims.put("roles", usuario.getAdmin());
        claims.put("id_usuario", usuario.getId());

        return Jwts
                .builder()
                .setSubject(usuario.getEmail())
                .setClaims(claims)
                .setExpiration(data)
                .signWith( SignatureAlgorithm.HS512, chaveAssinatura )
                .compact();
    }

    private Claims obterClaims(String token) throws ExpiredJwtException {
        return Jwts
                .parser()
                .setSigningKey(chaveAssinatura)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean tokenValido(String token) {
        try {
            Claims claims = obterClaims(token);

            Date dataExpiracao = claims.getExpiration();

            LocalDateTime data = dataExpiracao
                                            .toInstant()
                                            .atZone(ZoneId.systemDefault())
                                            .toLocalDateTime();

            return !LocalDateTime.now().isAfter(data);

        } catch (Exception e) {
            return false;
        }
    }

    public Claims obterLoginUsuario(String token) throws ExpiredJwtException {
        return obterClaims(token);
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext contexto = SpringApplication.run(EstabelecimentoApplication.class);
        JwtService service = contexto.getBean(JwtService.class);
        Usuario usuario = Usuario.builder().email("alefwhite@gmail.com").build();
        String token = service.gerarToken(usuario);
        System.out.println(token);

        boolean tokenValido = service.tokenValido(token);
        System.out.println("Token valido: " + tokenValido);
        System.out.println(service.obterLoginUsuario(token));

    }
}
