package com.example.jwtsecurity.controller;

import com.example.jwtsecurity.domain.User;
import com.example.jwtsecurity.dto.UserDto;
import com.example.jwtsecurity.jwt.JwtProvider;
import com.example.jwtsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;
    private final JwtProvider jwtProvider;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody UserDto userDto) {
        User joinUser = userService.join(userDto.getEmail(), userDto.getPassword());
        return new ResponseEntity("OK", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDto userDto, HttpServletResponse response) throws Throwable {
        User loginUser = userService.login(userDto.getEmail(), userDto.getPassword());
        String token = jwtProvider.createToken(userDto.getEmail(), loginUser.getRoles());
        response.addHeader("X-AUTH-TOKEN", token);
        return new ResponseEntity<String>(token, HttpStatus.OK);
    }

    @GetMapping("/user")
    public String user() {
        return "user";
    }

    @GetMapping("/all")
    public String all() {
        return "all";
    }

    @GetMapping("/guest")
    public String guest() {
        return "guest";
    }

    @GetMapping("/error")
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String error(){
        return "error";
    }
}
