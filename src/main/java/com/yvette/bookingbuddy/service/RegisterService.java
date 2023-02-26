package com.yvette.bookingbuddy.service;

import com.yvette.bookingbuddy.model.Authority;
import com.yvette.bookingbuddy.model.User;
import com.yvette.bookingbuddy.model.UserRole;
import com.yvette.bookingbuddy.repository.AuthorityRepository;
import com.yvette.bookingbuddy.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterService {
    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;
    private PasswordEncoder passwordEncoder;

    //automatically inject the instances
    @Autowired
    public RegisterService(UserRepository userRepository, AuthorityRepository authorityRepository){
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }
    //success or fail in the sametime.
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void add(User user, UserRole role) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        userRepository.save(user);
        authorityRepository.save(new Authority(user.getUsername(), role.name()));
    }
}
