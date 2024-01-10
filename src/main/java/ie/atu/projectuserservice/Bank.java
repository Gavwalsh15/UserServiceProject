package ie.atu.projectuserservice;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bank {

    @Email(message = "Invalid email address")
    private String email;

    private float balance;
}
