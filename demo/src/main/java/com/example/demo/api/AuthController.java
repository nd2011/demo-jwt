package com.example.demo.api;


import com.example.demo.security.JwtUtil;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager am, JwtUtil jwtUtil) {
        this.authManager = am;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest req) {
        try {
            authManager.authenticate(new UsernamePasswordAuthenticationToken(req.username(), req.password()));
            String token = jwtUtil.generateToken(req.username());
            return new LoginResponse(token);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Sai tài khoản hoặc mật khẩu");
        }
    }
}