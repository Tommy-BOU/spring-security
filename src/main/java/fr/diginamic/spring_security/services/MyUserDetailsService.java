//package fr.diginamic.spring_security.services;
//
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return new User(
//                "tbbk",
//                "test",
//                List.of(new SimpleGrantedAuthority("ROLE_ADMIN"))
//        );
//    }
//}
