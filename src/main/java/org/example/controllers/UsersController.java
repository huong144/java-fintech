package org.example.controllers;

import org.example.config.JwtTokenProvider;
import org.example.models.dto.CreateUsersDto;
import org.example.models.dto.UpdateUsersDto;
import org.example.models.entity.UsersEntity;
import org.example.response.BaseResponse;
import org.example.response.LoginResponse;
import org.example.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("users")
public class UsersController {
    @Autowired
    private UsersService usersService;
    private LoginResponse loginResponse;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }
    @Autowired
    @Qualifier("authenticationManagerBean")
    private  AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;
    @GetMapping
    public List<UsersEntity> findAllUsers() {
        return usersService.findAllUsers();
    }

    @PostMapping("/register")
    public ResponseEntity<BaseResponse<UsersEntity>> createUser(@RequestBody CreateUsersDto createUserDto){
        return usersService.createUser(createUserDto);
    }

    @PostMapping("/login")
    public LoginResponse authenticateUser(@Valid @RequestBody CreateUsersDto createUsersDto ) {
        // Xác thực từ username và password.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        createUsersDto.getUsername(),
                        createUsersDto.getPassword()
                )
        );
        // Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // Trả về jwt cho người dùng.
       String jwt = tokenProvider.generateToken(createUsersDto.getUsername());
        return new LoginResponse(jwt);
    }

    @PutMapping
    public ResponseEntity<BaseResponse<UsersEntity>> updateUserInfo(@RequestBody UpdateUsersDto updateUsersDto){
        return usersService.updateUserInfo(updateUsersDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        usersService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    @GetMapping("/id")
    public ResponseEntity<BaseResponse<UsersEntity>> findUserById(@RequestParam int id){
        return usersService.findUserById(id);
    }

}
