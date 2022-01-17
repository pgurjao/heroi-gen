package br.edu.infnet.projetodebloco.heroigen.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.edu.infnet.projetodebloco.heroigen.filter.AuthorizationFilter;

@EnableWebSecurity
@Configuration
public class SegurancaConfig extends WebSecurityConfigurerAdapter{

	@Value("${jwtSigningKey}")
	private String jwtSigningKey;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.cors().disable()
			.csrf().disable()
			
			.authorizeRequests()
			.antMatchers( HttpMethod.GET, "/ranking/")
			.permitAll()
			
			.anyRequest().authenticated()
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.addFilterAt( new AuthorizationFilter(this.jwtSigningKey) 
						, UsernamePasswordAuthenticationFilter.class);
		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(
				"/h2-console/**"
				,"/ranking/"
				,"/heroi-gen/herois"
				,"/heroi-gen/herois/{id}")
		;
	}
	
}
