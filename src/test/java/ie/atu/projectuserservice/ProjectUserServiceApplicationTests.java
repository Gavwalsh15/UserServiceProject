package ie.atu.projectuserservice;

import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class ProjectUserServiceApplicationTests {

	private static Validator validator;

	@BeforeAll
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	void createUser_ValidData_Success() {
		CreateUser user = new CreateUser(6L, "Billy Bob", "billybob@gmail.com", LocalDate.of(2002, 7, 28), "123 Main St", "password");

		assertThat(user.getId()).isEqualTo(6L);
		assertThat(user.getName()).isEqualTo("Billy Bob");
		assertThat(user.getEmail()).isEqualTo("billybob@gmail.com");
		assertThat(user.getBirthday()).isEqualTo(LocalDate.of(2002, 7, 28));
		assertThat(user.getAddress()).isEqualTo("123 Main St");
		assertThat(user.getPassword()).isEqualTo("password");
	}

	@Test
	void createUser_ValidDataToString_Success() {
		CreateUser user = new CreateUser(6L, "Billy Bob", "billybob@gmail.com", LocalDate.of(2002, 7, 28), "123 Main St", "password");
		String toStringResult = user.toString();
		assertThat(toStringResult).contains("Billy Bob", "billybob@gmail.com", "123 Main St");
	}

	@Test
	public void testNameTooShort() {
		CreateUser user = new CreateUser(6L, "B", "billybob@gmail.com",
				LocalDate.of(2002, 7, 28), "123 Main St", "password");

		assertFalse(validator.validate(user).isEmpty());
	}

	@Test
	public void testInvalidEmail() {
		CreateUser user = new CreateUser(6L, "Billy Bob", "invalid",
				LocalDate.of(2002, 7, 28), "123 Main St", "password");

		assertFalse(validator.validate(user).isEmpty());
	}

	@Test
	public void testAddressNotBlank(){
		CreateUser user = new CreateUser(6L, "Billy Bob", "billybob@gmail.com",
				LocalDate.of(2002, 7, 28), "", "password");

		assertFalse(validator.validate(user).isEmpty());
	}

	@Test
	public void testPasswordTooShort(){
		CreateUser user = new CreateUser(6L, "Billy Bob", "billybob@gmail.com",
				LocalDate.of(2002, 7, 28), "123 Main St", "pa");

		assertFalse(validator.validate(user).isEmpty());
	}

}
