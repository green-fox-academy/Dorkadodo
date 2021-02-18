package com.greenfoxacademy.projectweekzero.service;

import com.greenfoxacademy.projectweekzero.model.MyUser;
import com.greenfoxacademy.projectweekzero.model.MyUserDetails;
import com.greenfoxacademy.projectweekzero.repo.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private MyUserRepository myUserRepository;

    @Override
    public MyUserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<MyUser> user = myUserRepository.findByUsername(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return user.map(MyUserDetails::new).get();
    }
}