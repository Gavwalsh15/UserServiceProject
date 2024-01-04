package ie.atu.projectuserservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")//api fancy word
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@Valid @RequestBody CreateUser user) {
        String email = user.getEmail();

        // Check if the email already exists in the database
        if (userService.existsByEmail(email)) {
            return new ResponseEntity<>("Email already exists", HttpStatus.BAD_REQUEST);
        }

        // If the email doesn't exist, proceed with creating the user
        userService.createUser(user);

        return new ResponseEntity<>("User successfully created", HttpStatus.CREATED);
    }


    @PostMapping("/signin")
    public ResponseEntity<String> signIn(@Valid @RequestBody SignIn signInRequest) {

        boolean emailExists = userService.existsByEmail(signInRequest.getEmail());

        if (!emailExists){
            return new ResponseEntity<>("Email Doesn't Exist", HttpStatus.UNAUTHORIZED);
        }

        boolean correctCredentials = userService.authenticate(signInRequest.getEmail(), signInRequest.getPassword());

        if (correctCredentials) {
            return new ResponseEntity<>("User successfully signed in", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }
    }
}

