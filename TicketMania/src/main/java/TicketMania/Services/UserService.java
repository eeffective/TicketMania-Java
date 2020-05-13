package TicketMania.Services;

import TicketMania.Entities.User;
import TicketMania.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public User findByFirstNameAndLastName(String firstName, String lastName) {
        return this.userRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public void create(User user) {
        try {
            this.userRepository.save(user);
        } catch (Exception ex) {
            throw ex;
        }
    }
}
