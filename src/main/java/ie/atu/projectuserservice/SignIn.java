package ie.atu.projectuserservice;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignIn {

    @Email(message = "Invalid email address")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    private String password;
}
