package com.itacademy.service.service;

import com.itacademy.database.entity.User;
import com.itacademy.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.HashSet;
import java.util.Set;


@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@SessionAttributes({"currentUser"})
public class UserLoginServiceImpl implements UserLoginService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername( String s) throws UsernameNotFoundException {
        User currentUser = userRepository.findByLogin(s);
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(currentUser.getRole().name()));

        return org.springframework.security.core.userdetails.User
                .builder()
                .username(currentUser.getLogin())
                .password(currentUser.getPassword())
                .authorities(authorities)
                .build();
    }
}
