package ie.atu.projectuserservice;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface UserRepository extends JpaRepository<CreateUser, Long> {
    Optional<CreateUser> findByEmail(String email);

    boolean existsByEmail(String email);
}
