package TicketMania.Services;

import TicketMania.Entities.Role;
import TicketMania.Enums.ERole;
import TicketMania.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private final RoleRepository roleRepo;

    public RoleService(RoleRepository roleRepo){
        this.roleRepo = roleRepo;
    }

    public Optional<Role> findByName(ERole name){
        return this.roleRepo.findByName(name);
    }
}
