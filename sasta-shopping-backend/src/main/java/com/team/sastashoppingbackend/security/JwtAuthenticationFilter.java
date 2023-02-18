package com.team.sastashoppingbackend.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private final JwtService jwtService;
	
	@Autowired
	private final MyUserDetailsService userDetailsService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		final String authorizationHeader = request.getHeader("Authorization");
		final String jwt;
		final String userName;
		
		if (null == authorizationHeader || !authorizationHeader.contains("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}
		
		jwt = authorizationHeader.substring(7);
		userName = jwtService.extractUsername(jwt);
	    if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
	      UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);
	      if (jwtService.isTokenValid(jwt, userDetails)) {
	        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
	            userDetails,
	            null,
	            userDetails.getAuthorities()
	        );
	        authToken.setDetails(
	            new WebAuthenticationDetailsSource().buildDetails(request)
	        );
	        SecurityContextHolder.getContext().setAuthentication(authToken);
	      }
	    }
		

	}

}
