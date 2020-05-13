package TicketMania.Services;

import TicketMania.Entities.ApplicationUser;
import TicketMania.Repositories.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class ApplicationUserService {

    private final ApplicationUserRepository userRepository;

    @Autowired
    public ApplicationUserService(ApplicationUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public ApplicationUser findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    public ApplicationUser findByFirstNameAndLastName(String firstName, String lastName) {
        return this.userRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public void create(ApplicationUser user) {
        try {
            this.userRepository.save(user);
        } catch (Exception ex) {
            throw ex;
        }
    }
}
