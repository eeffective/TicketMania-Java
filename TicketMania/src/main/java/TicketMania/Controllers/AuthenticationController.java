package TicketMania.Controllers;

import TicketMania.Entities.Role;
import TicketMania.Entities.User;
import TicketMania.Enums.EResponse;
import TicketMania.Enums.ERole;
import TicketMania.JWT.Utilities.JwtUtil;
import TicketMania.Models.AuthenticationRequest;
import TicketMania.Models.AuthenticationResponse;
import TicketMania.Models.RegistrationRequest;
import TicketMania.Models.UserDetailsImpl;
import TicketMania.Services.RoleService;
import TicketMania.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtil jwtUtil;
    //  @Autowired
    //   private BCryptPasswordEncoder encoder;
    @Autowired
    private RoleService roleService;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationRequest model) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(model.getUsername(), model.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtil.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new AuthenticationResponse(
                jwt,
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getFirstName(),
                userDetails.getLastName(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest model) {
        if (userService.existsByUsername(model.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(EResponse.USERNAME_ALREADY_EXISTS.toString());
        }

        if (userService.existsByEmail(model.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(EResponse.EMAIL_ALREADY_EXISTS.toString());
        }

        User user = new User(
                model.getUsername(),
                model.getEmail(),
                model.getPassword(),  // TODO: Password hashing/encoding must be done [encoder.encode(model.getPassword())]
                model.getFirstName(),
                model.getLastName()
        );

        Set<String> strRoles = model.getRoles();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleService.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleService.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleService.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleService.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userService.create(user);

        return ResponseEntity.ok(EResponse.USER_SUCCESSFULLY_CREATED.toString());
    }

}
