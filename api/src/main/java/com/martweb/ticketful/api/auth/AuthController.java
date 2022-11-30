package com.martweb.ticketful.api.auth;

import com.martweb.ticketful.api.entities.User;
import com.martweb.ticketful.api.jwt.JwtTokenUtil;
import com.martweb.ticketful.api.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@Valid @RequestBody AuthRequest authRequest){
        var token = authService.userLogin(authRequest);
        System.out.println("token:"+token);
        return ResponseEntity.ok(token);
    }

}
