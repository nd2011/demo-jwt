package com.example.demo.security;

import java.util.List;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!"duong".equals(username)) throw new UsernameNotFoundException("Not found");
        // password: "123456" (noop = không mã hóa, chỉ demo)
        return new User("duong", "{noop}123456", List.of(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
