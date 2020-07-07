package com.virtusaproject.vsharesecurities.services;

import com.virtusaproject.vsharesecurities.database.UserData;
import com.virtusaproject.vsharesecurities.database.UsersRepository;
import com.virtusaproject.vsharesecurities.exceptions.UserAlreadyExistException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;

        ///////////////////
        /**/    System.out.println();
        /**/    List<UserData> userData = usersRepository.findAll();
        /**/    if (userData.size() != 0) {
        /**/        userData.forEach(System.out::println);
        /**/    } else {
        /**/        System.out.println("No userData registered");
        /**/    }
        ///////////////////
    }

    @Transactional
    public void addUser(UserData userData) throws UserAlreadyExistException {
        if (getUserByEmail(userData.getEmail()) != null) {
            throw new UserAlreadyExistException("There is an account with that email address: " + userData.getEmail());
        }
        usersRepository.save(userData);
    }

    public UserData getUserByUID(Long uid) {
        return usersRepository.findById(uid).orElse(null);
    }

    public UserData getUserByEmail(String emailAddress) {
        return usersRepository.findByEmail(emailAddress);
    }
}
