package br.com.procode.api.service;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.procode.api.entity.Usuario;

@Service
public class TokenService {
	public String gerarToken(Usuario usuario) {
		try {
			Algorithm algorithm = Algorithm.HMAC256("PKXhMyR6Sos3RD5TxXMR2yjsJFN0UGJw");
			String token = JWT.create()
					.withIssuer("api-alunos")
					.withSubject(usuario.getLogin())
					.withClaim("id", usuario.getId())
					.withExpiresAt(getDataExpiracao())
					.sign(algorithm);
				return token;
		} catch (Exception e) {
			throw new RuntimeException("Error ao gerar token.", e);
		}
	}
	public String getLogin(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256("PKXhMyR6Sos3RD5TxXMR2yjsJFN0UGJw");
			String login = JWT.require(algorithm)
					.withIssuer("api-alunos")
					.build()
					.verify(token)
					.getSubject();
				return login;
		} catch (JWTVerificationException e) {
			throw new RuntimeException("Token inválido ou expirado.", e);
		}
	}
	private Instant getDataExpiracao() {
		return  LocalDateTime.now().plusMinutes(2).toInstant(ZoneOffset.of("-03:00"));
	}

}
