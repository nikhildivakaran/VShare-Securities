package com.virtusaproject.vsharesecurities.services;

import com.virtusaproject.vsharesecurities.database.UserData;
import com.virtusaproject.vsharesecurities.database.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional
public class VshareUserDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;

    public VshareUserDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserData userData = usersRepository.findByEmail(email);
        if (userData == null) {
            throw new UsernameNotFoundException(
                    "No user found with username: "+ email);
        }

        return new User (
                userData.getEmail(),
                userData.getPassword(),
                true,
                true,
                true,
                true,
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }
}
