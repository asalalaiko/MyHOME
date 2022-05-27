package by.asalalaiko.myhome;


import by.asalalaiko.myhome.dto.User;
import by.asalalaiko.myhome.dto.UserRole;
import by.asalalaiko.myhome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class MyhomeApplication extends SpringBootServletInitializer {

	@Autowired
	public static UserService userService;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MyhomeApplication.class);
	}

	public static void main(String[] args) {
		//SpringApplication.run(MyhomeApplication.class, args);
		ApplicationContext context = SpringApplication.run(MyhomeApplication.class, args);
		UserService userService = context.getBean(UserService.class);

		User user = new User();
		user.setLogin("User11");
		user.setPassword("user");
		user.setRole(UserRole.ADMIN);
		userService.addUser(user);

		System.out.println("List:");
		userService.findAllUsers().stream().forEach(s -> System.out.println(s.toString()));


	}

}
