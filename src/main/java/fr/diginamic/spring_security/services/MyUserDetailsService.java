package fr.diginamic.spring_security.services;

import fr.diginamic.spring_security.entities.UserApp;
import fr.diginamic.spring_security.repositories.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserDetailsService {
    @Autowired
    private UserAppRepository userAppRepository;

    public void createUser(String username, String password) {
        userAppRepository.save(new UserApp(username, password));
    }
}
