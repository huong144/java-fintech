package org.example.services;

import jdk.nashorn.internal.parser.JSONParser;
import org.example.models.dto.CreateUsersDto;
import org.example.models.dto.UpdateUsersDto;
import org.example.models.entity.UsersEntity;
import org.example.repository.UsersRepository;
import org.example.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        super();
        this.usersRepository = usersRepository;
    }

    public List<UsersEntity> findAllUsers() {
        return usersRepository.findAll();
    }

    public UsersEntity findByUserName(String username) {
        return usersRepository.findByUsername(username);
    }

    //    public Collection<? extends GrantedAuthority> getAuthorities() {
//        // Mặc định mình sẽ để tất cả là ROLE_USER. Để demo cho đơn giản.
//        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
//    }
    public ResponseEntity<BaseResponse<UsersEntity>> createUser(CreateUsersDto createUserDto) throws UsernameNotFoundException {
        UsersEntity checkUser = findByUserName(createUserDto.getUsername());
        if (checkUser == null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            UsersEntity newUser = new UsersEntity();
            newUser.setUsername(createUserDto.getUsername());
            newUser.setPassword(passwordEncoder.encode(createUserDto.getPassword()));
            newUser.setPhoneNumber(createUserDto.getUsername());
            newUser.setRoleId(1);
            newUser.setIsCustomer(createUserDto.getIsCustomer());
            return ResponseEntity.ok(new BaseResponse<>(200, "Success", newUser));
        } else {
            return ResponseEntity.ok(new BaseResponse<>(404, "User already exists"));
        }
    }

    public ResponseEntity<BaseResponse<UsersEntity>> updateUserInfo(UpdateUsersDto updateUsersDto) {
        UsersEntity user = usersRepository.getById(updateUsersDto.getId());
        if (user == null) {
            return ResponseEntity.ok(new BaseResponse<>(404, "User not found"));
        }
        user.setFullName(user.getFullName() == null ? updateUsersDto.getFullName() : user.getFullName());
        user.setAddress(user.getAddress() == null ? updateUsersDto.getAddress() : user.getAddress());
        user.setDateOfBirth(user.getDateOfBirth() == null ? updateUsersDto.getDateOfBirth() : user.getDateOfBirth());
        user.setSex(user.getSex() == null ? updateUsersDto.getSex() : user.getSex());
        user.setAvatar(user.getAvatar() == null ? updateUsersDto.getAvatar() : user.getAvatar());
        user.setEmail(user.getEmail() == null ? updateUsersDto.getEmail() : user.getEmail());
        user.setIdentityDocumentType(user.getIdentityDocumentType() == null ? updateUsersDto.getIdentityDocumentType() : user.getIdentityDocumentType());
        user.setIdentityNumber(user.getIdentityNumber() == null ? updateUsersDto.getIdentityNumber() : user.getIdentityNumber());
        return ResponseEntity.ok(new BaseResponse<>(200, "Success", usersRepository.save(user)));
    }

    public ResponseEntity<String> deleteUser(int id) {
        UsersEntity user = usersRepository.getById(id);
        if (user == null) {
            return ResponseEntity.ok("User not found");
        }
        usersRepository.deleteById(id);
        return ResponseEntity.ok("Success");
    }

    public ResponseEntity<BaseResponse<UsersEntity>> findUserById(int id) {
        Optional<UsersEntity> optionalUser = usersRepository.findById(id);
        if (optionalUser.isPresent()) {
            UsersEntity user = optionalUser.get();
            return ResponseEntity.ok(new BaseResponse<>(200, "Success", user));
        } else {
            return ResponseEntity.ok(new BaseResponse<>(404, "User not found"));
        }
    }
}
