package by.asalalaiko.myhome.users;

import by.asalalaiko.myhome.dto.User;
import by.asalalaiko.myhome.dto.UserRole;
import by.asalalaiko.myhome.repo.UserRepo;
import by.asalalaiko.myhome.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void saveUser() {

        User user = new User();
        user.setLogin("user");
        user.setPassword("user");
        user.setRole(UserRole.USER);
        System.out.println(user);
        userService.addUser(user);


        User user2 = new User();
        user = userService.getUser(2L);
        System.out.println(user);
        //assertEquals(user.getLogin(), "user");
        //assertEquals(userService.getUser(2L).getLogin(), "user");
    }



}
