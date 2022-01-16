package br.edu.infnet.projetodebloco.heroigen.filter;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.OncePerRequestFilter;

import br.edu.infnet.projetodebloco.heroigen.dtos.UsuarioAutenticado;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

public class AuthorizationFilter extends OncePerRequestFilter{
	
	private String jwtSigningKey;
	
	final String prefix = "Bearer ";
	
	public AuthorizationFilter(String jwtSigningKey)
	{
		this.jwtSigningKey = jwtSigningKey;
	}
	
	@Override
	protected void doFilterInternal(
				HttpServletRequest request, 
				HttpServletResponse response, 
				FilterChain filterChain)
			throws ServletException, IOException {

		final String authHeader = request.getHeader("Authorization");
		
		final Jws<Claims> claims = Jwts	.parser()
										.setSigningKey(this.jwtSigningKey)
										.parseClaimsJws(authHeader.replace(this.prefix, ""));
		
		final String userId = claims.getBody().getSubject();
		final String username = claims.getBody().get("username", String.class);
		
		SecurityContextHolder.getContext().setAuthentication( 
				new PreAuthenticatedAuthenticationToken( 
						new UsuarioAutenticado(Integer.valueOf(userId), username)
						, 	null
						, 	Collections.emptyList() ) 
					);
		
		filterChain.doFilter(request, response);
		
	}
	
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		
		final String requestURI = request.getRequestURI();
		final String method = request.getMethod();
		
		return 		requestURI.startsWith("/h2-console") 
				|| 	( requestURI.startsWith("/ranking") && method.equals("GET"))
				|| 	( requestURI.startsWith("/herois") );
	}

}
