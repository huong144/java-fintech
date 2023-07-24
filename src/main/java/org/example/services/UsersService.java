package org.example.services;

import org.example.models.dto.CreateUsersDto;
import org.example.models.entity.UsersEntity;
import org.example.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

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

    public UsersEntity findById(int id) {
        return usersRepository.getById(id);
    }

//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        // Mặc định mình sẽ để tất cả là ROLE_USER. Để demo cho đơn giản.
//        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
//    }
    public UsersEntity createUser(CreateUsersDto createUserDto) throws UsernameNotFoundException {
        UsersEntity checkUser = findByUserName(createUserDto.getUsername());
        if (checkUser == null) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            UsersEntity newUser = new UsersEntity();
            newUser.setUsername(createUserDto.getUsername());
            newUser.setPassword(passwordEncoder.encode(createUserDto.getPassword()));
            newUser.setPhoneNumber(createUserDto.getUsername());
            newUser.setRoleId(1);
            newUser.setIsCustomer(createUserDto.getIsCustomer());
            return usersRepository.save(newUser);
        } else {
            throw new UsernameNotFoundException("Username already exists");
        }
    }

}
