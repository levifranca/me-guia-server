package edu.metrocamp.meguia.api.security;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import edu.metrocamp.meguia.api.services.UsuarioService;

@Order(1)
@Configuration
@EnableWebSecurity
@EnableAsync
public class MeGuiaSecurityConfig extends WebSecurityConfigurerAdapter {
	
	public static final String ANONYMOUS_ROLE = "ANONYMOUS_ROLE";
	public static final String USER_ROLE = "USER_ROLE";
	public final static Set<String> ANONYMOUS_GET_URLS = new HashSet<>(Arrays.asList("/api/beacon_info", "/api/beacon/*/audio.mp3"));

	@Autowired
	private UsuarioService usuarioService;
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		

		final ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry rule = http
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests();

		setRule(ANONYMOUS_GET_URLS, HttpMethod.GET, rule);

		http.authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll();

		http.authorizeRequests().anyRequest().hasAuthority(USER_ROLE)
				.and()
				.addFilterBefore(new MeGuiaCorsFilter(), ChannelProcessingFilter.class)
				.addFilterBefore(new MeGuiaAuthFilter(usuarioService), UsernamePasswordAuthenticationFilter.class)
				.csrf().disable();
	}

	private void setRule(final Set<String> urls, final HttpMethod method,
			ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry urlRules) {
		for (final String url : urls) {
			urlRules = urlRules.antMatchers(method, url).hasAuthority(ANONYMOUS_ROLE);
			urlRules.antMatchers(HttpMethod.OPTIONS, url).permitAll();
		}
	}
}
