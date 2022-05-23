package by.asalalaiko.myhome;

import by.asalalaiko.myhome.dto.User;
import by.asalalaiko.myhome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyhomeApplication {

	@Autowired
	public static UserService userService;


	public static void main(String[] args) {

		SpringApplication.run(MyhomeApplication.class, args);

		User user = new User();
		user.setLogin("admin");
		user.setPassword("admin");
		userService.addUser(user);
	}

}
