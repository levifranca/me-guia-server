package edu.metrocamp.meguia.api.security;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.GenericFilterBean;

import edu.metrocamp.meguia.api.model.Usuario;
import edu.metrocamp.meguia.api.services.UsuarioService;

public class MeGuiaAuthFilter extends GenericFilterBean {

	private UsuarioService usuarioService;

	public MeGuiaAuthFilter(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpResp = (HttpServletResponse) response;

		Authentication authentication;
		
		if (isPublicPath(httpReq)) {

			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new GrantedAuthority() {
				private static final long serialVersionUID = -4673399353478163508L;

				@Override
				public String getAuthority() {
					return MeGuiaSecurityConfig.ANONYMOUS_ROLE;
				}
			});
			authentication = new UsernamePasswordAuthenticationToken("anonimo", null, authorities);
		} else {

			String authHeader = httpReq.getHeader(HttpHeaders.AUTHORIZATION);
			if (authHeader == null || !authHeader.startsWith("Basic")) {
				httpResp.sendError(HttpServletResponse.SC_UNAUTHORIZED);
				return;
			}
			String base64Credentials = authHeader.substring("Basic".length()).trim();
			String plainCredentials = new String(Base64.getDecoder().decode(base64Credentials), StandardCharsets.UTF_8);
			String[] credentialsArray = plainCredentials.split(":", 2);
			String username = credentialsArray[0];
			String password = credentialsArray[1];

			Usuario u = usuarioService.checkUsuario(username, password);
			if (u == null) {
				httpResp.sendError(HttpServletResponse.SC_FORBIDDEN);
				return;
			}

			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new GrantedAuthority() {
				private static final long serialVersionUID = 1L;

				@Override
				public String getAuthority() {
					return MeGuiaSecurityConfig.USER_ROLE;
				}
			});
			authentication = new UsernamePasswordAuthenticationToken(u, null, authorities);
		}

		SecurityContextHolder.getContext().setAuthentication(authentication);

		chain.doFilter(request, response);
	}

	private boolean isPublicPath(HttpServletRequest httpReq) {
		AntPathRequestMatcher matcher;
		for (String pattern : MeGuiaSecurityConfig.ANONYMOUS_GET_URLS) {
			matcher = new AntPathRequestMatcher(pattern, HttpMethod.GET.name());
			if (matcher.matches(httpReq)) {
				return true;
			}
		}
		return false;
	}

}
