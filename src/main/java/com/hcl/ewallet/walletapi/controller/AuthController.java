package com.hcl.ewallet.walletapi.controller;

import com.hcl.ewallet.walletapi.model.AuthRequest;
import com.hcl.ewallet.walletapi.model.AuthResponse;
import jakarta.validation.Valid;
import com.hcl.ewallet.walletapi.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest req) {
        // For demo: accept fixed username/password
        if ("user".equals(req.getUsername()) && "password".equals(req.getPassword())) {
            String token = jwtUtil.generateToken(req.getUsername());
            return ResponseEntity.ok(new AuthResponse(token));
        }
        return ResponseEntity.status(401).build();
    }
}
