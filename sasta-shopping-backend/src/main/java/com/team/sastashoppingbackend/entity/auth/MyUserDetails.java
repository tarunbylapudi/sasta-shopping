package com.team.sastashoppingbackend.entity.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.NoArgsConstructor;

@Service
@Data
@NoArgsConstructor
public class MyUserDetails implements UserDetails {

	private String username;
	private String password;
	private Role role;

	public MyUserDetails(User userDetails) {
		this.password = userDetails.getPassword();
		this.username = userDetails.getUserName();
		this.role = userDetails.getRole();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority(role.name()));
		return authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {

		return true;
	}

}
