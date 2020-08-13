package com.codegym.web_service.Controller.accountController;

import com.codegym.dao.DTO.JwtResponse;
import com.codegym.dao.DTO.AccountDTO;

import com.codegym.service.impl.AccountServiceImpl;
import com.codegym.web_service.security.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Authorization")
@RequestMapping("")
class AccountController {
    @Autowired(required = false)
    AuthenticationManager authenticationManager;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Autowired(required = false)
    AccountServiceImpl accountServiceImpl;

    private AccountDTO accountDTO;

    @GetMapping("/admin")
    public ResponseEntity<?> helloAdmin() {
        accountDTO = new AccountDTO("admin", "Hello");
        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }

    @GetMapping("/member")
    public ResponseEntity<?> helloMember() {
        accountDTO = new AccountDTO("member", "Hello");
        return new ResponseEntity<>(accountDTO, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AccountDTO accountDTO) {
        System.out.println(accountDTO.getAccountPassword());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(accountDTO.getAccountName(), accountDTO.getAccountPassword())
        );
        UserDetails userDetails = accountServiceImpl.loadUserByUsername(authentication.getName());
        String jwtToken = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(jwtToken, userDetails.getUsername(), userDetails.getAuthorities()));
    }
}