package TicketMania.Controllers;

import TicketMania.Entities.ApplicationUser;
import TicketMania.Services.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(path = "/authenticate")
public class ApplicationUserController {
    @Autowired
    private final ApplicationUserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public ApplicationUserController(ApplicationUserService userService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping("/register")
    public void signUp(@RequestBody ApplicationUser user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.create(user);
    }



//    @PostMapping(path = "/login")
//    public ResponseEntity login(@Valid @RequestBody UserLoginModel userLoginModel) {
//        try {
//            User user = userService.findByEmail(userLoginModel.getEmail());
//            if (user == null) {
//                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, CustomResponse.USER_DOES_NOT_EXIST.toString());
//            } else if (!userLoginModel.getPassword().equals(user.getPassword())) {
//                return new ResponseEntity(HttpStatus.BAD_REQUEST);
//            }
//            return ResponseEntity.ok(userLoginModel);
//        } catch (Exception ex) {
//            return new ResponseEntity(HttpStatus.BAD_REQUEST);
//        }
//    }

//    @PostMapping(path = "/register")
////    public ResponseEntity register(@Valid @RequestBody UserRegistrationModel userRegistrationModel) {
////        if (userService.findByEmail(userRegistrationModel.getEmail()) != null) {
////            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, CustomResponse.USER_ALREADY_EXISTS.toString());
////        }
////        try {
////            User user = new User();
////            user.setFirstName(userRegistrationModel.getFirstName());
////            user.setFirstName(userRegistrationModel.getLastName());
////            user.setEmail(userRegistrationModel.getEmail());
////            user.setPassword(userRegistrationModel.getPassword());
////            userService.create(user);
////            return new ResponseEntity(user, HttpStatus.OK);
////        } catch (Exception ex) {
////            ex.printStackTrace();
////            return new ResponseEntity(HttpStatus.BAD_REQUEST);
////        }
////    }


}
