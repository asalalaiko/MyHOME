package by.asalalaiko.myhome;


import by.asalalaiko.myhome.dto.User;
import by.asalalaiko.myhome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyhomeApplication {
	@Autowired
	UserService userService;

	public static void main(String[] args) {

		//SpringApplication.run(MyhomeApplication.class, args);
		ApplicationContext context = SpringApplication.run(MyhomeApplication.class, args);

		UserService userService = context.getBean(UserService.class);

		User user = new User();
		user.setLogin("user221");
		user.setPassword("admin");
		userService.addUser(user);

	}

}
