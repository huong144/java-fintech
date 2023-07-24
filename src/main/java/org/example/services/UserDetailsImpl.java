//package org.example.services;
//
//import org.example.models.entity.UsersEntity;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import java.util.Collection;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//public class UserDetailsImpl implements UserDetails {
//
//    private UsersEntity user;
//
//    public UserDetailsImpl(UsersEntity user) {
//        this.user = user;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        // Implement the logic to retrieve and return the authorities or roles for the user
//    }
//
//    @Override
//    public String getPassword() {
//        // Trả về mật khẩu của người dùng
//        return user.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        // Trả về tên đăng nhập của người dùng
//        return user.getUsername();
//    }
//    public int getIsCustomer() {
//        return user.getIsCustomer();
//    }
//    @Override
//    public boolean isAccountNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return false;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return false;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        System.out.println("bi lock o day");
//        return false;
//    }
//}
//
