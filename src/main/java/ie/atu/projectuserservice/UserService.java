package ie.atu.projectuserservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepo;

    @Autowired
    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void createUser(CreateUser user) {
        userRepo.save(user);
    }

    public boolean authenticate(String email, String password) {
        //Optional allows it to be null and such
        Optional<CreateUser> optionalUser = userRepo.findByEmail(email);

        //i find this quite hard to undersstand on glance might change later with an if else
        return optionalUser.map(user -> user.getPassword().equals(password)).orElse(false);
    }

    public boolean existsByEmail(String email) {
        return userRepo.existsByEmail(email);
    }
}
