package by.asalalaiko.myhome.users;

import by.asalalaiko.myhome.dto.User;
import by.asalalaiko.myhome.dto.UserRole;
import by.asalalaiko.myhome.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Before
    public void init(){
        User user = new User();
        user.setLogin("user1");
        user.setPassword("user1");
        userService.addUser(user);
    }

    @Test
    public void getUserByLogin() {
        assertEquals(userService.getUserByLogin("user1").getLogin(), "user1");
    }

    @Test
    public void getUserById() {
        assertEquals(userService.getUser(1l).getLogin(), "user1");
    }

    @Test
    public void saveUser() {
        User user = new User();
        user.setLogin("saveUser");
        user.setPassword("user");
        userService.addUser(user);
        user.setLogin("changeUser");
        userService.saveUser(user);

        assertEquals(userService.getUser(user.getId()).getLogin(), "changeUser");
        userService.deleteUser(user.getId());
    }


    @Test
    public void addUser() {

        User user = new User();
        user.setLogin("user");
        user.setPassword("user");
        user.setRole(UserRole.USER);

        userService.addUser(user);

        assertEquals(userService.getUserByLogin("user").getLogin(), "user");
        userService.deleteUser(user.getId());
    }

    @Test
    public void delUser() {

        User user = new User();
        user.setLogin("userDel");
        user.setPassword("user");
        userService.addUser(user);
        userService.deleteUser(user.getId());

        assertEquals(userService.getUserByLogin("userDel"), null);
    }

    @Test
    public void getAllUsers() {

        for(int i = 0; i<100; i++){
            User user =  new User();
            user.setLogin("user"+ i);
            user.setPassword("123");
            userService.addUser(user);
        }
        assertEquals(userService.findAllUsers().size(), 100);
    }

}
