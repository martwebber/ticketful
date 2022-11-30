package com.martweb.ticketful.api.services;

import com.martweb.ticketful.api.auth.AuthRequest;
import com.martweb.ticketful.api.auth.AuthResponse;
import com.martweb.ticketful.api.entities.User;
import com.martweb.ticketful.api.jwt.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    AuthenticationManager authManager;
    @Autowired
    JwtTokenUtil jwtUtil;
    public Object userLogin(AuthRequest request){
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(), request.getPassword())
            );

            User user = (User) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(user);
            var response = new AuthResponse(user.getEmail(), accessToken);
            return response;

        } catch (BadCredentialsException ex) {
            return "You are unauthorized";
        }
    }
}
