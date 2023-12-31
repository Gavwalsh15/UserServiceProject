package ie.atu.projectuserservice;

import jakarta.validation.constraints.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity//idk what this does but it fix my error
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name Cannot be Blank")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    @Email(message = "Invalid email address")
    private String email;

    // Has to be in the form YY-MM-DD no other way okie!
    @NotNull(message = "Birthday cannot be blank")
    private LocalDate birthday;

    @NotBlank(message = "Address Cannot be Blank")
    private String address;

    @NotBlank(message = "Password Cannot be Blank")
    @Size(min = 8, message = "Password must be at least 8 characters")
    private String password;
}
