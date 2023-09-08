package com.misfat.qrqc.Filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

public class JwtAuthorizationFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
			String authorizationToken = request.getHeader("Authorization");
			if(authorizationToken != null && authorizationToken.startsWith("Bearer ")) {
				try {
					String jwt = authorizationToken.substring(7);
					Algorithm algorithm = Algorithm.HMAC256("mySecret1234");
					JWTVerifier jwtVerifier = JWT.require(algorithm).build();
					DecodedJWT decodedJWT = jwtVerifier.verify(jwt);
					String userName = decodedJWT.getSubject();
					String [] roles = decodedJWT.getClaim("roles").asArray(String.class);
					Collection<GrantedAuthority> authorities = new ArrayList<>();
					for(String r : roles) {
						authorities.add(new SimpleGrantedAuthority(r));
					}
					UsernamePasswordAuthenticationToken authentificationToken = new UsernamePasswordAuthenticationToken(userName, null , authorities);
					SecurityContextHolder.getContext().setAuthentication(authentificationToken);
					response.setHeader("Access-Control-Allow-Origin", "*");
					//response.setHeader("Access-Control-Max-Age", "3600");
					response.setHeader("Access-Control-Allow-Credentials", "true");
					response.setHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, DELETE, PUT, PATCH");
					response.setHeader("Access-Control-Allow-Headers",
							"Origin, X-Requested-With, Content-Type, Accept, Key, Authorization, client-security-token");
					
					if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
						response.setStatus(HttpServletResponse.SC_OK);
					}
					else {
						filterChain.doFilter(request, response);
					}
				}
				catch(Exception e){
					response.setHeader("error-message",e.getMessage());
					response.sendError(HttpServletResponse.SC_FORBIDDEN);
				}
				
				
				
			}
			else {
				filterChain.doFilter(request, response);

			}
	}

}
