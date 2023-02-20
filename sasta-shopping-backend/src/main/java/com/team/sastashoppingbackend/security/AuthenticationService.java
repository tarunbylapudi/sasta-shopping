package com.team.sastashoppingbackend.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.team.sastashoppingbackend.entity.auth.MyUserDetails;
import com.team.sastashoppingbackend.entity.auth.Role;
import com.team.sastashoppingbackend.entity.auth.User;
import com.team.sastashoppingbackend.entity.auth.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(RegisterRequest request) {
    var user = User.builder()
        .firstName(request.getFirstname())
        .lastName(request.getLastname())
        .userName(request.getUserName())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.USER)
        .build();
    repository.save(user);
    var jwtToken = jwtService.generateToken(createClaims(user),new MyUserDetails(user));
    boolean isAdmin = "ADMIN".equals(user.getRole().name());
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .isAdmin(isAdmin)
        .build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getUserName(),
            request.getPassword()
        )
    );
    var user = repository.findByUserName(request.getUserName())
        .orElseThrow();
    var jwtToken = jwtService.generateToken(createClaims(user),new MyUserDetails(user));
    boolean isAdmin = "ADMIN".equals(user.getRole().name());
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .isAdmin(isAdmin)
        .build();
  }
  

private Map<String,Object> createClaims(User user){
	Map<String,Object> map = new HashMap<>();
	map.put("firstName", user.getFirstName());
	map.put("role", user.getRole().name());
	map.put("userId", user.getId());
	return map;
}

}
