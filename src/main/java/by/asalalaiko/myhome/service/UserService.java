package by.asalalaiko.myhome.service;

import by.asalalaiko.myhome.dto.User;

import java.util.List;

public interface UserService {

    User getUser (Long id);

     User getUserByLogin(String login);

    boolean addUser(User user);

    public void saveUser(User user);

    void deleteUser(Long id);

    public List<User> findAllUsers();
}
