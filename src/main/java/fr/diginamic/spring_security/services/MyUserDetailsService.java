package fr.diginamic.spring_security.services;

import fr.diginamic.spring_security.entities.UserApp;
import fr.diginamic.spring_security.repositories.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserAppRepository userAppRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserApp user = userAppRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return User.builder()
                .username(user.getUsername())
                .password("{noop}" + user.getPassword())
                .roles("USER")
                .build();
    }

    public void createUser(String username, String password) {
        userAppRepository.save(new UserApp(username, password));
    }
}
