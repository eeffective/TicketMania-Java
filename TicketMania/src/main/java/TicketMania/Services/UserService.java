package TicketMania.Services;

import TicketMania.Entities.User;
import TicketMania.Models.UserDetailsImpl;
import TicketMania.Repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;


@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return UserDetailsImpl.build(user);
    }

    public Optional<User> findByUsername(String username) {
        return this.userRepo.findByUsername(username);
    }

    public User findByFirstNameAndLastName(String firstName, String lastName) {
        return this.userRepo.findByFirstNameAndLastName(firstName, lastName);
    }

    public boolean existsByEmail(String email) {
        return userRepo.existsByEmail(email);
    }

    public boolean existsByUsername(String username) {
        return userRepo.existsByUsername(username);
    }

    public void create(User user) {
        try {
            this.userRepo.save(user);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    public Collection<User> findAll(){
       return this.userRepo.findAll();
    }
}
