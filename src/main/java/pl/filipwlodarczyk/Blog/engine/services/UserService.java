package pl.filipwlodarczyk.Blog.engine.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.filipwlodarczyk.Blog.engine.models.Sex;
import pl.filipwlodarczyk.Blog.engine.models.User;
import pl.filipwlodarczyk.Blog.engine.repositories.UserRepository;
import pl.filipwlodarczyk.Blog.engine.security.ApplicationPermission;
import pl.filipwlodarczyk.Blog.engine.security.ApplicationRole;

import java.util.Calendar;
import java.util.Date;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(@Qualifier("user_repo") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public void addAdmin() {
        User FilipAdmin = new User("Filip",
                "password",
                "filipwlodarczyk99@gmail.com",
                new Date(1999),
                Sex.MALE, true,
                true, true,
                true,
                ApplicationRole.ADMIN.getGrantedAuthorities());

        userRepository.save(FilipAdmin);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.selectApplicationUserByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("Username %s not found", username)));
    }

//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return userRepository.selectApplicationUserByUsername(username)
//                .orElseThrow(() ->
//                        new UsernameNotFoundException(String.format("Username %s not found", username)));
//    }



}
