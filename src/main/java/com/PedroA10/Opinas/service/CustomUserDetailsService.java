package com.PedroA10.Opinas.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    if (!"admin".equals(username)) {
      throw new UsernameNotFoundException("User not found: " + username);
    }
    return org.springframework.security.core.userdetails.User
      //User for tests
      .withUsername("admin")
      .password("1234567891012345")
      .roles("ADMIN")
      .build();
  }
}

