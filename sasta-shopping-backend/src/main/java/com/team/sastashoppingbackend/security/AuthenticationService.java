package com.team.sastashoppingbackend.security;

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
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.USER)
        .build();
    repository.save(user);
    var jwtToken = jwtService.generateToken(new MyUserDetails(user));
    return AuthenticationResponse.builder()
        .token(jwtToken)
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
    var jwtToken = jwtService.generateToken(new MyUserDetails(user));
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }
}
