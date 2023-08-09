package org.example.services;

import org.example.models.entity.RoleEntity;
import org.example.models.entity.UsersEntity;
import org.example.repository.RoleRepository;
import org.example.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UsersEntity user = usersRepository.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        List<RoleEntity> roles = roleRepository.findAll();
        Set<GrantedAuthority> authorities = roles.stream()
               .map((role) -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toSet());
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                authorities);
    }
}